import java.lang.StrictMath.*
import java.math.BigInteger
import java.util.stream.IntStream.*

fun gcd(a: Long, b: Long): Long {
	var a = a
	var b = b
	while(a != 0L && b != 0L) {
		if(a > b)
			a %= b
		else
			b %= a
	}
	return a + b
}

fun gcd_factor(a: Long, b: Long): Long {
	return cross(factor(a), factor(b)).fold(1L) { a, b -> a * b }
}

fun gcdex(a: Long, b: Long): Triple<Long, Long, Long> {
	if(b == 0L)
		return Triple(a, 1, 0)
	var (g, x, y) = gcdex(b, a % b)
	return Triple(g, y - (a / b) * x, x)
}

fun factor(x: Long) = run {
	var x = x
	val result = mutableListOf<Long>()
	for(p in range(2, (ceil(sqrt(x + 0.1)) + 2).toInt()))
		while(x % p == 0L) {
			x /= p
			result.add(p.toLong())
		}
	result.add(x)
	result.remove(1)
	result
}

fun phi(x: Long) = run {
	var result = x + 0.0
	val factor = factor(x).distinct().map { it.toDouble() }
	for(e in factor)
		result *= 1 - 1 / e
	(result + .1).toLong()
}

fun pow(a: Long, p: Long, m: Long): Long {
	if(p == 0L)
		return 1
	if(p % 2 == 1L)
		return (a * pow(a, p - 1, m)) % m
	val b = pow(a, p / 2, m)
	return (b * b) % m
}

fun inverse(a: Long, m: Long) = pow(a, phi(m) - 1, m)

fun ring(mod: Long) = (1L .. mod).filter { gcd(it, mod) == 1L }

fun <T> cross(a: Iterable<T>, b: Iterable<T>) = run {
	val result = mutableListOf<T>()
	val c = mutableListOf<T>()
	c.addAll(b)
	for(e in a)
		if(e in c) {
			c.remove(e)
			result.add(e)
		}
	result
}

fun isPrime(mod: Long): Boolean {
	if(2L == mod)
		return true
	for(p in range(2, (ceil(sqrt(mod + 0.1)) + 1).toInt()))
		if(mod % p == 0L)
			return false
	return true
}

fun allBase(mod: Long): List<Long> {
	if(mod == 2L)
		return listOf(1L)
	if(isPrime(mod)) {
		val q = factor(mod - 1)
		val result = mutableListOf<Long>()
		for(g in 2 ..< mod) {
			if(q.all { q -> pow(g, (mod - 1) / q, mod) != 1L })
				result.add(g)
		}
		return result
	}
	val factor = factor(mod).toMutableSet()
	factor.remove(2L)
	if(factor.size > 1)
		throw UnsupportedOperationException("Z$mod is not cycle group")
	val p = factor.first()
	val result = mutableListOf<Long>()
	allBase(p).forEach { g ->
		for(x in listOf(g, g + p)) {
			if(pow(x, p - 1, p * p) != 1L)
				result.add(x)
		}
	}
	return result
}

fun base(mod: Long): Long {
	if(mod == 2L)
		return 1L
	if(isPrime(mod)) {
		val q = factor(mod - 1)
		for(g in 2 ..< mod) {
			if(q.all { q -> pow(g, (mod - 1) / q, mod) != 1L })
				return g
		}
		throw UnsupportedOperationException("never")
	}
	val factor = factor(mod).toMutableSet()
	factor.remove(2)
	if(factor.size > 1)
		throw UnsupportedOperationException("Z$mod is not cycle group")
	val p = factor.first()
	val g = base(p)
	for(x in listOf(g, g + p)) {
		if(pow(x, p - 1, p * p) != 1L)
			return x
	}
	throw UnsupportedOperationException("never")
}

fun group(mod: Long, base: Long = base(mod)) = run {
	val result = mutableSetOf<Long>()
	var x = base
	while(x !in result) {
		result.add(x)
		x = (x * base) % mod
	}
	result.toList().sorted()
}

fun cycles(list: List<Int>): List<List<Int>> {
	val m = list.toMutableList() as MutableList<Int?>
	val result = mutableListOf<List<Int>>()
	while(true) {
		var cycle = mutableListOf<Int>()
		val i = m.indexOfFirst { it != null }
		if(i == -1)
			break
		var x = m[i]!!
		m[i] = null
		while(x !in cycle) {
			cycle.add(x)
			m[x - 1] = null
			x = list[x - 1]
		}
		result.add(cycle)
	}
	return result
}
/*
// x = 92440205
// m = 28643910
fun main() {
	val p = 206_181_067L
	val g = base(p)
	val x = 92_440_205L
	val y = 57_348_448L //pow(g, x, p)
//	val k = (random() * (p - 1) + 0.1).toLong()
//	val m = (random() * (p - 1) + 0.1).toLong()
//	val a = pow(g, k, p) // О
//	val b = (pow(y, k, p) * m) % p // Ш
	val a = 262_582_374L
	val b = 17_960_572L
	println("$g, $y, $p")
//	println("$a, $b, $k")
	val m = (b * inverse(pow(a, x, p), p)) % p
	println("$m")
}
*/

fun solve_x(g: Long, p: Long, y: Long): Long {
	for(x in 2L ..< p - 1) {
		val yp = pow(g, x, p)
		if(yp == y)
			return x
	}
	TODO()
}

// x = 7
fun main() {
//	val p = 23L
//	val g = base(p)
//	val y = 17L
//	val x = 7L
//	val a = 10L
//	val b = 4L
//	val m = (b * inverse(pow(a, x, p), p)) % p
//	println(m)
	val w = BigInteger.valueOf(2428010006080722311L)
	val p = BigInteger.valueOf(2038074743L)
	val q = BigInteger.valueOf(2038074751L)
	val e = BigInteger.valueOf(1299709L)
	println(w.modPow(e, p.multiply(q)))
}