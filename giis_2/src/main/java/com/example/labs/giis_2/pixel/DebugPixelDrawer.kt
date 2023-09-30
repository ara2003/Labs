package com.example.labs.giis_2.pixel

class DebugPixelDrawer(private val g: PixelDrawer, private val counter: DrawCounter) : PixelDrawer {

	override fun drawPixel(x: Int, y: Int, c: Float) {
		if(counter.draw())
			g.drawPixel(x, y, c)
	}
}
