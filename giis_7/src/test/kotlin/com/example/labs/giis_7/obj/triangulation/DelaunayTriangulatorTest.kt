package com.example.labs.giis_7.obj.triangulation

import com.example.labs.giis_7.obj.Point
import org.junit.jupiter.api.Test

class DelaunayTriangulatorTest {

	@Test
	fun test1() {
		val points = listOf(Point(0, 0), Point(100, 100), Point(0, 100), Point(100, 0))
		val triangulator = DelaunayTriangulator
		triangulator.solve(points).forEach {
			println(it)
		}
	}
}
