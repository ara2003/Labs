package com.example.labs.giis_7.obj

import com.example.labs.giis_7.pixel.GraphicsPixelDrawer
import com.example.labs.giis_7.pixel.PixelDrawer
import java.awt.Color
import java.awt.Graphics2D

interface DrawObject : Iterable<Point> {

	val lines: Iterable<Line>
		get() {
			val points = mutableListOf<Point>()
			draw(object : PixelDrawer {
				override val width: Int
					get() = TODO("Not yet implemented")
				override val height: Int
					get() = TODO("Not yet implemented")

				override fun drawPixel(x: Int, y: Int, c: Color) {
					points.add(Point(x, y))
				}
			})
			return points.toLinesOpen()
		}

	fun draw(drawer: PixelDrawer)

	fun countPixel(drawer: PixelDrawer): Int {
		var count = 0
		val counter = object : PixelDrawer by drawer {
			override fun drawPixel(x: Int, y: Int, c: Color) {
				count++
			}
		}
		draw(counter)
		return count
	}
}

fun DrawObject.draw(g: Graphics2D) {
	draw(GraphicsPixelDrawer(g))
}

