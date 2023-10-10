package com.example.labs.giis_2.pixel

import java.awt.Color
import java.awt.Graphics

class GraphicsPixelDrawer(private val g: Graphics) : PixelDrawer {

	override fun drawPixel(x: Int, y: Int) = g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE)

	override fun drawPixel(x: Int, y: Int, c: Float) = g.run {
		setColor(Color(0, 0, 0, (255 * c).toInt())) {
			drawPixel(x, y)
		}
	}
}

