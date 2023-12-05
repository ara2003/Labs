package com.example.labs.giis_7.obj

import com.example.labs.giis_7.pixel.BaseDrawCounter
import com.example.labs.giis_7.pixel.DebugPixelDrawer
import com.example.labs.giis_7.pixel.PixelDrawer

class DebugDrawObject(val origin: DrawObject) : DrawObject by origin {

	private var points: Int = 0

	fun addPoint() {
		points++
	}

	fun removePoint() {
		points--
		if(0 > points)
			points = 0
	}

	override fun draw(g: PixelDrawer) {
		val count = origin.countPixel(g)
		if(count < points)
			points = count
		val g = DebugPixelDrawer(g, BaseDrawCounter(points))
		origin.draw(g)
	}
}