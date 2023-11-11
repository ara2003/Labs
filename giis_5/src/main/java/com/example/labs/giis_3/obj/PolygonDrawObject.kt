package com.example.labs.giis_3.obj

import com.example.labs.giis_3.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_3.obj.drawer.TwoPointDrawer
import com.example.labs.giis_3.obj.drawer.draw
import com.example.labs.giis_3.obj.solver.MinimalConvexHullSolver
import com.example.labs.giis_3.pixel.PixelDrawer

class PolygonDrawObject(val points: Collection<Point>, val solver: MinimalConvexHullSolver, val drawer: TwoPointDrawer = BresenhamLineDrawer) : DrawObject {

	override val lines: Iterable<Line>
		get() = solver.solve(points).toLines()

	override fun draw(drawer: PixelDrawer) {
		for(line in lines)
			this.drawer.draw(drawer, line)
	}

	override fun iterator() = points.iterator()
}
