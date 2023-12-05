package com.example.labs.giis_7.obj

import com.example.labs.giis_7.obj.voronogo.VoronogoDiagram
import com.example.labs.giis_7.pixel.PixelDrawer

data class VoronogoDrawObject(
	val diagram: VoronogoDiagram,
	val points: Iterable<Point>
) : DrawObject {

	override fun iterator() = points.iterator()

	override fun draw(drawer: PixelDrawer) = diagram.draw(drawer, points)

	override val lines: Iterable<Line>
		get() = listOf()
}
