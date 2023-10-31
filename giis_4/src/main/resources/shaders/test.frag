#version 330 core

#define ALPHA 0.4

out vec4 color;

in vec3 normal;

struct Material {
    vec3 color;
};

uniform Material material;

void main()
{
    float c = dot(normalize(normal), normalize(-vec3(0, -1, -1)));
    c = max(0, c);
    c = (1 - ALPHA) * c + ALPHA;
    color = vec4(material.color * c, 1);
}