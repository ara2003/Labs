package com.example.labs.giis_5.generator

import com.example.labs.giis_5.obj.MultiPointDrawObject
import com.example.labs.giis_5.obj.Point
import com.example.labs.giis_5.obj.drawer.MultiPointDrawer

class MultiPointGeneratorImpl(private val drawer: MultiPointDrawer) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = MultiPointDrawObject(points, drawer)
}