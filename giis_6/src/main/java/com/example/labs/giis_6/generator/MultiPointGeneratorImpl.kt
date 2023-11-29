package com.example.labs.giis_6.generator

import com.example.labs.giis_6.obj.MultiPointDrawObject
import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.drawer.MultiPointDrawer

class MultiPointGeneratorImpl(private val drawer: MultiPointDrawer) : MultiPointGenerator() {

	override fun newObject(points: Collection<Point>) = MultiPointDrawObject(points, drawer)
}