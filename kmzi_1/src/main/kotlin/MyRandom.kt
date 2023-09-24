class MyRandom(
	private var x0: Long,
	private var x1: Long,
	private var x2: Long,
) {

	constructor(seed: Long = System.nanoTime()) : this(seed, seed, seed)

	fun nextBytes(buffer: ByteArray) {
		for(i in 1 ..< buffer.size)
			buffer[i] = nextByte()
	}

	fun nextByte(): Byte {
		val x = (1995 * x0 + 1998 * x1 + 2001 * x2) % (1 shl 32 - 849)
		x2 = x1
		x1 = x0
		x0 = x
		return x.toByte()
	}
}
