package com.example.labs.giis_6.obj.filler

import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.PolygonDrawObject
import com.example.labs.giis_6.pixel.PixelDrawer

interface FillDrawer {

	fun draw(drawer: PixelDrawer, polygon: PolygonDrawObject)
}
