package com.example.labs.giis_5.obj.drawer

import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.pixel.PixelDrawer

class SplitFour(private val origin: FourPointDrawer) : MultiPointDrawer {

	override fun draw(g: PixelDrawer, points: Collection<Point>) {
		val points = points.iterator()
		if(!points.hasNext())
			return
		var a = points.next()
		if(!points.hasNext())
			return
		var b = points.next()
		if(!points.hasNext())
			return
		var c = points.next()
		while(points.hasNext()) {
			val d = points.next()
			origin.draw(g, a, b, c, d)
			a = b
			b = c
			c = d
		}
	}
}