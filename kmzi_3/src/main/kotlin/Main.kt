import java.lang.StrictMath.*
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

fun gcdex(a: Long, b: Long): Triple<Long, Long, Long> {
	if(b == 0L)
		return Triple(a, 1, 0)
	var (g, x, y) = gcdex(b, a % b)
	return Triple(g, y - (a / b) * x, x)
}

fun factor(x: Long) = run {
	var x = x
	val result = mutableListOf<Long>()
	for(p in range(2, (ceil(sqrt(x + 0.0)) + 2).toInt()))
		while(x % p == 0L) {
			x /= p
			result.add(p.toLong())
		}
	if(result.isEmpty())
		listOf(x)
	else
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

fun main() {
	run {
		val m = 101398751L
		val n = 326147777L
		println("$m = ${factor(m).map { it.toString() }.reduce { a, b -> "$a * $b" }}")
		println("$n = ${factor(n).map { it.toString() }.reduce { a, b -> "$a * $b" }}")

		println("НОД($m, $n) = ${gcd(m, n)}")
		val fm = factor(m)
		val fn = factor(n)
		println("НОД($m, $n) = ${cross(fm, fn).fold(1L) { a, b -> a * b }}")

		val (g, x, y) = gcdex(m, n)
		println("НОД($m, $n) = $m * $x + $n * $y")
	}
	run {
		val k = 11L
		val n = 24L
		val m = 2001L
		println("\u03c6($m) = ${phi(m)}")
		println("\u03c6($n) = ${phi(n)}")
		println("\u03c6($k) = ${phi(k)}")
		val ZkZ = ring(k)
		val ZnZ = ring(n)
		val ZmZ = ring(m)
		println("Z/${k}Z = ${ZkZ}")
		println("Z/${n}Z = ${ZnZ}")
		println("Z/${m}Z = ${ZmZ}")
		for(x in ZkZ) {
			var i = inverse(x, k)
			println("$x * $i === 1 (mod $k)")
		}
		for(x in ZnZ) {
			var i = inverse(x, n)
			println("$x * $i === 1 (mod $n)")
		}
		for(x in listOf(5L, 6L, 7L)) {
			var i = inverse(x, m)
			println("$x * $i === 1 (mod $m)")
		}
	}
}

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