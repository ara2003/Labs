package com.example.labs.giis_1

interface LineDrawer {

	fun drawLine(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int)
	fun countPixel(x1: Int, y1: Int, x2: Int, y2: Int): Int {
		var count = 0
		val counter = object : PixelDrawer {
			override fun drawPixel(x: Int, y: Int, c: Float) {
				count++
			}
		}
		drawLine(counter, x1, y1, x2, y2)
		return count
	}
}
