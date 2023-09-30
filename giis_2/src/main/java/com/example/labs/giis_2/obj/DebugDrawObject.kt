package com.example.labs.giis_2.obj

import com.example.labs.giis_2.pixel.BaseDrawCounter
import com.example.labs.giis_2.pixel.DebugPixelDrawer
import com.example.labs.giis_2.pixel.PixelDrawer

class DebugDrawObject(val origin: DrawObject) : DrawObject {

	private var points: Int = 0

	fun addPoint() {
		points++
	}

	fun removePoint() {
		points--
	}

	override fun draw(g: PixelDrawer) {
		val count = origin.countPixel()
		if(count < points)
			points = count
		if(0 > points)
			points = 0
		val g = DebugPixelDrawer(g, BaseDrawCounter(points))
		origin.draw(g)
	}
}