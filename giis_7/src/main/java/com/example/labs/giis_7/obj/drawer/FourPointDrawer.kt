package com.example.labs.giis_7.obj.drawer

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.pixel.PixelDrawer

interface FourPointDrawer {

	fun draw(g: PixelDrawer, p1: Point, p2: Point, p3: Point, p4: Point)
}
