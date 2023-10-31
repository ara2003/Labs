#version 330 core

layout (location = 0) in vec3 aPos;
layout (location = 1) in vec3 aNorm;

uniform mat4 model;
uniform mat4 projection;

out vec3 normal;

void main()
{
    normal = mat3(transpose(inverse(model))) * aNorm;
    gl_Position = projection * model * vec4(aPos, 1.0);
}