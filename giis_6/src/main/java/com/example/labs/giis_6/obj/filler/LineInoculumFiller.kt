package com.example.labs.giis_6.obj.filler

import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.PolygonDrawObject
import com.example.labs.giis_6.obj.div
import com.example.labs.giis_6.obj.inside
import com.example.labs.giis_6.obj.size
import com.example.labs.giis_6.obj.sum
import com.example.labs.giis_6.pixel.PixelDrawer
import java.util.*

object LineInoculumFiller : FillDrawer {

	override fun draw(drawer: PixelDrawer, polygon: PolygonDrawObject) {
		val painted = mutableSetOf<Point>()
		val stack = Stack<Point>()
		stack.add(polygon.sum() / polygon.size)
		while(!stack.isEmpty()) {
			val point = stack.pop()
			if(point in painted)
				continue
			if(point.x !in 0 .. 600)
				continue
			if(point.y !in 0 .. 600)
				continue
			val (x, y) = point
			var maxX = x
			while(Point(maxX, y) inside polygon)
				maxX++
			maxX--
			var minX = x
			while(Point(minX, y) inside polygon)
				minX--
			minX++
			for(x in minX .. maxX) {
				painted.add(Point(x, y))
				drawer.drawPixel(x, y)
			}
			A@ for(x in minX .. maxX) {
				val p = Point(x, y + 1)
				if(p inside polygon) {
					stack.add(p)
					break@A
				}
			}
			A@ for(x in minX .. maxX) {
				val p = Point(x, y - 1)
				if(p inside polygon) {
					stack.add(p)
					break@A
				}
			}
		}
	}
}