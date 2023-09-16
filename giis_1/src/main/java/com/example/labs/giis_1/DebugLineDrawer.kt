package com.example.labs.giis_1

class DebugLineDrawer(val origin: LineDrawer) : LineDrawer {

	private var points: Int = 0

	fun addPoint() {
		points++
	}

	fun removePoint() {
		points--
	}

	override fun drawLine(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) {
		val count = origin.countPixel(x1, y1, x2, y2)
		if(count < points)
			points = count
		if(0 > points)
			points = 0
		val g = DebugPixelDrawer(g, BaseDrawCounter(points))
		origin.drawLine(g, x1, y1, x2, y2)
	}
}