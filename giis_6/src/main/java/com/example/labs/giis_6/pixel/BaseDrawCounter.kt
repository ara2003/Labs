package com.example.labs.giis_6.pixel

class BaseDrawCounter(private var kadr: Int) : DrawCounter {

	override fun draw() = kadr-- > 0
}
