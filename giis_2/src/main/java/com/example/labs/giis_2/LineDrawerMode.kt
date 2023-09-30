package com.example.labs.giis_2

import com.example.labs.giis_2.generator.LineGenerator
import com.example.labs.giis_2.generator.ObjectGenerator
import com.example.labs.giis_2.obj.drawer.TwoPointDrawer

interface LineDrawerMode {

	fun debug()
	var generator: ObjectGenerator
}

var LineDrawerMode.drawer: TwoPointDrawer
	set(value) {
		generator = LineGenerator(value)
	}
	get() = (generator as LineGenerator).drawer