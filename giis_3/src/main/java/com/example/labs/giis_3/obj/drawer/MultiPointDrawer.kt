package com.example.labs.giis_3.obj.drawer

import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.pixel.PixelDrawer

interface MultiPointDrawer {

	fun draw(g: PixelDrawer, points: Collection<Point>)
}
