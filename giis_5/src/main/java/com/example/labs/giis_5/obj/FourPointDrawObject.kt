package com.example.labs.giis_5.obj

import com.example.labs.giis_5.obj.drawer.FourPointDrawer
import com.example.labs.giis_5.pixel.PixelDrawer

data class FourPointDrawObject(val p1: Point, val p2: Point, val p3: Point, val p4: Point, var drawer: FourPointDrawer) :
	DrawObject {

	override fun draw(drawer: PixelDrawer) {
		this.drawer.draw(drawer, p1, p2, p3, p4)
	}

	override fun iterator() = listOf(p1, p2, p3, p4).iterator()
}