package com.example.labs.giis_6

import java.util.stream.IntStream

fun range(begin: Double, end: Double, step: Double) = sequence {
	for(i in IntStream.range(0, ((end - begin + step / 2) / step).toInt())) {
		yield(begin + i * step)
	}
}