package com.example.labs.giis_7.obj.voronogo

import com.example.labs.giis_7.pixel.PixelDrawer
import java.awt.Color

class WidthSplit(
	val origin: PixelDrawer,
) : PixelDrawer {

	override val width: Int
		get() = origin.width / 2
	override val height: Int
		get() = origin.height

	override fun drawPixel(x: Int, y: Int, c: Color) {
		origin.drawPixel(2 * x + 0, y, c)
		origin.drawPixel(2 * x + 1, y, c)
	}
}
