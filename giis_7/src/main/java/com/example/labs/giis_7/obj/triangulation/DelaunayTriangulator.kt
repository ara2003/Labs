package com.example.labs.giis_7.obj.triangulation

import com.example.labs.giis_7.obj.Line
import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.cross
import com.example.labs.giis_7.obj.solver.JarvisMinimalConvexHullSolver

object DelaunayTriangulator : Triangulator {

	override fun draw(points: Iterable<Point>): Iterable<Line> {
		val points = JarvisMinimalConvexHullSolver.solve(points).sortedBy { it.x }.toList()
		if(points.size < 3)
			return listOf()
		val result = mutableListOf<Line>()
		result.add(Line(points[0], points[1]))
		result.add(Line(points[1], points[2]))
		result.add(Line(points[2], points[0]))
		fun canSee(point: Point) = result.flatten().filter { p ->
			result.all {
				val c = cross(it, Line(p, point))
				c == null || c == p
			}
		}
		for(i in 3 ..< points.size) {
			val p = points[i]
			for(c in canSee(p)) {
				result.add(Line(p, c))
			}
		}
		return result
	}
}