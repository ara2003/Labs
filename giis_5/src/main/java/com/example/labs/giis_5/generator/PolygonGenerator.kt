package com.example.labs.giis_5.generator

import com.example.labs.giis_5.obj.DrawObject
import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.obj.PolygonDrawObject
import com.example.labs.giis_5.obj.solver.MinimalConvexHullSolver

class PolygonGenerator(private val solver: MinimalConvexHullSolver) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = PolygonDrawObject(points, solver)
}
