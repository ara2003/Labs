package com.example.labs.giis_5.obj

import com.example.labs.giis_5.obj.drawer.TwoPointDrawer
import com.example.labs.giis_5.obj.drawer.draw
import com.example.labs.giis_5.pixel.PixelDrawer
import java.awt.Color

interface PolygonDrawObject : DrawObject {

	val drawer: TwoPointDrawer

	override fun draw(drawer: PixelDrawer) {
		for(line in lines) {
			this.drawer.draw(drawer, line)
			if(isHull()) {
				val normal = line.normal
				val center = line.center
				this.drawer.draw(drawer, center, center + (normal * -5f), Color.BLUE)
			}
		}
	}

	fun isHull(): Boolean {
		val iter = lines.iterator()
		if(!iter.hasNext())
			return false
		var a = iter.next()
		val first = a
		if(!iter.hasNext())
			return false
		while(iter.hasNext()) {
			val b = iter.next()
			if(a * b < 0)
				return false
			a = b
		}
		if(a * first < 0)
			return false
		return true
	}

	fun isInside(point: Point): Boolean
}

fun dot(a: Pair<Float, Float>, b: Pair<Float, Float>) = a.x * b.x + a.y * b.y

infix fun Point.inside(polygon: PolygonDrawObject) = polygon.isInside(this)