package com.example.labs.giis_3.obj

import com.example.labs.giis_3.obj.drawer.TwoPointDrawer
import com.example.labs.giis_3.pixel.PixelDrawer

data class TwoPointDrawObject(val p1: Point, val p2: Point, var lines: TwoPointDrawer) : DrawObject {

	override fun draw(drawer: PixelDrawer) {
		lines.drawTwoPointObject(drawer, p1.x, p1.y, p2.x, p2.y)
	}

	override fun iterator() = listOf(p1, p2).iterator()
}