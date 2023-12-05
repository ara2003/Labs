package com.example.labs.giis_7.obj

import com.example.labs.giis_7.obj.drawer.TwoPointDrawer
import com.example.labs.giis_7.pixel.PixelDrawer

open class TwoPointDrawObject(val p1: Point, val p2: Point, val drawer: TwoPointDrawer) : DrawObject {

	override val lines: Iterable<Line>
		get() = listOf()

	override fun draw(drawer: PixelDrawer) {
		this.drawer.draw(drawer, p1.x, p1.y, p2.x, p2.y)
	}

	override fun iterator() = listOf(p1, p2).iterator()
}