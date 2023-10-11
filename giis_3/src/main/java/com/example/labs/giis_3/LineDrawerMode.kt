package com.example.labs.giis_3

import com.example.labs.giis_3.generator.FourPointGenerator
import com.example.labs.giis_3.generator.MultiPointGeneratorImpl
import com.example.labs.giis_3.generator.ObjectGenerator
import com.example.labs.giis_3.generator.TwoPointGeneratorImpl
import com.example.labs.giis_3.obj.drawer.FourPointDrawer
import com.example.labs.giis_3.obj.drawer.MultiPointDrawer
import com.example.labs.giis_3.obj.drawer.TwoPointDrawer

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