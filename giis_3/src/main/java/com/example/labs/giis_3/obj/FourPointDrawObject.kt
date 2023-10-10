package com.example.labs.giis_3.obj

import com.example.labs.giis_3.obj.drawer.FourPointDrawer
import com.example.labs.giis_3.pixel.PixelDrawer

data class FourPointDrawObject(val p1: Point, val p2: Point, val p3: Point, val p4: Point, var lines: FourPointDrawer) :
	DrawObject {

	override fun draw(drawer: PixelDrawer) {
		lines.draw(drawer, p1, p2, p3, p4)
	}
}