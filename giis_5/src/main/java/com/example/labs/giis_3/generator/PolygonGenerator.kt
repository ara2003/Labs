package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.DrawObject
import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.obj.PolygonDrawObject
import com.example.labs.giis_3.obj.solver.MinimalConvexHullSolver

class PolygonGenerator(private val solver: MinimalConvexHullSolver) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = PolygonDrawObject(points, solver)
}
