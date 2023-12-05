package com.example.labs.giis_7.obj.drawer

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.pixel.PixelDrawer

interface MultiPointDrawer {

	fun draw(g: PixelDrawer, points: Collection<Point>)
}
