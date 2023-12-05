package com.example.labs.giis_7.obj.drawer

import com.example.labs.giis_7.pixel.PixelDrawer
import java.util.stream.IntStream.*
import kotlin.math.abs
import kotlin.math.floor

object AntialiasingLineDrawer : TwoPointDrawer {

	override fun draw(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
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

//dx < dy
private fun PixelDrawer.drawLineHigh(x1: Int, y1: Int, x2: Int, y2: Int) {
	val dx = x2 - x1 + 0f
	val dy = y2 - y1 + 0f
	val gradient =
		if(y1 == y2)
			1.0f
		else
			dx / dy
	var intery = x1 + gradient
	for(y in range(y1, y2)) {
		drawPixel(ipart(intery), y, rfpart(intery))
		drawPixel(ipart(intery) + 1, y, fpart(intery))
		intery += gradient
	}
}

//dy < dx
private fun PixelDrawer.drawLineLow(x1: Int, y1: Int, x2: Int, y2: Int) {
	val dx = x2 - x1 + 0f
	val dy = y2 - y1 + 0f
	val gradient =
		if(x1 == x2)
			1.0f
		else
			dy / dx
	var intery = y1 + gradient
	for(x in range(x1, x2)) {
		drawPixel(x, ipart(intery), rfpart(intery))
		drawPixel(x, ipart(intery) + 1, fpart(intery))
		intery += gradient
	}
}

private fun ipart(x: Float) = (floor(x) + .1f).toInt()
private fun fpart(x: Float) = x - ipart(x)
private fun rfpart(x: Float) = 1 - fpart(x)
