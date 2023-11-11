package com.example.labs.giis_3.pixel

import com.example.labs.giis_3.obj.Point
import java.awt.Color
import java.awt.Graphics

const val PIXEL_SIZE = 5

interface PixelDrawer {

	fun drawPixel(x: Int, y: Int) = drawPixel(x, y, 1f)
	fun drawPixel(x: Int, y: Int, c: Float)
}

fun PixelDrawer.drawPixel(p: Point) {
	drawPixel(p.x, p.y)
}

fun <R> Graphics.setColor(c: Color, block: () -> R): R {
	val tempColor = color
	color = c
	val result = block()
	color = tempColor
	return result
}