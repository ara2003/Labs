package com.example.labs.giis_4

import com.example.labs.giis_4.assimp.AssimpMesh
import com.greentree.commons.data.resource.Resource
import com.greentree.commons.data.resource.location.ClassLoaderResourceLocation
import org.joml.Matrix4f
import org.joml.Vector3f
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL40.*
import org.lwjgl.system.MemoryStack
import java.io.FileNotFoundException
import java.io.IOException
import java.lang.Thread.*
import kotlin.math.max
import kotlin.system.exitProcess

fun main() {
	Main().main()
}

const val SCALE = .9f
const val INV_SCALE = 1f / SCALE

class Main {

	fun main() {
		val mesh = loadMesh(resources.getResource("box.obj"))

		glfwInit()

		glfwDefaultWindowHints()

		glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE)
		glfwWindowHint(GLFW_SAMPLES, 4)
		val window = glfwCreateWindow(1920, 1200, "giis 4", glfwGetPrimaryMonitor(), 0)
		glfwMakeContextCurrent(window)
		GL.createCapabilities(false)
		glfwSwapInterval(1)
		glfwSetWindowSizeCallback(window) { _, x, y -> glViewport(0, 0, x, y) }
		val vao = vao(mesh)
		val program = program(
			VERTEX_SHADER,
			FRAGMENT_SHADER
		)

		glUseProgram(program)
		glBindVertexArray(vao)

		glUniform3f(glGetUniformLocation(program, "material.color"), 1f, 1f, 0f)
		val position = Vector3f(0f, 0f, -10f)
		val scale = Vector3f(1f, 1f, 1f)
		val rotation = Vector3f(0f, 0f, 0f)

		glfwSetKeyCallback(window) { w, key, _, action, _ ->
			if(action != GLFW_RELEASE) {
				when(key) {
					GLFW_KEY_ESCAPE -> exitProcess(1)
					GLFW_KEY_D -> position.x += .1f
					GLFW_KEY_A -> position.x -= .1f
					GLFW_KEY_C -> position.y += .1f
					GLFW_KEY_LEFT_SHIFT -> position.y -= .1f
					GLFW_KEY_S -> position.z += .1f
					GLFW_KEY_W -> position.z -= .1f
					GLFW_KEY_UP -> rotation.x += .1f
					GLFW_KEY_DOWN -> rotation.x -= .1f
					GLFW_KEY_RIGHT -> rotation.y += .1f
					GLFW_KEY_LEFT -> rotation.y -= .1f
					GLFW_KEY_N -> rotation.z += .1f
					GLFW_KEY_M -> rotation.z -= .1f
					GLFW_KEY_1 -> scale.x *= SCALE
					GLFW_KEY_2 -> scale.x /= SCALE
					GLFW_KEY_3 -> scale.y *= SCALE
					GLFW_KEY_4 -> scale.y /= SCALE
					GLFW_KEY_5 -> scale.z *= SCALE
					GLFW_KEY_6 -> scale.z /= SCALE
				}
			}
		}
		val stars = mutableListOf<Pair<Float, Float>>()
		repeat(120) {
			stars.add(Pair(2 * Math.random().toFloat() - 1, 2 * Math.random().toFloat() - 1))
		}
		var last = System.nanoTime()
		while(!glfwWindowShouldClose(window)) {
			val width = IntArray(1)
			val height = IntArray(1)
			glfwGetWindowSize(window, width, height)
			val now = System.nanoTime()
			var delta = (now - last) / 1_000_000_000f
			last = now
			sleep(max(0f, (1000f / 60) - delta).toLong())
			val model = Matrix4f()
			model.translate(position)
			model.rotateXYZ(rotation)
			model.scale(scale)
			setUniform(program, "model", model)
			val m = 0.001f
			val w = 1.0f * m
			val h = height[0] * w / width[0]
			val projection = Matrix4f().frustum(-w, w, -h, h, m, 10000.0f)
			setUniform(program, "projection", projection)
			glClear(GL_DEPTH_BUFFER_BIT or GL_COLOR_BUFFER_BIT)
			glUseProgram(0)
			glBindVertexArray(0)
			glDisable(GL_DEPTH_TEST)
			glBegin(GL_POINTS)
			for(star in stars) {
				glVertex2f(star.first, star.second)
			}
			glEnd()
			glEnable(GL_DEPTH_TEST)
			glUseProgram(program)
			glBindVertexArray(vao)

			glDrawArrays(GL_TRIANGLES, 0, mesh.mNumFaces() * 3)
			glfwSwapBuffers(window)
			glfwPollEvents()
		}

