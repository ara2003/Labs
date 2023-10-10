package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.obj.TwoPointDrawObject
import com.example.labs.giis_3.obj.drawer.TwoPointDrawer

class TwoPointGeneratorImpl(val drawer: TwoPointDrawer) : TwoPointGenerator() {

	override fun newObject(p1: Point, p2: Point) = TwoPointDrawObject(p1, p2, drawer)
}