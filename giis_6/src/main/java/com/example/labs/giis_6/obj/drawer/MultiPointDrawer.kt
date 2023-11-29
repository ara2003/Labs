package com.example.labs.giis_6.obj.drawer

import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.pixel.PixelDrawer

interface MultiPointDrawer {

	fun draw(g: PixelDrawer, points: Collection<Point>)
}
