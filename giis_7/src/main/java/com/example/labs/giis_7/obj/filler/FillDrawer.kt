package com.example.labs.giis_7.obj.filler

import com.example.labs.giis_7.obj.PolygonDrawObject
import com.example.labs.giis_7.pixel.PixelDrawer

interface FillDrawer {

	fun draw(drawer: PixelDrawer, polygon: PolygonDrawObject)
}
