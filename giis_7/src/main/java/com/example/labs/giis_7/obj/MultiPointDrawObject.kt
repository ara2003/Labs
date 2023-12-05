package com.example.labs.giis_7.obj

import com.example.labs.giis_7.obj.drawer.MultiPointDrawer
import com.example.labs.giis_7.pixel.PixelDrawer

class MultiPointDrawObject(val points: Collection<Point>, val drawer: MultiPointDrawer) : DrawObject {

	override fun draw(g: PixelDrawer) = drawer.draw(g, points)
	override fun iterator() = points.iterator()
}
