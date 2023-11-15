package org.example.qmplicer

import org.apache.commons.math.linear.MatrixUtils
import kotlin.math.sqrt

data class Qbit(val a0: Complex, val a1: Complex) {

	init {
		require(equals(p0 + p1, 1.0)) { "$p0 + $p1 == 1" }
	}

	override fun toString() = "$p0 $p1"
}

fun Qbit() = Qbit(Complex(1f), Complex())

val Qbit.p0
	get() = sqr(abs(a0))
val Qbit.p1
	get() = sqr(abs(a1))
private val inv_sqrt_2 = 1 / sqrt(2.0)

fun RegistryContext.not(index: Int) = map(
	index, MatrixUtils.createRealMatrix(
		arrayOf(
			doubleArrayOf(0.0, 1.0),
			doubleArrayOf(1.0, 0.0),
		)
	)
)

fun RegistryContext.inv(index: Int) = map(
	index, MatrixUtils.createRealMatrix(
		arrayOf(
			doubleArrayOf(1.0, 0.0),
			doubleArrayOf(0.0, -1.0),
		)
	)
)

fun RegistryContext.amdal(index: Int) = map(
	index, MatrixUtils.createRealMatrix(
		arrayOf(
			doubleArrayOf(inv_sqrt_2, inv_sqrt_2),
			doubleArrayOf(inv_sqrt_2, -inv_sqrt_2),
		)
	)
)

//fun RegistryContext.and(a: Int, b: Int, result: Int) {
//	not(a)
//	not(b)
//	or(a, b, result)
//	not(a)
//	not(b)
//	not(result)
//}
//fun RegistryContext.or(a: Int, b: Int, result: Int) {
//	cnot(a, result)
//	cnot(b, result)
//}
//
//fun RegistryContext.xor(a: Int, b: Int, result: Int) {
//	cnot(a, result)
//	cnot(b, result)
//}
//
//fun RegistryContext.swap(a: Int, b: Int) {
//	cnot(b, a)
//	cnot(a, b)
//	cnot(b, a)
//}
fun RegistryContext.cnot(indexA: Int, indexB: Int) = map(
	indexA, indexB, MatrixUtils.createRealMatrix(
		arrayOf(
			doubleArrayOf(1.0, 0.0, 0.0, 0.0),
			doubleArrayOf(0.0, 1.0, 0.0, 0.0),
			doubleArrayOf(0.0, 0.0, 0.0, 1.0),
			doubleArrayOf(0.0, 0.0, 1.0, 0.0),
		)
	)
)

fun RegistryContext.swap(indexA: Int, indexB: Int) {
	val matrix = MatrixUtils.createRealMatrix(
		arrayOf(
			doubleArrayOf(1.0, 0.0, 0.0, 0.0),
			doubleArrayOf(0.0, 0.0, 1.0, 0.0),
			doubleArrayOf(0.0, 1.0, 0.0, 0.0),
			doubleArrayOf(0.0, 0.0, 0.0, 1.0),
		)
	)
	if(indexA < indexB)
		map(indexA, indexB, matrix)
	else
		map(indexB, indexA, matrix)
}

fun RegistryContext.swap(index: Int) = map(
	index,
	MatrixUtils.createRealMatrix(
		arrayOf(
			doubleArrayOf(1.0, 0.0, 0.0, 0.0),
			doubleArrayOf(0.0, 0.0, 1.0, 0.0),
			doubleArrayOf(0.0, 1.0, 0.0, 0.0),
			doubleArrayOf(0.0, 0.0, 0.0, 1.0),
		)
	)
)

fun Qbit.not() = Qbit(a1, a0)
fun Qbit.inv() = Qbit(a0, -a1)
fun Qbit.amdal() = Qbit(a0 * inv_sqrt_2 + a1 * inv_sqrt_2, a0 * inv_sqrt_2 - a1 * inv_sqrt_2)

data class SuperPosition(
	val a00: Complex,
	val a01: Complex,
	val a10: Complex,
	val a11: Complex,
)

fun SuperPosition(q0: Qbit, q1: Qbit): SuperPosition {
	val a00 = q0.a0 * q1.a0
	val a01 = q0.a0 * q1.a1
	val a10 = q0.a1 * q1.a0
	val a11 = q0.a1 * q1.a1
	return SuperPosition(a00, a01, a10, a11)
}

fun SuperPosition.cnot(): SuperPosition {
	return SuperPosition(a00, a01, a11, a10)
}



