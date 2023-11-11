package com.example.labs.giis_3.obj.solver

import com.example.labs.giis_3.obj.Point
import java.util.stream.IntStream.*
import javax.swing.text.html.HTML.Tag.*

object JarvisMinimalConvexHullSolver : MinimalConvexHullSolver {

	override fun solve(points: Iterable<Point>): Iterable<Point> {
		val a = points.toList()
		val n = a.size
		if(n < 3)
			return listOf()
		val p = ArrayList<Int>()
		repeat(n) {
			p.add(it)
		}
		for(i in range(1, n)) {
			if(a[p[i]].x < a[p[0]].x) {
				val t = p[0]
				p[0] = p[i]
				p[i] = t
			}
		}
		val result = mutableListOf<Int>()
		result.add(p[0])
		p.removeAt(0)
		p.add(result[0])
		while(true) {
			var right = 0
			for(i in range(1, p.size)) {
				if(rotate(a[result[result.size-1]], a[p[right]], a[p[i]]) < 0) {
					right = i
				}
			}
			if(p[right] == result[0]) {
				break
			}else {
				result.add(p[right])
				p.removeAt(right)
			}
		}
		return result.map { a[it] }
	}
}