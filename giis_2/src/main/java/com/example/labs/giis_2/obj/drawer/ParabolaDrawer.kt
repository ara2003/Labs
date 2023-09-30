package com.example.labs.giis_2.obj.drawer

import com.example.labs.giis_2.pixel.PixelDrawer
import java.lang.StrictMath.*

object ParabolaDrawer : TwoPointDrawer {

	override fun drawLine(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		val a = abs(x2 - x1)
		val b = abs(y2 - y1)
		drawParabola(x1, y2, a, b)
	}
}

private const val maxX = 1000

private fun PixelDrawer.drawParabola(x0: Int, y0: Int, a: Int, b: Int) {
	val p = 2
	var x = 0
	var y = 0
	var Sd = (y + 1) * (y + 1) - 2 * p * (x + 1)
	var Sv = (y + 1) * (y + 1) - 2 * p * x
	var Sh = y * y - 2 * p * (x + 1)
//	drawPixel(x0, y0)
	while(x + x0 < maxX) {
		drawPixel(x + x0, y0 + y)
		drawPixel(x + x0, y0 - y)
		if(abs(Sh) - abs(Sv) <= 0) {
			if(abs(Sd) - abs(Sh) < 0) y++
			x++
		} else {
			if(abs(Sv) - abs(Sd) > 0) x++
			y++
		}

		Sd = (y + 1) * (y + 1) - 2 * p * (x + 1)
		Sv = (y + 1) * (y + 1) - 2 * p * x
		Sh = y * y - 2 * p * (x + 1)
	}
}
