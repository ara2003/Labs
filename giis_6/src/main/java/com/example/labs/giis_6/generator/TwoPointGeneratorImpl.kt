package com.example.labs.giis_6.generator

import com.example.labs.giis_6.obj.DrawObject
import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.TwoPointDrawObject
import com.example.labs.giis_6.obj.drawer.TwoPointDrawer

class TwoPointGeneratorImpl(val drawer: TwoPointDrawer) : MultiCountPointGenerator(2) {

	override fun newObject(points: Collection<Point>): DrawObject {
		val iter = points.iterator()
		return TwoPointDrawObject(iter.next(), iter.next(), drawer)
	}
}