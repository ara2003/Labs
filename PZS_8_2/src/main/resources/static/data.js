async function sfetch(url, init) {
    if (!localStorage.getItem("token"))
        await refreshToken()
    if (init === undefined)
        init = {}
    if (init.headers === undefined)
        init.headers = {}
    init.credentials = "include"
    init.headers.Authorization = `Bearer ${localStorage.getItem("token")}`
    let response = await fetch(url, init)
    if (response.status === 401) {
        await refreshToken()
        response = await fetch(url, init)
    }
    if (response.ok)
        return response
    localStorage.removeItem("token")
    return Promise.reject(response)
}

async function isAuthorized() {
    if (!localStorage.getItem("token"))
        return false
    return fetch('/auth/isAuthorized', {
        headers: {
            'Authorization': `Bearer ${localStorage.getItem("token")}`
        }
    }).then(resp => {
        if (resp.ok)
            return resp.json()
        return Promise.reject(resp)
    }).then(json => json.value, error => localStorage.removeItem("token"))
}

function setJWTToken(json) {
    localStorage.setItem('token', json["access"])
}

async function signin(username, password) {
    return fetch('/auth/signin', {
        method: 'POST',
        body: JSON.stringify({
            username: username,
            password: password
        }),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => {
        if (resp.ok)
            return resp.json()
        return Promise.reject(resp)
    }).then(setJWTToken)
}

async function signup(username, password) {
    return fetch('/auth/signup', {
        method: 'POST',
        body: JSON.stringify({
            username: username,
            password: password
        }),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => {
        if (resp.ok)
            return resp.json()
        return Promise.reject(resp)
    }).then(setJWTToken)
}

async function refreshToken() {
    return fetch('/auth/refreshToken', {
        method: 'POST',
        credentials: 'include'
    }).then(resp => {
        if (resp.status === 401) {
            window.location.replace(`/sign-in`);
        }
        return resp.json()
    }).then(setJWTToken)
}

async function logout() {
    return fetch(`/auth/logout`, {
        method: "POST",
        credentials: 'include'
    }).then((response) => {
        localStorage.removeItem('token')
    })
}

async function getMe() {
    return sfetch(`/api/users/me`).then(resp => resp.json())
}

async function getUser(id) {
    return fetch(`/api/users/${id}`).then(resp => resp.json())
}

async function getUsers() {
    return fetch(`/api/users`).then(resp => resp.json())
}

async function replaceUser(user) {
    return sfetch(`/api/users/me`, {
        method: 'PUT',
        body: JSON.stringify(user),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => resp.json())
}

async function deleteUser() {
    return sfetch(`/api/users/me`, {
        method: 'DELETE'
    }).then(resp => resp.json())
}

async function createArticle(article) {
    return sfetch(`/api/articles`, {
        method: 'POST',
        body: JSON.stringify(article),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => resp.json())
}

async function getArticle(id) {
    return fetch(`/api/articles/${id}`).then(resp => resp.json())
}

async function getArticles() {
    return fetch(`/api/articles`).then(resp => resp.json())
}

async function replaceArticle(id, article) {
    return sfetch(`/api/articles/${id}`, {
        method: 'PUT',
        body: JSON.stringify(article),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => resp.json())
}

async function deleteArticle(id) {
    return sfetch(`/api/articles/${id}`, {
        method: 'DELETE'
    })
}

async function createComment(articleId, text) {
    return sfetch(`/api/comments`, {
        method: 'POST',
        body: JSON.stringify({
            "articleId": articleId,
            "text": text
        }),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => resp.json())
}

async function getComment(id) {
    return fetch(`/api/comments/${id}`).then(resp => resp.json())
}

async function getComments() {
    return fetch(`/api/comments`).then(resp => resp.json())
}

async function replaceComment(id, article) {
    return sfetch(`/api/comments/${id}`, {
        method: 'PUT',
        body: JSON.stringify(article),
        headers: {
            "Content-Type": "application/json",
        }
    }).then(resp => resp.json())
}

async function deleteComment(id) {
    return sfetch(`/api/comments/${id}`, {
        method: 'DELETE'
    })
}

