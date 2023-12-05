package com.example.labs.giis_6.obj.filler

import com.example.labs.giis_6.obj.Line
import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.PolygonDrawObject
import com.example.labs.giis_6.obj.cross
import com.example.labs.giis_6.pixel.PixelDrawer

private val <T1, T2, V> Map<T1, Map<T2, V>>.transpose: Map<T2, Map<T1, V>>
	get() {
		val result = mutableMapOf<T2, MutableMap<T1, V>>()
		for(e1 in this)
			for(e2 in e1.value) {
				result.getOrPut(e2.key) {
					mutableMapOf()
				}[e1.key] = e2.value
			}
		return result
	}

object RasterReamerActiveEdgeFiller : FillDrawer {

	override fun draw(drawer: PixelDrawer, polygon: PolygonDrawObject) {
		data class Info(val x: Int, val dx: Int)

		val maxY = polygon.maxOf { it.y }
		val minY = polygon.minOf { it.y }
		val minX = polygon.minOf { it.x }
		val maxX = polygon.maxOf { it.x }
		val map = mutableMapOf<Line, Map<Int, Info>>()
		val lines = polygon.lines
		for(line in lines) {
			val m = mutableMapOf<Int, Info>().also { map[line] = it }
			val crossPoints = mutableListOf<Point>()
			for(y in polygon.minOf { it.y } .. polygon.maxOf { it.y }) {
				val yline = Line(minX, y, maxX, y)
				val c = cross(line, yline)
				if(c != null)
					crossPoints.add(c)
			}
			for(i in 0 ..< crossPoints.size - 2) {
				val p = crossPoints[i]
				val n = crossPoints[i + 1]
				m[p.y] = Info(p.x, n.x - p.x)
			}
			val last = crossPoints.last()
			m[last.y] = Info(last.x, -1)
		}
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