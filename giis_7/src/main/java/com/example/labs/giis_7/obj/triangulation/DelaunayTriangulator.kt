package com.example.labs.giis_7.obj.triangulation

import com.example.labs.giis_7.obj.Line
import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.Triangle
import com.example.labs.giis_7.obj.center
import com.example.labs.giis_7.obj.solver.JarvisMinimalConvexHullSolver
import com.example.labs.giis_7.obj.solver.rotate
import java.util.*

object DelaunayTriangulator : Triangulator {

	override fun solve(points: Iterable<Point>): Iterable<Triangle> {
		val points = points.toList()
		if(points.size < 3)
			return listOf()
		val result = mutableListOf<Line>()
		val resultTriangle = mutableSetOf<Triangle>()
		val active = Stack<Line>()
		run {
			val ps = JarvisMinimalConvexHullSolver.solve(points).toList()
			active.add(Line(ps[0], ps[1]))
		}
		fun distance(a: Point, b: Point): Int {
			val dx = a.x - b.x
			val dy = a.y - b.y
			return dx * dx + dy * dy
		}

		fun sopr(ab: Line): Point? {
			val a = ab.p1
			val b = ab.p2
			return points.filter { rotate(a, b, it) > 0 }.minByOrNull { distance(Triangle(a, b, it).center, a) }
		}
		while(active.isNotEmpty()) {
			val e = active.pop()
			result.add(e)
			val p = sopr(e) ?: continue
			resultTriangle.add(Triangle(e.p1, e.p2, p))
			val a = Line(e.p1, p)
			val b = Line(p, e.p2)
			fun up(a: Line) {
				require(a !in result) { "$a in $result" }
				if(a in active) {
					active.remove(a)
					result.add(a)
				} else active.add(a)
			}
			up(a)
			up(b)
		}
		return resultTriangle
	}
}