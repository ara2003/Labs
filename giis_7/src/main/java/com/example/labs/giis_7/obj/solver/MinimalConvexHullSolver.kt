package com.example.labs.giis_7.obj.solver

import com.example.labs.giis_7.obj.Point

interface MinimalConvexHullSolver {

	fun solve(points: Iterable<Point>): Iterable<Point>
}

fun rotate(a: Point, b: Point, c: Point) = (b.x - a.x) * (c.y - b.y) - (b.y - a.y) * (c.x - b.x)
