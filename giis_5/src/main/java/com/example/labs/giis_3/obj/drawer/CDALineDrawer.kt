package com.example.labs.giis_3.obj.drawer

import com.example.labs.giis_3.pixel.PixelDrawer
import kotlin.math.abs
import kotlin.math.max

object CDALineDrawer : TwoPointDrawer {

	override fun drawTwoPointObject(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) {
		val L = max(abs(x2 - x1), abs(y2 - y1))
		val dx = (x2 - x1 + 0f) / L
		val dy = (y2 - y1 + 0f) / L
		var px = x1.toFloat()
		var py = y1.toFloat()
		repeat(L) {
			px += dx
			py += dy
			g.drawPixel(px.toInt(), py.toInt())
		}
	}
}