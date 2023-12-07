package com.example.labs.giis_7.obj

import com.example.labs.giis_7.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_7.obj.drawer.TwoPointDrawer
import com.example.labs.giis_7.obj.drawer.draw
import com.example.labs.giis_7.obj.solver.JarvisMinimalConvexHullSolver
import com.example.labs.giis_7.obj.triangulation.Triangulator
import com.example.labs.giis_7.pixel.PixelDrawer

data class TriangulationDrawObject(
	val points: Iterable<Point>,
	val triangulator: Triangulator,
	val lineDrawer: TwoPointDrawer = BresenhamLineDrawer,
) : DrawObject {

	override val lines: Iterable<Line>
		get() = JarvisMinimalConvexHullSolver.solve(points).toLines()

	override fun draw(drawer: PixelDrawer) = triangulator.solve(points).forEach {
		lineDrawer.draw(drawer, it.a, it.b)
		lineDrawer.draw(drawer, it.b, it.c)
		lineDrawer.draw(drawer, it.c, it.a)
//		CircleDrawer.draw(drawer, it.center, Point(it.center.x, it.center.y + it.radius))
	}

	override fun iterator() = points.iterator()
}