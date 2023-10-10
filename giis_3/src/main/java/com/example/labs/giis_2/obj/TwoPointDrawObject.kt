package com.example.labs.giis_2.obj

import com.example.labs.giis_2.obj.drawer.TwoPointDrawer
import com.example.labs.giis_2.pixel.PixelDrawer

data class TwoPointDrawObject(val p1: Point, val p2: Point, var lines: TwoPointDrawer) : DrawObject {
	constructor(
		x1: Int,
		y1: Int,
		x2: Int,
		y2: Int,
		drawer: TwoPointDrawer,
	) : this(Point(x1, y1), Point(x2, y2), drawer)

	override fun draw(drawer: PixelDrawer) {
		lines.drawTwoPointObject(drawer, p1.x, p1.y, p2.x, p2.y)
	}
}