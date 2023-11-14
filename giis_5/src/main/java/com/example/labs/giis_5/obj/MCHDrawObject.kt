package com.example.labs.giis_5.obj

import com.example.labs.giis_5.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_5.obj.drawer.TwoPointDrawer
import com.example.labs.giis_5.obj.drawer.draw
import com.example.labs.giis_5.obj.solver.MinimalConvexHullSolver
import com.example.labs.giis_5.obj.solver.rotate
import com.example.labs.giis_5.pixel.PixelDrawer

class MCHDrawObject(val points: Collection<Point>, val solver: MinimalConvexHullSolver, override val drawer: TwoPointDrawer = BresenhamLineDrawer) : PolygonDrawObject {

	override val lines: Iterable<Line>
		get() = solver.solve(points).toLines()

	override fun iterator() = points.iterator()

	override fun isInside(point: Point)  = lines.all {
		rotate(it.p1, it.p2, point) > 0
	}

	override fun isHull() = true

}
