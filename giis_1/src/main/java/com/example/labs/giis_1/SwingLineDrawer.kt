package com.example.labs.giis_1

import java.awt.Graphics

object SwingLineDrawer : LineDrawer {

	override fun drawLine(g: Graphics, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		drawLine(x1, y1, x2, y2)
	}
}