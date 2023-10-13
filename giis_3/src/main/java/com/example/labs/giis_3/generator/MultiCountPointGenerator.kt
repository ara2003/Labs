package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.DebugDrawObject
import com.example.labs.giis_3.obj.DrawObject
import com.example.labs.giis_3.obj.Point

abstract class MultiCountPointGenerator(private val count: Int) : ObjectGenerator {
	init {
		require(count > 1)
	}

	private var points = mutableListOf<Point>()
	private var mouse: Point? = null
	private var obj: DrawObject? = null

	abstract fun newObject(points: Collection<Point>): DrawObject

	override fun move(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		val mouse = mouse ?: return
		mouse.x = x
		mouse.y = y
		ctx.repaint()
	}

	override fun click(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		if(points.size == count) {
			if(ctx.isDebug) {
				var line = obj!!
				ctx.remove(line)
				line = DebugDrawObject(line)
				ctx.add(line)
			}
			ctx.repaint()
			points = mutableListOf()
			obj = null
			mouse = null
			return
		}
		val p = Point(x, y)
		points.add(p)
		if(points.size == count - 1) {
			val mouse = Point(x, y)
			this.mouse = mouse
			points.add(mouse)
			val obj = newObject(points)
			this.obj = obj
			ctx.add(obj)
			ctx.repaint()
		}
	}
}