package org.example.qmplicer

import kotlin.math.sqrt

data class Complex(val re: Double, val im: Double) {

	override fun toString() =
		if(equals(im, 0.0))
			"$re"
		else
			"$re + ${im}i"
}

fun Complex(re: Number, im: Number) = Complex(re.toDouble(), im.toDouble())

fun equals(a: Double, b: Double) = kotlin.math.abs(a - b) < 1E-6

fun Complex() = Complex(0f, 0f)
fun Complex(re: Float) = Complex(re, 0f)
val I = Complex(0f, 1f)
val Complex.a
	get() = re
val Complex.b
	get() = im

fun abs(value: Complex) = sqrt(value.re * value.re + value.im * value.im)

operator fun Complex.unaryMinus() = Complex(-re, -im)

operator fun Complex.plus(other: Complex) = Complex(re + other.re, im + other.im)
operator fun Complex.plus(other: Double) = Complex(re + other, im)
operator fun Double.plus(other: Complex) = other + this
operator fun Complex.minus(other: Complex) = this + -other
operator fun Complex.minus(other: Double) = this + -other
operator fun Double.minus(other: Complex) = other - this

operator fun Complex.times(other: Complex) = Complex(re * other.re - im * other.im, re * other.im + im * other.re)
operator fun Complex.times(other: Double) = Complex(re * other, im * other)
operator fun Double.times(other: Complex) = other * this
operator fun Complex.div(other: Complex) = this * other.conjugate() / (sqr(other.re) + sqr(other.im))
operator fun Complex.div(other: Double) = Complex(re / other, im / other)

fun Complex.conjugate() = Complex(re, -im)

fun sqr(x: Complex) = x * x
fun sqr(x: Double) = x * x

fun Iterable<Complex>.sum() = fold(Complex()) { a, b -> a + b }
fun <T> Iterable<T>.sumOf(block: (T) -> Complex) = fold(Complex()) { a, b -> a + block(b) }

fun Iterable<Complex>.times() = fold(Complex(1f)) { a, b -> a * b }
fun <T> Iterable<T>.timesOf(block: (T) -> Complex) = fold(Complex(1f)) { a, b -> a * block(b) }



