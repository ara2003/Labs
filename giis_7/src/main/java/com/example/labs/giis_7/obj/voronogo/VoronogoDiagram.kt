package com.example.labs.giis_7.obj.voronogo

import com.example.labs.giis_7.obj.Point
import com.example.labs.giis_7.pixel.PixelDrawer

interface VoronogoDiagram {

	fun draw(drawer: PixelDrawer, points: Iterable<Point>)
}
