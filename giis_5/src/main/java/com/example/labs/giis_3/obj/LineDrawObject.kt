package com.example.labs.giis_3.obj

import com.example.labs.giis_3.obj.drawer.TwoPointDrawer
import com.example.labs.giis_3.pixel.PixelDrawer

class LineDrawObject(p1: Point, p2: Point, drawer: TwoPointDrawer) : TwoPointDrawObject(p1, p2, drawer) {

	override val lines: Iterable<Line>
		get() = listOf(Line(p1, p2))
}