		glfwTerminate()
	}

	private fun setUniform(program: Int, name: String, matrix: Matrix4f) {
		MemoryStack.create(Float.SIZE_BYTES * 16).push().use { stack ->
			val buffer = stack.mallocFloat(16)
			matrix.get(buffer)
			glUniformMatrix4fv(glGetUniformLocation(program, name), false, buffer)
		}
	}

	private val resources = ClassLoaderResourceLocation()
	private val VERTEX_SHADER =
		readText("shaders/test.vert")
	private val FRAGMENT_SHADER: String =
		readText("shaders/test.frag")

	private fun readText(resource: String) = readText(resources.getResource(resource))

	private fun readText(resource: Resource): String {
		return try {
			resource.open().use { String(it.readAllBytes()) }
		} catch(e: FileNotFoundException) {
			throw RuntimeException(e)
		} catch(e: IOException) {
			throw RuntimeException(e)
		}
	}

	fun vao(mesh: AssimpMesh): Int {
		val verticesList = mutableListOf<Float>()
		val normaslList = mutableListOf<Float>()
		for(face in mesh.mFaces()) {
			for(index in face.mIndices()) {
				for(x in mesh.mVertices(index)) {
					verticesList.add(x)
				}
				for(x in mesh.mNormals(index)) {
					normaslList.add(x)
				}
			}
		}
		val vertices = verticesList.toTypedArray().toFloatArray()
		val normals = normaslList.toTypedArray().toFloatArray()
		val vbo = glGenBuffers()
		glBindBuffer(GL_ARRAY_BUFFER, vbo)
		MemoryStack.create(vertices.size * Float.SIZE_BYTES * 2).push().use { stack ->
			glBufferData(
				GL_ARRAY_BUFFER,
				stack.floats(*vertices),
				GL_STATIC_DRAW
			)
		}
		glBindBuffer(GL_ARRAY_BUFFER, 0)
		val nbo = glGenBuffers()
		glBindBuffer(GL_ARRAY_BUFFER, nbo)
		MemoryStack.create(vertices.size * Float.SIZE_BYTES * 2).push().use { stack ->
			glBufferData(
				GL_ARRAY_BUFFER,
				stack.floats(*normals),
				GL_STATIC_DRAW
			)
		}
		glBindBuffer(GL_ARRAY_BUFFER, 0)
		val vao = glGenVertexArrays()
		glBindVertexArray(vao)

		glBindBuffer(GL_ARRAY_BUFFER, vbo)
		glEnableVertexAttribArray(0)
		glVertexAttribPointer(0, 3, GL_FLOAT, false, 3 * 4, 0)
		glBindBuffer(GL_ARRAY_BUFFER, 0)
		glBindBuffer(GL_ARRAY_BUFFER, nbo)
		glEnableVertexAttribArray(1)
		glVertexAttribPointer(1, 3, GL_FLOAT, false, 3 * 4, 0)
		glBindBuffer(GL_ARRAY_BUFFER, 0)

		glBindVertexArray(0)
		return vao
	}

	private fun checkShaderCompileStatus(id: Int) {
		val errc = intArrayOf(1)
		glGetShaderiv(id, GL_COMPILE_STATUS, errc)
		check(0 != errc[0]) { String.format("Error creating shader: %s", glGetShaderInfoLog(id)) }
	}

	private fun program(vertexText: String, fragmentText: String): Int {
		val v = glCreateShader(GL_VERTEX_SHADER)
		glShaderSource(v, vertexText)
		glCompileShader(v)
		checkShaderCompileStatus(v)
		val f = glCreateShader(GL_FRAGMENT_SHADER)
		glShaderSource(f, fragmentText)
		glCompileShader(f)
		checkShaderCompileStatus(f)
		val program = glCreateProgram()
		glAttachShader(program, v)
		glAttachShader(program, f)
		glLinkProgram(program)
		glDeleteShader(v)
		glDeleteShader(f)
		glValidateProgram(program)
		return program
	}
}