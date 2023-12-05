package com.example.labs.giis_6.pixel

import java.awt.Color
import java.awt.Graphics

class GraphicsPixelDrawer(private val g: Graphics) : PixelDrawer {

	override fun drawPixel(x: Int, y: Int) = g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE)

	override fun drawPixel(x: Int, y: Int, c: Color) {
		g.setColor(c) {
			drawPixel(x, y)
		}
	}
}

