package com.example.labs.giis_7.obj

import kotlin.math.floor
import kotlin.math.sqrt

data class Triangle(
	val a: Point,
	val b: Point,
	val c: Point,
)

val Triangle.center
	get() = crossProduct(Line(a, b).perpendicular, Line(a, c).perpendicular) ?: (a + b + c) / 3
val Triangle.radius
	get() = distance(center, a)

fun distanceSqr(a: Point, b: Point): Int {
	val dx = a.x - b.x
	val dy = a.y - b.y
	return dx * dx + dy * dy
}

fun distance(a: Point, b: Point): Int {
	return (floor(sqrt(distanceSqr(a, b) + 0.0)) + 0.5).toInt()
}
