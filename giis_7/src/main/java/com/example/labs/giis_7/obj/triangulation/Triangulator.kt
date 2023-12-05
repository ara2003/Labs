package com.example.labs.giis_7.obj.triangulation

import com.example.labs.giis_7.obj.Line
import com.example.labs.giis_7.obj.Point

interface Triangulator {

	fun draw(points: Iterable<Point>): Iterable<Line>
}
