package com.example.labs.giis_3.obj

import kotlin.math.sqrt

data class Point(var x: Int, var y: Int)

fun Point(x: Float, y: Float) = Point(x.toInt(), y.toInt())

val Pair<Float, Float>.x
	get() = first
val Pair<Float, Float>.y
	get() = second
val Pair<Float, Float>.length
	get() = sqrt(x * x + y * y)

fun Pair<Float, Float>.normalized() = this / length

operator fun Point.times(k: Float) = Point(x * k, y * k)
operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)

operator fun Pair<Float, Float>.times(k: Float) = Pair(x * k, y * k)
operator fun Point.plus(other: Pair<Float, Float>) = Point(x + other.x, y + other.y)

operator fun Point.div(k: Float) = this * (1 / k)
operator fun Pair<Float, Float>.div(k: Float) = this * (1 / k)
