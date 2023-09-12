package com.example.labs.giis_1

import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel

class MyPanel : JPanel(), LineDrawerMode {

	private val lines = mutableListOf<Line>()

	init {
		addMouseListener(MyMouseListener())
	}

	private inner class MyMouseListener : MouseAdapter() {

		private var mouse: Point? = null

		override fun mouseClicked(e: MouseEvent) {
			mouse = if(mouse == null) {
				Point(e.x, e.y)
			} else {
				lines.add(Line(mouse!!, Point(e.x, e.y), drawer))
				repaint()
				null
			}
		}
	}

	override fun paint(g: Graphics) {
		super.paint(g)
		g.color = Color.black
		for(line in lines)
			line.print(g)
	}

	override var drawer: LineDrawer = CDALineDrawer

	data class Point(val x: Int, val y: Int)
	data class Line(val p1: Point, val p2: Point, val drawer: LineDrawer) {
		constructor(
			x1: Int,
			y1: Int,
			x2: Int,
			y2: Int,
			drawer: LineDrawer,
		) : this(Point(x1, y1), Point(x2, y2), drawer)
	}
}

private fun MyPanel.Line.print(g: Graphics) {
	drawer.drawLine(g, p1.x / PIXEL_SIZE, p1.y / PIXEL_SIZE, p2.x / PIXEL_SIZE, p2.y / PIXEL_SIZE)
}
