package com.example.labs.giis_1

import java.awt.Color
import java.awt.Graphics

interface LineDrawer {

	fun drawLine(g: Graphics, x1: Int, y1: Int, x2: Int, y2: Int)
}

const val PIXEL_SIZE = 1

fun Graphics.drawPixel(x: Int, y: Int) = fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE)
fun Graphics.drawPixel(x: Int, y: Int, c: Float) {
	val tempColor = color
	color = Color(0, 0, 0, (255 * c).toInt())
	drawPixel(x, y)
	color = tempColor
}
