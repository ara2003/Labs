package com.example.labs.giis_7.obj

import com.example.labs.giis_7.obj.filler.FillDrawer
import com.example.labs.giis_7.pixel.PixelDrawer

data class FillPolygon(val polygon: PolygonDrawObject, val filler: FillDrawer) : DrawObject {

	override fun draw(drawer: PixelDrawer) {
		filler.draw(drawer, polygon)
	}

	override val lines: Iterable<Line>
		get() = listOf()

	override fun iterator() = polygon.iterator()
}