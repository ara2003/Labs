package com.example.labs.giis_7.pixel

class BaseDrawCounter(private var kadr: Int) : DrawCounter {

	override fun draw() = kadr-- > 0
}
