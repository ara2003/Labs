package com.example.labs.giis_3.obj

import com.example.labs.giis_3.pixel.GraphicsPixelDrawer
import com.example.labs.giis_3.pixel.PixelDrawer
import java.awt.Graphics

interface DrawObject : Iterable<Point> {

	fun draw(drawer: PixelDrawer)

	fun countPixel(): Int {
		var count = 0
		val counter = object : PixelDrawer {
			override fun drawPixel(x: Int, y: Int, c: Float) {
				count++
			}
		}
		draw(counter)
		return count
	}
}

fun DrawObject.draw(g: Graphics) {
	draw(GraphicsPixelDrawer(g))
}

