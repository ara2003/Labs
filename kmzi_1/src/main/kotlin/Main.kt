import java.io.FileOutputStream
import java.security.SecureRandom

const val file = "output.txt"
const val BYTES = 50L * 1024 * 1024
const val BYTE_IN_CHUNK = Int.MAX_VALUE - 8
const val CHUNK_COUNT = (BYTES / BYTE_IN_CHUNK).toInt()

fun main() {
	val random = SecureRandom()
	val buffer = ByteArray(BYTE_IN_CHUNK)
	var chunk = 0
	FileOutputStream(file).use { f ->
		repeat(CHUNK_COUNT) {
			random.nextBytes(buffer)
			f.write(buffer)
			println("${(++chunk * 100) / CHUNK_COUNT}%")
		}
	}
}