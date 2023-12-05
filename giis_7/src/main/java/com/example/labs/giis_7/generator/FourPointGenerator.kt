package com.example.labs.giis_7.generator

import com.example.labs.giis_7.obj.DrawObject
import com.example.labs.giis_7.obj.FourPointDrawObject
import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.drawer.FourPointDrawer

class FourPointGenerator(val drawer: FourPointDrawer) : MultiCountPointGenerator(4) {

	override fun newObject(points: Collection<Point>): DrawObject {
		val iter = points.iterator()
		return FourPointDrawObject(iter.next(), iter.next(), iter.next(), iter.next(), drawer)
	}
}