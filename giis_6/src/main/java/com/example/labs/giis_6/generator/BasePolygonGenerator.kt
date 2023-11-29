package com.example.labs.giis_6.generator

import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.BasePolygonDrawObject

object BasePolygonGenerator : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = BasePolygonDrawObject(points)
}
