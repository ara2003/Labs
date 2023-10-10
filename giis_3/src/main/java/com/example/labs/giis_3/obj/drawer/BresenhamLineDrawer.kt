package com.example.labs.giis_3.obj.drawer

import com.example.labs.giis_3.pixel.PixelDrawer
import java.util.stream.IntStream.*
import kotlin.math.abs

object BresenhamLineDrawer : TwoPointDrawer {

	override fun drawTwoPointObject(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		if(abs(y2 - y1) < abs(x2 - x1))
			if(x2 < x1)
				drawLineLow(x2, y2, x1, y1)
			else
				drawLineLow(x1, y1, x2, y2)
		else
			if(y1 > y2)
				drawLineHigh(x2, y2, x1, y1)
			else
				drawLineHigh(x1, y1, x2, y2)
	}
}

// y1 < y2
// dx < dy
private fun PixelDrawer.drawLineHigh(x1: Int, y1: Int, x2: Int, y2: Int) {
	var dx = x2 - x1 + 0f
	val dy = y2 - y1 + 0f
	var xi = 1
	if(dx < 0) {
		xi = -1
		dx = -dx
	}
	var D = (2 * dx) - dy
	var x = x1
	for(y in range(y1, y2)) {
		drawPixel(x, y)
		if(D > 0) {
			x += xi
			D -= 2 * dy
		}
		D += 2 * dx
	}
}

private fun PixelDrawer.drawLineLow(x1: Int, y1: Int, x2: Int, y2: Int) {
	val dx = x2 - x1 + 0f
	var dy = y2 - y1 + 0f
	var yi = 1
	if(dy < 0) {
		yi = -1
		dy = -dy
	}
	var D = 2 * dy - dx
	var y = y1
	for(x in range(x1, x2)) {
		drawPixel(x, y)
		if(D > 0) {
			y += yi
			D -= 2 * dx
		}
		D += 2 * dy
	}
}