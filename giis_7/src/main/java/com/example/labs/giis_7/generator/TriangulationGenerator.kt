package com.example.labs.giis_7.generator

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.TriangulationDrawObject
import com.example.labs.giis_7.obj.triangulation.Triangulator

class TriangulationGenerator(
	private val triangulator: Triangulator,
) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = TriangulationDrawObject(points, triangulator)
}