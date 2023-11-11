package com.example.labs.giis_3.obj.drawer

import com.example.labs.giis_3.pixel.PixelDrawer
import java.lang.StrictMath.*

object ParabolaDrawer : TwoPointDrawer {

	override fun drawTwoPointObject(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		drawParabola(x1, y2, abs(x2 - x1))
	}
}

private const val maxX = 10000

private fun PixelDrawer.drawParabola(x0: Int, y0: Int, p: Int) {
	var x = 0
	var y = 0
	var Sd = (y + 1) * (y + 1) - 2 * p * (x + 1)
	var Sv = (y + 1) * (y + 1) - 2 * p * x
	var Sh = y * y - 2 * p * (x + 1)
	while(x + x0 < maxX) {
		drawPixel(x + x0, y0 + y)
		drawPixel(x + x0, y0 - y)
		if(abs(Sh) <= abs(Sv)) {
			if(abs(Sd) < abs(Sh)) y++
			x++
		} else {
			if(abs(Sv) > abs(Sd)) x++
			y++
		}

		Sd = (y + 1) * (y + 1) - 2 * p * (x + 1)
		Sv = (y + 1) * (y + 1) - 2 * p * x
		Sh = y * y - 2 * p * (x + 1)
	}
}
