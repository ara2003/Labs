package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.DrawObject
import com.example.labs.giis_3.obj.FourPointDrawObject
import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.obj.drawer.FourPointDrawer

class FourPointGenerator(val drawer: FourPointDrawer) : MultiPointGenerator(4) {

	override fun newObject(points: Collection<Point>): DrawObject {
		val iter = points.iterator()
		return FourPointDrawObject(iter.next(), iter.next(), iter.next(), iter.next(), drawer)
	}
}