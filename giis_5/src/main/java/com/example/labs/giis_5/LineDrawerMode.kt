package com.example.labs.giis_5

import com.example.labs.giis_5.generator.FourPointGenerator
import com.example.labs.giis_5.generator.MultiPointGeneratorImpl
import com.example.labs.giis_5.generator.ObjectGenerator
import com.example.labs.giis_5.generator.PolygonGenerator
import com.example.labs.giis_5.generator.TwoPointGeneratorImpl
import com.example.labs.giis_5.obj.drawer.FourPointDrawer
import com.example.labs.giis_5.obj.drawer.MultiPointDrawer
import com.example.labs.giis_5.obj.drawer.TwoPointDrawer
import com.example.labs.giis_5.obj.solver.MinimalConvexHullSolver

interface LineDrawerMode {

	fun debug()
	var generator: ObjectGenerator
}

fun LineDrawerMode.setDrawer(value: TwoPointDrawer) {
	generator = TwoPointGeneratorImpl(value)
}

fun LineDrawerMode.setDrawer(value: FourPointDrawer) {
	generator = FourPointGenerator(value)
}

fun LineDrawerMode.setDrawer(value: MultiPointDrawer) {
	generator = MultiPointGeneratorImpl(value)
}

fun LineDrawerMode.setDrawer(value: MinimalConvexHullSolver) {
	generator = PolygonGenerator(value)
}