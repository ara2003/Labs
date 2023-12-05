package com.example.labs.giis_6

import com.example.labs.giis_6.generator.FillPolygonGenerator
import com.example.labs.giis_6.generator.FourPointGenerator
import com.example.labs.giis_6.generator.MultiPointGeneratorImpl
import com.example.labs.giis_6.generator.ObjectGenerator
import com.example.labs.giis_6.generator.PolygonGenerator
import com.example.labs.giis_6.generator.TwoPointGeneratorImpl
import com.example.labs.giis_6.obj.drawer.FourPointDrawer
import com.example.labs.giis_6.obj.drawer.MultiPointDrawer
import com.example.labs.giis_6.obj.drawer.TwoPointDrawer
import com.example.labs.giis_6.obj.filler.FillDrawer
import com.example.labs.giis_6.obj.solver.MinimalConvexHullSolver

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

fun LineDrawerMode.setDrawer(value: FillDrawer) {
	generator = FillPolygonGenerator(value)
}