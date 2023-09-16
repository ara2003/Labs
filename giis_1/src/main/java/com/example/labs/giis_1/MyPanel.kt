package com.example.labs.giis_1

import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.stream.IntStream.*
import javax.swing.JPanel
import kotlin.system.exitProcess

class MyPanel : JPanel(), LineDrawerMode, KeyListener {

	private val lines = mutableListOf<Line>()
	private var debug = false

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
				if(debug) {
					var line = line!!
					line.drawer = DebugLineDrawer(line.drawer)
				}
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
		if(debug) {
			g.setColor(Color(0, 0, 0, (255 * .1f).toInt())) {
				val w = width / PIXEL_SIZE
				for(x in range(0, w))
					g.drawLine(x * PIXEL_SIZE, 0, x * PIXEL_SIZE, height)
				val h = height / PIXEL_SIZE
				for(y in range(0, h))
					g.drawLine(0, y * PIXEL_SIZE, width, y * PIXEL_SIZE)
			}
		}
		g.color = Color.black
		for(line in lines)
			line.print(g)
	}

	override fun debug() {
		if(debug) {
			for(line in lines) {
				val drawer = line.drawer
				if(drawer is DebugLineDrawer)
					line.drawer = drawer.origin
			}
		}
		debug = !debug
		repaint()
	}

	override var drawer: LineDrawer = CDALineDrawer

	override fun keyTyped(e: KeyEvent?) {
	}

	override fun keyPressed(e: KeyEvent) {
		if(e.keyCode == KeyEvent.VK_ESCAPE)
			exitProcess(0)

		if(debug) {
			if(e.keyCode == KeyEvent.VK_RIGHT)
				addPoint()
			if(e.keyCode == KeyEvent.VK_LEFT)
				removePoint()
			repaint()
		}
	}

	private fun addPoint() {
		for(line in lines) {
			val drawer = line.drawer
			if(drawer is DebugLineDrawer)
				drawer.addPoint()
		}
	}

	private fun removePoint() {
		for(line in lines) {
			val drawer = line.drawer
			if(drawer is DebugLineDrawer)
				drawer.removePoint()
		}
	}

	override fun keyReleased(e: KeyEvent?) {
	}
}

private data class Point(var x: Int, var y: Int)
private data class Line(val p1: Point, val p2: Point, var drawer: LineDrawer) {
	constructor(
		x1: Int,
		y1: Int,
		x2: Int,
		y2: Int,
		drawer: LineDrawer,
	) : this(Point(x1, y1), Point(x2, y2), drawer)
}

private fun Line.print(g: Graphics) {
	val pixels = BasePixelDrawer(g)
	drawer.drawLine(pixels, p1.x / PIXEL_SIZE, p1.y / PIXEL_SIZE, p2.x / PIXEL_SIZE, p2.y / PIXEL_SIZE)
}
