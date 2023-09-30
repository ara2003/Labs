package com.example.labs.giis_2.pixel

import com.example.labs.giis_2.pixel.DrawCounter

class BaseDrawCounter(private var kadr: Int) : DrawCounter {

	override fun draw() = kadr-- > 0
}
