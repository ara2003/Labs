package com.example.labs.giis_5.generator

import com.example.labs.giis_5.obj.DrawObject
import com.example.labs.giis_5.obj.`LineDrawObject`
import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.obj.drawer.TwoPointDrawer

class LineGenerator(val drawer: TwoPointDrawer) : MultiCountPointGenerator(2) {

	override fun newObject(points: Collection<Point>): DrawObject {
		val iter = points.iterator()
		return LineDrawObject(iter.next(), iter.next(), drawer)
	}
}