package com.example.labs.giis_7.obj.voronogo

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.distanceSqr
import com.example.labs.giis_7.pixel.PixelDrawer
import java.awt.Color
import java.util.concurrent.ThreadLocalRandom

object FillVoronogoDiagram : VoronogoDiagram {

	val colors = mutableMapOf<Int, Color>()

	override fun draw(drawer: PixelDrawer, points: Iterable<Point>) {
		val points = points.toList()
		for(x in 0 .. drawer.width)
			for(y in 0 .. drawer.height) {
				val p = Point(x, y)
				val c = points.minIndexBy { distanceSqr(p, it) }
				val color = colors.getOrPut(c) {
					val r = ThreadLocalRandom.current().nextInt(100, 256)
					val g = ThreadLocalRandom.current().nextInt(100, 256)
					val b = ThreadLocalRandom.current().nextInt(100, 256)
					Color(r, g, b)
				}
				drawer.drawPixel(x, y, color)
			}
	}
}

private inline fun <E, T : Comparable<T>> List<E>.minIndexBy(crossinline block: (E) -> T): Int {
	var index = 0
	var minElement = block(get(index))
	for(i in 1 ..< size) {
		val element = block(get(i))
		if(minElement > element) {
			minElement = element
			index = i
		}
	}
	return index
}
