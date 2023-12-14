package com.example.labs.giis_7.obj

data class Line(val p1: Point, val p2: Point) : Iterable<Point> {

	override fun iterator() = listOf(p1, p2).iterator()

	override fun equals(other: Any?): Boolean {
		if(this === other) return true
		if(other !is Line) return false

		if(p1 == other.p1 && p2 == other.p2) return true
		if(p2 == other.p1 && p1 == other.p2) return true

		return false
	}

	override fun hashCode(): Int {
		return p1.hashCode() + p2.hashCode()
	}
}

fun Line(x1: Int, y1: Int, x2: Int, y2: Int) = Line(Point(x1, y1), Point(x2, y2))

val Line.normal: Pair<Float, Float>
	get() = Pair(a, b).normalized()
val Line.center
	get() = (p1 + p2) / 2f
val Line.a
	get() = p2.y - p1.y + 0f
val Line.b
	get() = p1.x - p2.x + 0f
val Line.c
	get() = -p1.x * a - p1.y * b
val Line.vector
	get() = p2 - p1
val Line.perpendicular
	get() = Line(center, center + normal * 10f)

operator fun Line.times(other: Line) = vector * other.vector

fun crossProduct(l1: Line, l2: Line): Point? {
	val det = l1.a * l2.b - l2.a * l1.b
	if(det == 0f) return null
	val x = (-(l2.b * l1.c - l1.b * l2.c) / det).toInt()
	val y = ((l2.a * l1.c - l1.a * l2.c) / det).toInt()
	return Point(x, y)
}

fun cross(l1: Line, l2: Line): Point? {
	val (x, y) = crossProduct(l1, l2) ?: return null
	for(l in listOf(l1, l2)) {
		if(x !in (l.minOf { it.x } .. l.maxOf { it.x }))
			return null
		if(y !in (l.minOf { it.y } .. l.maxOf { it.y }))
			return null
	}
	return Point(x, y)
}

fun Iterable<Point>.toLines(): Iterable<Line> {
	val result = mutableListOf<Line>()
	toLinesOpen(result)
	if(result.size > 1)
		result.add(Line(last(), first()))
	return result
}

fun Iterable<Point>.toLinesOpen(): Iterable<Line> {
	return toLinesOpen(mutableListOf())
}

fun <T : MutableCollection<Line>> Iterable<Point>.toLinesOpen(result: T): T {
	val iter = iterator()
	if(!iter.hasNext())
		return result
	var a = iter.next()
	while(iter.hasNext()) {
		val b = iter.next()
		result.add(Line(a, b))
		a = b
	}
	return result
}