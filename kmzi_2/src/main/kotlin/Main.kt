import java.util.*

const val abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
val sc = Scanner(System.`in`)
fun input() = sc.nextLine()!!.uppercase(Locale.getDefault())
fun input(text: String): String {
	print("$text:")
	return input()
}

fun encrypt(c: Char, key: Int) = 'A' + (c - 'A' + key) % abc.length

fun main() {
	val key = input("key")[0] - 'A' + 1
	val text = input("text")
	val cryptotext = text.map { c -> encrypt(c, key).toString() }.reduceOrNull { x, y -> x + y } ?: ""

	println(cryptotext)
}
