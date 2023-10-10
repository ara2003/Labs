package com.example.labs.giis_3.obj.drawer

import com.example.labs.giis_3.pixel.PixelDrawer

interface TwoPointDrawer {

	fun drawTwoPointObject(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int)
}