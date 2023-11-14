package com.example.labs.giis_5.obj.drawer

import com.example.labs.giis_5.pixel.PixelDrawer
import java.awt.Color
import kotlin.math.sqrt

object CircleDrawer : TwoPointDrawer {

	override fun draw(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		val R = run {
			val dx = x2 - x1
			val dy = y2 - y1
			sqrt(dx * dx + dy * dy + 0.0).toInt()
		}
		var x = 0
		var y = R
		var delta = 3 - 2 * R
		while(x <= y) {
			drawPixel(x1 + x, y1 + y)
			drawPixel(x1 + x, y1 - y)
			drawPixel(x1 - x, y1 + y)
			drawPixel(x1 - x, y1 - y)
			drawPixel(x1 + y, y1 + x)
			drawPixel(x1 + y, y1 - x)
			drawPixel(x1 - y, y1 + x)
			drawPixel(x1 - y, y1 - x)
			delta +=
				if(delta < 0)
					4 * x + 6
				else
					4 * (x - y--) + 10
			++x
		}
	}
}