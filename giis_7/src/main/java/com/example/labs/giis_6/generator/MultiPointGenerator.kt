package com.example.labs.giis_6.generator

import com.example.labs.giis_6.obj.DrawObject
import com.example.labs.giis_6.obj.Point

abstract class MultiPointGenerator : ObjectGenerator {

	private var points = mutableListOf<Point>()
	private var mouse: Point? = null

	abstract fun newObject(points: Collection<Point>): DrawObject

	override fun end(ctx: ObjectGenerator.Context) {
		points = mutableListOf()
		mouse = null
	}

	override fun move(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		val mouse = mouse ?: return
		mouse.x = x
		mouse.y = y
		ctx.repaint()
	}

	override fun click(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		if(points.isEmpty()) {
			val p = Point(x, y)
			points.add(p)
			val obj = newObject(points)
			ctx.add(obj)
			ctx.repaint()
		}
		val p = Point(x, y)
		points.add(p)
		this.mouse = p
		ctx.repaint()
	}
}