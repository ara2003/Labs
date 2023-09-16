package com.example.labs.giis_1

class BaseDrawCounter(private var kadr: Int) : DrawCounter {

	override fun draw() = kadr-- > 0
}
