package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.MultiPointDrawObject
import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.obj.drawer.MultiPointDrawer

class MultiPointGeneratorImpl(private val drawer: MultiPointDrawer) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = MultiPointDrawObject(points, drawer)
}