package com.example.labs.giis_5.obj

import com.example.labs.giis_5.pixel.GraphicsPixelDrawer
import com.example.labs.giis_5.pixel.PixelDrawer
import java.awt.Color
import java.awt.Graphics

interface DrawObject : Iterable<Point> {

	val lines: Iterable<Line>
		get() {
			val points = mutableListOf<Point>()
			draw(object : PixelDrawer {
				override fun drawPixel(x: Int, y: Int, c: Color) {
					points.add(Point(x, y))
				}
			})
			return points.toLinesOpen()
		}

	fun draw(drawer: PixelDrawer)

	fun countPixel(): Int {
		var count = 0
		val counter = object : PixelDrawer {
			override fun drawPixel(x: Int, y: Int, c: Color) {
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

