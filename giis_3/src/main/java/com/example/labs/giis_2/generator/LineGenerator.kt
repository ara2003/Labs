package com.example.labs.giis_2.generator

import com.example.labs.giis_2.obj.Point
import com.example.labs.giis_2.obj.TwoPointDrawObject
import com.example.labs.giis_2.obj.drawer.TwoPointDrawer

class LineGenerator(val drawer: TwoPointDrawer) : TwoPointGenerator() {

	override fun newObject(p1: Point, p2: Point) = TwoPointDrawObject(p1, p2, drawer)
}