package com.example.labs.giis_7.obj.voronogo

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.distanceSqr
import com.example.labs.giis_7.pixel.PixelDrawer
import java.awt.Color
import java.util.concurrent.ThreadLocalRandom

private val PixelDrawer.widthScale
	get() = when(this) {
		is WidthSplit -> 2 * origin.width
		is HeightSplit -> origin.width
		else -> 1
	}
private val PixelDrawer.heightScale
	get() = when(this) {
		is WidthSplit -> origin.width
		is HeightSplit -> 2 * origin.width
		else -> 1
	}

object FillVoronogoDiagram : VoronogoDiagram {

	val colors = mutableMapOf<Int, Color>()

	override fun draw(drawer: PixelDrawer, points: Iterable<Point>) {
		val points = points.map { (x, y) -> Point(x / drawer.widthScale, y / drawer.heightScale) }
		for(x in 0 .. drawer.width)
			for(y in 0 .. drawer.height) {
				val p = Point(x, y)
				val c = points.minIndexBy { distanceSqr(p, it) }
				val color = colors.getOrPut(c) {
					val r = ThreadLocalRandom.current().nextInt(256)
					val g = ThreadLocalRandom.current().nextInt(256)
					val b = ThreadLocalRandom.current().nextInt(256)
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
