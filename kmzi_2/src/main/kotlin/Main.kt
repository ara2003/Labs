import java.util.*

const val abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
val sc = Scanner(System.`in`)
fun input() = sc.nextLine()!!.uppercase(Locale.getDefault())
fun input(text: String): String {
	print("$text:")
	return input()
}

fun encrypt(c: Char, key: Int) = 'A' + (c - 'A' + key) % abc.length
fun encrypt(text: String, key: Int) = text.map { c ->
	encrypt(c, key).toString()
}.reduceOrNull { x, y -> x + y } ?: ""

fun dencrypt(c: Char, key: Int) = 'A' + ((c - 'A' - key) + abc.length) % abc.length
fun dencrypt(encryptText: String, key: Int) = encryptText.map { c ->
	dencrypt(c, key).toString()
}.reduceOrNull { x, y -> x + y } ?: ""

fun allDencrypt(encryptText: String): Iterable<Pair<Char, String>> {
	val list = mutableListOf<Pair<Char, String>>()
	for(key in 'A' .. 'Z') {
		list.add(Pair(key, dencrypt(encryptText, key - 'A')))
	}
	return list
}

fun findKey(text: String, encryptText: String) = 'A' + (encryptText[0] - text[0] + abc.length) % abc.length

fun main() {
	while(true) {
		println("1) encrypt(text, key)")
		println("2) dencrypt(encryptText, key)")
		println("3) findKey(text, encryptText)")
		println("4) allDencrypt(encryptText)")
		var code = input().toInt()
		when(code) {
			1 -> {
				val text = input("encryptText")
				val key = input("key")[0] - 'A'
				val encryptText = encrypt(text, key)
				println("encrypt text: $encryptText")
			}

			2 -> {
				val encryptText = input("encrypt text")
				val key = input("key")[0] - 'A'
				val dencryptText = dencrypt(encryptText, key)
				println("encrypt text: $dencryptText")
			}

			3 -> {
				val text = input("text")
				val encryptText = input("encrypt text")
				val key = findKey(text, encryptText)
				println("key: $key")
			}

			4 -> {
				val encryptText = input("encrypt text")
				val texts = allDencrypt(encryptText)
				for((key, text) in texts)
					println("$key: $text")
			}
		}
	}
}
