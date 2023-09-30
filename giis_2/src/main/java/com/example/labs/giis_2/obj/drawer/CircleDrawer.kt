package com.example.labs.giis_2.obj.drawer

import com.example.labs.giis_2.pixel.PixelDrawer
import kotlin.math.sqrt

object CircleDrawer : TwoPointDrawer {

	override fun drawLine(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		val X1 = x1
		val Y1 = y1
		val R = run {
			val dx = x2 - x1
			val dy = y2 - y1
			sqrt(dx * dx + dy * dy + 0.0).toInt()
		}
		var x = 0
		var y = R
		var delta = 1 - 2 * R
		var error = 0
		while(y >= x) {
			drawPixel(X1 + x, Y1 + y)
			drawPixel(X1 + x, Y1 - y)
			drawPixel(X1 - x, Y1 + y)
			drawPixel(X1 - x, Y1 - y)
			drawPixel(X1 + y, Y1 + x)
			drawPixel(X1 + y, Y1 - x)
			drawPixel(X1 - y, Y1 + x)
			drawPixel(X1 - y, Y1 - x)
			error = 2 * (delta + y) - 1
			if((delta < 0) && (error <= 0)) {
				delta += 2 * ++x + 1
				continue
			}
			if((delta > 0) && (error > 0)) {
				delta -= 2 * --y + 1
				continue
			}
			delta += 2 * (++x - --y)
		}
	}
}