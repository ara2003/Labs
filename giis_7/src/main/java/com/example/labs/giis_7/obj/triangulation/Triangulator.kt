package com.example.labs.giis_7.obj.triangulation

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.obj.Triangle

interface Triangulator {

	fun solve(points: Iterable<Point>): Iterable<Triangle>
}
