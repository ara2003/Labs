package com.example.labs.giis_7.pixel

import java.awt.Color
import java.awt.Graphics2D

class GraphicsPixelDrawer(private val g: Graphics2D) : PixelDrawer {

	override val width: Int
		get() = g.deviceConfiguration.bounds.width / PIXEL_SIZE
	override val height: Int
		get() = g.deviceConfiguration.bounds.height / PIXEL_SIZE

	override fun drawPixel(x: Int, y: Int) = g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE)

	override fun drawPixel(x: Int, y: Int, c: Color) {
		g.setColor(c) {
			drawPixel(x, y)
		}
	}
}

