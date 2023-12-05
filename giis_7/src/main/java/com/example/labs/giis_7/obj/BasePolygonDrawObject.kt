package com.example.labs.giis_7.obj

import com.example.labs.giis_7.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_7.obj.drawer.TwoPointDrawer

class BasePolygonDrawObject(val points: Collection<Point>, override val drawer: TwoPointDrawer = BresenhamLineDrawer) :
	PolygonDrawObject {

	override fun isInside(point: Point): Boolean {
		if(points.size < 3)
			return false
		val line = Line(point.x, point.y, 1000, point.y)
		val points = points.triples().filter { (a, b, c) -> (a.y - b.y) * (c.y - b.y) < 0 }.map { it.second }
		val count = lines.mapNotNull { cross(it, line) }.toMutableList()
		for(p in points)
			count.remove(p)
		return count.size % 2 == 1
	}

	override val lines: Iterable<Line>
		get() = toLines()

	override fun iterator() = points.toClock().iterator()
}

private fun <E> Iterable<E>.triples(): Collection<Triple<E, E, E>> {
	val cycle = mutableListOf<E>()
	cycle.addAll(this)
	run {
		val iter = iterator()
		if(!iter.hasNext())
			return listOf()
		val a = iter.next()
		if(!iter.hasNext())
			return listOf()
		val b = iter.next()
		cycle.add(a)
		cycle.add(b)
	}
	val iter = cycle.iterator()
	var a = iter.next()
	var b = iter.next()
	val result = mutableListOf<Triple<E, E, E>>()
	while(iter.hasNext()) {
		val c = iter.next()
		result.add(Triple(a, b, c))
		a = b
		b = c
	}
	return result
}

private fun Collection<Point>.toClock(): Collection<Point> {
	if(size < 3)
		return this
	val iter = toLines().iterator()
	val a = iter.next()
	val b = iter.next()
	if(a * b > 0)
		return this
	return reversed()
}
