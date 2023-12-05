import java.util.concurrent.ThreadLocalRandom
import kotlin.math.sqrt

fun pow(a: Long, b: Long, p: Long): Long {
	var res = 1L
	var a = a
	var b = b
	while(b > 0) {
		if(b % 2 == 1L) {
			res = res * a % p
			b--
		} else {
			a = a * a % p
			b /= 2
		}
	}
	return res
}

data class Four<T1, T2, T3, T4>(val f1: T1, val f2: T2, val f3: T3, val f4: T4)

fun diffieHellman(a: Long, b: Long, alpha: Long, p: Long) = run {
	val A = pow(alpha, a, p)
	val B = pow(alpha, b, p)
	val keyA = pow(B, a, p)
	val keyB = pow(A, b, p)
	Four(A, B, keyA, keyB)
}

fun discreteLogarithm(a: Long, b: Long, m: Long): Long {
	val n = (sqrt(m.toDouble()) + 2).toLong()
	val value = mutableMapOf<Long, Long>()
	for(i in (1 .. n).reversed()) {
		value[pow(a, i * n, m)] = i
	}
	for(j in 0 .. n) {
		val cur = (pow(a, j, m) * b) % m
		value[cur]?.let { v ->
			val ans = v * n - j
			if(ans < m)
				return ans
		}
	}
	return -1
}

fun main() {
	val p = 134041249L
	val alpha = 7L
	val a = ThreadLocalRandom.current().nextInt((p - 1L).toInt()).toLong()
	val b = ThreadLocalRandom.current().nextInt((p - 1L).toInt()).toLong()
	println("Alice's private key: $a\nBob's private key: $b")
	val (A, B, keyA, keyB) = diffieHellman(a, b, alpha, p)
	println("Alice's open key: $a\nBob's open key: $b")
	println("Alice's secret key: $keyA\nBob's secret key: $keyB")
	println(
		"Discrete Logarithm keys:\n Alice's key: ${discreteLogarithm(alpha, A, p)}\n Bob's key: ${
			discreteLogarithm(
				alpha,
				B,
				p
			)
		}"
	)
}