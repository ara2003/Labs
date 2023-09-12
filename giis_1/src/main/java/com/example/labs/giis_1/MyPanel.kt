package com.example.labs.giis_1

import java.awt.Color
import java.awt.Graphics
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JPanel

class MyPanel : JPanel(), LineDrawerMode {

	private val lines = mutableListOf<Line>()

	init {
		val listener = MyMouseListener()
		addMouseListener(listener)
		addMouseMotionListener(listener)
	}

	private inner class MyMouseListener : MouseAdapter() {

		private var mouse: Point? = null
		private var line: Line? = null

		override fun mouseClicked(e: MouseEvent) {
			if(mouse == null) {
				val mouse = Point(e.x, e.y)
				this.mouse = mouse
				val line = Line(Point(e.x, e.y), mouse, drawer)
				this.line = line
				lines.add(line)
			} else {
				repaint()
				mouse = null
				line = null
			}
		}

		override fun mouseMoved(e: MouseEvent) {
			val mouse = mouse
			if(mouse != null) {
				mouse.x = e.x
				mouse.y = e.y
				repaint()
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

	data class Point(var x: Int, var y: Int)
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
