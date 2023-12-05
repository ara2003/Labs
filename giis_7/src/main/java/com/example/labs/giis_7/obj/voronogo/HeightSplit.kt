package com.example.labs.giis_7.obj.voronogo

import com.example.labs.giis_7.pixel.PixelDrawer
import java.awt.Color

class HeightSplit(
	val origin: PixelDrawer,
) : PixelDrawer {

	override val width: Int
		get() = origin.width
	override val height: Int
		get() = origin.height / 2

	override fun drawPixel(x: Int, y: Int, c: Color) {
		origin.drawPixel(x, 2 * y + 0, c)
		origin.drawPixel(x, 2 * y + 1, c)
	}
}
