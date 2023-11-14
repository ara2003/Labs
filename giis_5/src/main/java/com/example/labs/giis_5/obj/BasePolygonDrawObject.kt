package com.example.labs.giis_5.obj

import com.example.labs.giis_5.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_5.obj.drawer.TwoPointDrawer
import com.example.labs.giis_5.obj.drawer.draw
import com.example.labs.giis_5.obj.solver.MinimalConvexHullSolver
import com.example.labs.giis_5.obj.solver.rotate
import com.example.labs.giis_5.pixel.PixelDrawer

class BasePolygonDrawObject(val points: Collection<Point>, override val drawer: TwoPointDrawer = BresenhamLineDrawer): PolygonDrawObject {

	override fun isInside(point: Point): Boolean {
		if(points.size < 3)
			return false
		val line = Line(point.x, point.y, 1000, point.y)
		val count = lines.count { cross(it, line) != null }
		return count % 2 == 1
	}

	override val lines: Iterable<Line>
		get() = toLines()


	override fun iterator() = points.toClock().iterator()

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
