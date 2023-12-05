package com.example.labs.giis_7.generator

import com.example.labs.giis_7.obj.DrawObject
import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.VoronogoDrawObject
import com.example.labs.giis_7.obj.voronogo.VoronogoDiagram

data class VoronogoGenerator(
	val diagram: VoronogoDiagram,
) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = VoronogoDrawObject(diagram, points)
}
