package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.DebugDrawObject
import com.example.labs.giis_3.obj.DrawObject
import com.example.labs.giis_3.obj.Point

abstract class TwoPointGenerator : ObjectGenerator {

	private var mouse: Point? = null
	private var line: DrawObject? = null

	abstract fun newObject(p1: Point, p2: Point): DrawObject

	override fun move(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		val mouse = mouse
		if(mouse != null) {
			mouse.x = x
			mouse.y = y
			ctx.repaint()
		}
	}

	override fun click(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		if(mouse == null) {
			val mouse = Point(x, y)
			this.mouse = mouse
			val line = newObject(Point(x, y), mouse)
			this.line = line
			ctx.add(line)
		} else {
			if(ctx.isDebug) {
				var line: DrawObject = line!!
				ctx.remove(line)
				line = DebugDrawObject(line)
				ctx.add(line)
			}
			ctx.repaint()
			mouse = null
			line = null
		}
	}
}