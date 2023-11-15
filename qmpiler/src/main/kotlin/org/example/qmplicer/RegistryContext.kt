package org.example.qmplicer

import org.apache.commons.math.linear.MatrixUtils
import org.apache.commons.math.linear.RealMatrix

interface RegistryContext {

	val size: Int

	fun map(matrix: RealMatrix)
}

fun RegistryContext.map(matrix: List<RealMatrix>) = map(MatrixKroneckerProductUtils.getKroneckerProduct(matrix))

fun RegistryContext.map(index: Int, matrix: RealMatrix) {
	require(matrix.isSquare)
	val matrixs = ArrayList<RealMatrix>(size)
	repeat(size) {
		matrixs.add(MatrixUtils.createRealDiagonalMatrix(doubleArrayOf(1.0, 1.0)))
	}
	matrixs[index] = matrix
	repeat(matrix.rowDimension / 2 - 1) {
		matrixs.removeAt(index + it + 1)
	}
	map(matrixs)
}

fun RegistryContext.map(indexA: Int, indexB: Int, matrix: RealMatrix) {
	if(indexA < indexB) {
		(indexA + 1 ..< indexB).reversed().forEach {
			swap(it)
		}
		map(indexA, matrix)
		(indexA + 1 ..< indexB).forEach {
			swap(it)
		}
	} else {
		(indexB ..< indexA).forEach {
			swap(it)
		}
		map(indexA - 1, matrix)
		(indexB ..< indexA).reversed().forEach {
			swap(it)
		}
	}
}

private val ZERO = Complex()

fun registry(qbits: Int, block: RegistryContext.() -> Unit): Array<Double> {
	var values = Array(pow(2, qbits)) {
		ZERO
	}
	values[0] = Complex(1f)
	block(object : RegistryContext {
		override val size: Int
			get() = qbits

		override fun map(matrix: RealMatrix) {
			val result = Array(values.size) {
				matrix.getColumn(it).mapIndexed { i, it -> values[i] * it }.sum()
			}
			values = result
		}
	})
	return values.map { sqr(abs(it)) }.toTypedArray()
}

private fun pow(x: Int, p: Int): Int {
	if(p == 0)
		return 1
	if(p % 2 == 0) {
		val a = pow(x, p / 2)
		return a * a
	}
	return x * pow(x, p - 1)
}

