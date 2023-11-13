package com.example.labs.giis_3.obj.solver

import com.example.labs.giis_3.obj.Point
import java.util.stream.IntStream.*
import javax.swing.text.html.HTML.Tag.*

object GrahamMinimalConvexHullSolver : MinimalConvexHullSolver {

	override fun solve(points: Iterable<Point>): Iterable<Point> {
		val a = points.toSet().toList()
		val n = a.size
		if(n < 3)
			return listOf()
		val p = IntArray(n) { it }
		for(i in range(1, n)) {
			if(a[p[i]].x < a[p[0]].x) {
				val t = p[0]
				p[0] = p[i]
				p[i] = t
			}
		}
		for(i in range(2,n)) {
			var j = i
			while(j > 1 && (rotate(a[p[0]], a[p[j - 1]], a[p[j]]) < 0)) {
				val t = p[j - 1]
				p[j-1] = p[j]
				p[j] = t
				j--
			}
		}
		val result = mutableListOf<Int>()
		result.add(p[0])
		result.add(p[1])
		for(i in range(2, n)) {
			while(rotate(a[result[result.size-2]], a[result[result.size-1]], a[p[i]]) < 0)
				result.removeAt(result.size - 1)
			result.add(p[i])
		}
		return result.map { a[it] }
	}
}