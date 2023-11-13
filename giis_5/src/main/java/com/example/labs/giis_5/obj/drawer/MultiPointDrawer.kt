package com.example.labs.giis_5.obj.drawer

import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.pixel.PixelDrawer

interface MultiPointDrawer {

	fun draw(g: PixelDrawer, points: Collection<Point>)
}
