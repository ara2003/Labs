package com.example.labs.giis_1

import java.awt.Color
import java.awt.Graphics

const val PIXEL_SIZE = 20

interface PixelDrawer {

	fun drawPixel(x: Int, y: Int) = drawPixel(x, y, 1f)
	fun drawPixel(x: Int, y: Int, c: Float)
}

fun <R> Graphics.setColor(c: Color, block: () -> R): R {
	val tempColor = color
	color = c
	val result = block()
	color = tempColor
	return result
}