import java.util.*

fun String.toInt(radix: Int) = run {
	var result = 0
	var pow = 1
	for(c in lowercase(Locale.getDefault()).reversed()) {
		val n = if(c.isDigit())
			c - '0'
		else
			(c - 'a') + 10
		result += n * pow
		pow *= radix
	}
	result
}

fun Int.toString(radix: Int) = run {
	var result = ""
	var n = this
	while(n > 0) {
		val x = n % radix
		n /= radix
		val c = if(n > 9)
			'a' + (x - 10)
		else
			'0' + x
		result += c
	}
	result.reversed()
}

fun main() {
	println("e4" * "11")
}

private operator fun String.times(other: String) =
	((this.toInt(16) * other.toInt(16)) % 256).toString(16)
