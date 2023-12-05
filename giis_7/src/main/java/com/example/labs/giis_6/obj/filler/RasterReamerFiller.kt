package com.example.labs.giis_6.obj.filler

import com.example.labs.giis_6.obj.Line
import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.PolygonDrawObject
import com.example.labs.giis_6.obj.cross
import com.example.labs.giis_6.pixel.PixelDrawer

object RasterReamerFiller : FillDrawer {

	override fun draw(drawer: PixelDrawer, polygon: PolygonDrawObject) {
		val maxX = polygon.maxOf { it.x }
		val minX = polygon.minOf { it.x }
		val maxY = polygon.maxOf { it.y }
		val minY = polygon.minOf { it.y }
		val lines = polygon.lines
		for(y in minY .. maxY) {
			val line = Line(minX, y, maxX, y)
			val points = lines.mapNotNull { cross(it, line) }.map { it.x }.distinct().sorted()
			for(i in 0 ..< points.size / 2) {
				val a = points[2 * i + 0]
				val b = points[2 * i + 1]
				drawer.line(y, a, b)
			}
		}
	}
}

fun PixelDrawer.line(y: Int, x1: Int, x2: Int) {
	for(x in x1 .. x2)
		drawPixel(x, y)
}
//fun PixelDrawer.line(x: Int, y1: Int, y2: Int) {
//	for(y in y1 .. y2)
//		drawPixel(x, y)
//}