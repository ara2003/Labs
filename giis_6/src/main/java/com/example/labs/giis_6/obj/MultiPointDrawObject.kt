package com.example.labs.giis_6.obj

import com.example.labs.giis_6.obj.drawer.MultiPointDrawer
import com.example.labs.giis_6.pixel.PixelDrawer

class MultiPointDrawObject(val points: Collection<Point>, val drawer: MultiPointDrawer) : DrawObject {

	override fun draw(g: PixelDrawer) = drawer.draw(g, points)
	override fun iterator() = points.iterator()
}
