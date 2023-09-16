package com.example.labs.giis_1

import java.util.stream.IntStream.*
import kotlin.math.abs
import kotlin.math.floor

object AntialiasingLineDrawer : LineDrawer {

	override fun drawLine(g: PixelDrawer, x0: Int, y0: Int, x1: Int, y1: Int) = g.run {
		var x0 = x0
		var y0 = y0
		var x1 = x1
		var y1 = y1
		val steep = abs(y1 - y0) > abs(x1 - x0)
		if(steep) {
			var temp = x1
			x1 = y1
			y1 = temp
			temp = x0
			x0 = y0
			y0 = temp
		}
		if(x0 > x1) {
			var temp = x0
			x0 = x1
			x1 = temp
			temp = y0
			y0 = y1
			y1 = temp
		}
		val dx = x1 - x0 + 0f
		val dy = y1 - y0 + 0f
		val gradient = if(dx === 0.0f)
			1.0f
		else
			dy / dx
		var xend = x0
		var yend = y0 + gradient * (xend - x0)
		var xgap = rfpart(x0 + 0.5f)
		val xpxl1 = xend // this will be used in the main loop
		val ypxl1 = ipart(yend)
		if(steep) {
			drawPixel(ypxl1, xpxl1, rfpart(yend) * xgap)
			drawPixel(ypxl1 + 1, xpxl1, fpart(yend) * xgap)
		} else {
			drawPixel(xpxl1, ypxl1, rfpart(yend) * xgap)
			drawPixel(xpxl1, ypxl1 + 1, fpart(yend) * xgap)
		}
		var intery = yend + gradient // first y-intersection for the main loop
		// handle second endpoint
		xend = x1
		yend = y1 + gradient * (xend - x1)
		xgap = fpart(x1 + 0.5f)
		val xpxl2 = xend //this will be used in the main loop
		val ypxl2 = ipart(yend)
		if(steep) {
			drawPixel(ypxl2, xpxl2, rfpart(yend) * xgap)
			drawPixel(ypxl2 + 1, xpxl2, fpart(yend) * xgap)
		} else {
			drawPixel(xpxl2, ypxl2, rfpart(yend) * xgap)
			drawPixel(xpxl2, ypxl2 + 1, fpart(yend) * xgap)
		}
		if(steep)
			for(y in range(xpxl1 + 1, xpxl2 - 1)) {
				drawPixel(ipart(intery), y, rfpart(intery))
				drawPixel(ipart(intery) + 1, y, fpart(intery))
				intery += gradient
			}
		else
			for(x in range(xpxl1 + 1, xpxl2 - 1)) {
				drawPixel(x, ipart(intery), rfpart(intery))
				drawPixel(x, ipart(intery) + 1, fpart(intery))
				intery += gradient
			}
	}
}

private fun ipart(x: Float) = (floor(x) + .1f).toInt()
private fun fpart(x: Float) = x - ipart(x)
private fun rfpart(x: Float) = 1 - fpart(x)
private fun round(x: Float) = ipart(x + .5f)