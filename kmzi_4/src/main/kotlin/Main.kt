
import java.lang.StrictMath.*
import java.lang.UnsupportedOperationException
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

fun allBase(mod: Long): Any {
	if(isPrime(mod)) {
		val q = factor(mod - 1)
		val result = mutableListOf<Long>()
		for(g in 2 ..< mod) {
			if(q.all { q -> pow(g, (mod - 1) / q, mod) != 1L })
				result.add(g)
		}
		return result
	}
	val factor = factor(mod).toSet()
	if(factor.size > 1)
		throw UnsupportedOperationException("Z$mod is not cycle group")
	val p = factor.first()
	val g = base(p)
	val result = mutableListOf<Long>()
	for(x in listOf(g, g + p)) {
		if(pow(x, p - 1, p * p) != 1L)
			result.add(x)
	}
	return result
}

fun base(mod: Long): Long {
	if(isPrime(mod)) {
		val q = factor(mod - 1)
		for(g in 2 ..< mod) {
			if(q.all { q -> pow(g, (mod - 1) / q, mod) != 1L })
				return g
		}
		throw UnsupportedOperationException("never")
	}
	val factor = factor(mod).toSet()
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
		println(x)
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

fun main() {
	val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
	val shuffled = list.shuffled()
	println(list)
	println(shuffled)
	println(cycles(shuffled))
//	println(group(493039))
}
// (1, 5, 6)(2, 7, 3)(4)
// (1, 5)(1, 6)(2, 7)(2, 3)