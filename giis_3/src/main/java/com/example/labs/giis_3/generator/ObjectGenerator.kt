package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.DrawObject

interface ObjectGenerator {

	fun click(ctx: Context, x: Int, y: Int)
	fun move(ctx: Context, x: Int, y: Int) {
	}

	interface Context {

		val isDebug: Boolean

		fun add(obj: DrawObject)
		fun remove(obj: DrawObject)
		fun repaint()
	}
}