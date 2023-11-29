package com.example.labs.giis_6.generator

import com.example.labs.giis_6.obj.Point
import kotlin.math.sqrt

object MouseMove : ObjectGenerator {

	private var mouse: Point? = null
	private var lastX = 0
	private var lastY = 0

	override fun move(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		val mouse = mouse ?: return
		mouse.x += x - lastX
		mouse.y += y - lastY
		lastX = x
		lastY = y
		ctx.repaint()
	}

	override fun press(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		mouse = ctx.flatMap { it }.minBy { it.distance(x, y) }
		lastX = x
		lastY = y
	}

	override fun release(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		mouse = null
	}
}

private fun Point.distance(x: Int, y: Int): Double {
	val dx = x - this.x
	val dy = y - this.y
	return sqrt(dx * dx + dy * dy + 0.0)
}
