package com.example.labs.giis_7.generator

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.MCHDrawObject
import com.example.labs.giis_7.obj.solver.MinimalConvexHullSolver

class PolygonGenerator(private val solver: MinimalConvexHullSolver) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = MCHDrawObject(points, solver)
}
