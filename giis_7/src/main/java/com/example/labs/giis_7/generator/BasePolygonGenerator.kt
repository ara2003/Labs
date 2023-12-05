package com.example.labs.giis_7.generator

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.BasePolygonDrawObject

object BasePolygonGenerator : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = BasePolygonDrawObject(points)
}
