package com.example.labs.giis_7.obj.filler

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.PolygonDrawObject
import com.example.labs.giis_7.obj.div
import com.example.labs.giis_7.obj.inside
import com.example.labs.giis_7.obj.size
import com.example.labs.giis_7.obj.sum
import com.example.labs.giis_7.pixel.PixelDrawer
import java.util.*

object SimpleInoculumFiller : FillDrawer {

	override fun draw(drawer: PixelDrawer, polygon: PolygonDrawObject) {
		val painted = mutableSetOf<Point>()
		val stack = Stack<Point>()
		stack.add(polygon.sum() / polygon.size)
		while(!stack.isEmpty()) {
			val point = stack.pop()
			painted.add(point)
			drawer.drawPixel(point.x, point.y)
			val nextPoints = listOf(
				Point(point.x + 1, point.y),
				Point(point.x, point.y - 1),
				Point(point.x - 1, point.y),
				Point(point.x, point.y + 1),
			).filter { it inside polygon }.filter { it !in painted }
			for(p in nextPoints)
				stack.add(p)
		}
	}
}
