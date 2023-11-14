package com.example.labs.giis_5.generator

import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.obj.BasePolygonDrawObject
import com.example.labs.giis_5.obj.MCHDrawObject
import com.example.labs.giis_5.obj.solver.MinimalConvexHullSolver

class PolygonGenerator(private val solver: MinimalConvexHullSolver) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = MCHDrawObject(points, solver)
}
