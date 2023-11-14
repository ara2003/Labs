package com.example.labs.giis_5.generator

import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.obj.BasePolygonDrawObject
import com.example.labs.giis_5.obj.solver.MinimalConvexHullSolver

object BasePolygonGenerator : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = BasePolygonDrawObject(points)
}
