package com.example.labs.giis_7.generator

import com.example.labs.giis_7.obj.DrawObject

interface ObjectGenerator {

	fun click(ctx: Context, x: Int, y: Int) {}
	fun move(ctx: Context, x: Int, y: Int) {}

	fun begin(ctx: Context, x: Int, y: Int) {}
	fun end(ctx: Context) {}

	fun press(ctx: Context, x: Int, y: Int) {}
	fun release(ctx: Context, x: Int, y: Int) {}

	interface Context : Iterable<DrawObject> {

		val isDebug: Boolean

		fun add(obj: DrawObject)
		fun remove(obj: DrawObject)
		fun repaint()
	}
}