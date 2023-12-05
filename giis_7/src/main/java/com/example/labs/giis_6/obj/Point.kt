package com.example.labs.giis_6.obj

import kotlin.math.sqrt

data class Point(var x: Int, var y: Int)

fun Point(x: Float, y: Float) = Point(x.toInt(), y.toInt())

val Pair<Float, Float>.x
	get() = first
val Pair<Float, Float>.y
	get() = second
val Pair<Float, Float>.length
	get() = sqrt(x * x + y * y)

fun Pair<Float, Float>.normalized() = if(length != 0f) this / length else this
operator fun Pair<Float, Float>.times(other: Pair<Float, Float>) = x * other.y - y * other.x
operator fun Pair<Float, Float>.unaryMinus() = Pair(-x, -y)
operator fun Pair<Float, Float>.times(k: Float) = Pair(x * k, y * k)

operator fun Point.plus(other: Pair<Float, Float>) = Point(x + other.x, y + other.y)

operator fun Point.minus(other: Point) = Pair(x - other.x + 0f, y - other.y + 0f)
operator fun Point.times(k: Float) = Point(x * k, y * k)
operator fun Point.times(other: Point) = x * other.y - y * other.x
operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)
operator fun Point.div(k: Float) = this * (1 / k)
operator fun Point.div(k: Int) = Point(x / k, y/ k)
operator fun Pair<Float, Float>.div(k: Float) = this * (1 / k)



fun Iterable<Point>.sum() = fold(Point(0, 0)) { a, b -> a + b }
val Iterable<*>.size get() = fold(0) { size, _ -> size + 1 }
