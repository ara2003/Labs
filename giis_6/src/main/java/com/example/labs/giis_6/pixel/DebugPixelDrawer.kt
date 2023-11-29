package com.example.labs.giis_6.pixel

import java.awt.Color

class DebugPixelDrawer(private val g: PixelDrawer, private val counter: DrawCounter) : PixelDrawer {

	private var lastX = -1
	private var lastY = -1

	override fun drawPixel(x: Int, y: Int, c: Color) {
		if(lastX == x && lastY == y)
			return
		if(counter.draw()) {
			lastX = x
			lastY = y
			g.drawPixel(x, y, c)
		}
	}
}
