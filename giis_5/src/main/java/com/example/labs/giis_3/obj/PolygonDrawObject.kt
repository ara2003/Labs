package com.example.labs.giis_3.obj

import com.example.labs.giis_3.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_3.obj.drawer.TwoPointDrawer
import com.example.labs.giis_3.obj.drawer.draw
import com.example.labs.giis_3.obj.solver.MinimalConvexHullSolver
import com.example.labs.giis_3.obj.solver.rotate
import com.example.labs.giis_3.pixel.PixelDrawer

class PolygonDrawObject(val points: Collection<Point>, val solver: MinimalConvexHullSolver, val drawer: TwoPointDrawer = BresenhamLineDrawer) : DrawObject {

	override val lines: Iterable<Line>
		get() = solver.solve(points).toLines()

	override fun draw(drawer: PixelDrawer) {
		for(line in lines) {
			this.drawer.draw(drawer, line)
			val normal = line.normal
			val center = line.center
			this.drawer.draw(drawer, center, center + (normal * 15f))
		}
	}

	override fun iterator() = points.iterator()

	fun isInside(point: Point) = lines.all {
		val rot = rotate(it.p1, it.p2, point)
		rot > 0
	}
}

infix fun Point.inside(polygon: PolygonDrawObject) = polygon.isInside(this)
