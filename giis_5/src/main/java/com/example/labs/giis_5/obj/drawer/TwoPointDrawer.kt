package com.example.labs.giis_5.obj.drawer

import com.example.labs.giis_5.obj.Line
import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.pixel.PixelDrawer

interface TwoPointDrawer {

	fun draw(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int)
}

fun TwoPointDrawer.draw(g: PixelDrawer, p1: Point, p2: Point) = draw(g, p1.x, p1.y, p2.x, p2.y)
fun TwoPointDrawer.draw(g: PixelDrawer, line: Line) = draw(g,line.p1, line. p2)
