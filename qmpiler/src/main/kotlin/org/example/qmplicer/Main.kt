package org.example.qmplicer

import java.math.BigInteger
import java.math.BigInteger.*
import java.util.*

fun min2pow(x: BigInteger): Int {
	var result = ONE
	var i = 0
	while(result < x) {
		result *= TWO
		i++
	}
	return i
}

fun gcd(x: BigInteger) = (TWO ..< x).filter { x % it != ONE }

operator fun BigInteger.rangeUntil(that: BigInteger) = sequence {
	var i = this@rangeUntil
	while(i < that) {
		yield(i)
		i++
	}
}

tailrec fun gcd(a: BigInteger, b: BigInteger): BigInteger =
	if(b == ZERO)
		a
	else
		gcd(b, a % b)

fun factor(m: BigInteger): BigInteger {
	for(t in gcd(m)) {
		val r = solve_r_q(t, m) ?: continue
		val g = gcd(m, pow(t, r / TWO) - ONE)
		if(g == ONE || g == m)
			continue
		return g
	}
	val sqrt = m.sqrt()
	require(sqrt * sqrt == m) { "$m is nor sqr" }
	return sqrt
}

fun pow(x: Int, p: Int, m: Int): Int {
	if(p == 0)
		return 1
	return (pow(x, p - 1, m) * x) % m
}

fun pow(x: BigInteger, p: BigInteger, m: BigInteger) = x.modPow(p, m)

fun pow(x: BigInteger, p: BigInteger): BigInteger {
	if(p < valueOf(Int.MAX_VALUE.toLong()))
		return pow(x, p.toInt())
	if(p % TWO == ONE)
		return x * pow(x, p - ONE)
	val a = pow(x, p / TWO)
	return a * a
}

fun pow(x: BigInteger, p: Int) = x.pow(p)

fun solve_r_pow(t: BigInteger, m: BigInteger): BigInteger? {
	for(r in ONE ..< m) {
		if(r % TWO == ONE)
			continue
		println("${r.toDouble() * 100 / m.toDouble()}%")
		if(pow(t, r, m) == ONE)
			return r
	}
	return null
}

fun solve_r_log(t: BigInteger, m: BigInteger): BigInteger? {
	for(n in 1 ..< 1_000_000) {
		val g = m * n.toBigInteger() + ONE
		val log = log(t, g)
		if(log != null)
			return log
	}
	return null
}

fun solve_r_q(t: BigInteger, m: BigInteger): BigInteger? {
	val n = min2pow(m)

	return null
}

fun log(p: BigInteger, x: BigInteger): BigInteger? {
//	val pows = sequence {
//		var a = p
//		yield(a)
//		while(a < x) {
//			a *= a
//			yield(a)
//		}
//	}.toList()
//	val m = pows[pows.size - 2]
//	println(x)
//	println(m)
//	TODO("$pows $p $x")
	var x = x
	var c = ZERO
	while(x > ONE) {
		if(x % p != ZERO)
			return null
		x /= p
		c++
	}
	return c
}

fun main() {
//	val x = valueOf(174440041) * valueOf(414507281407)
//	val x = valueOf(7) * valueOf(2)
//	println(x)
//	val f = factor(x)
//	println("$x = $f * ${x / f}")
	registry(2) {
		amdal(0)
		amdal(1)
		cnot(0, 1)
//		amdal(0)
//		amdal(1)
	}.log()
}

private fun Array<Double>.log() {
	val size = log2(size)
	forEachIndexed { index, value ->
		if(value > 0) {
			print(String.format("%${size}s", Integer.toBinaryString(index)).replace(" ", "0"))
			println(" $value")
		}
	}
}

tailrec fun log2(x: Int): Int =
	if(x == 1)
		0
	else
		1 + log2(x / 2)

private fun BitSet.toBooleanArray(length: Int = length()) = BooleanArray(length) {
	this[it]
}

