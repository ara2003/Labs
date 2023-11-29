package com.example.labs.giis_6

import com.example.labs.giis_6.generator.MouseMove
import com.example.labs.giis_6.generator.ObjectGenerator
import com.example.labs.giis_6.obj.DebugDrawObject
import com.example.labs.giis_6.obj.DrawObject
import com.example.labs.giis_6.obj.cross
import com.example.labs.giis_6.obj.draw
import com.example.labs.giis_6.pixel.GraphicsPixelDrawer
import com.example.labs.giis_6.pixel.PIXEL_SIZE
import com.example.labs.giis_6.pixel.setColor
import java.awt.Color
import java.awt.Graphics
import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.stream.IntStream.*
import javax.swing.JPanel
import kotlin.system.exitProcess

class MyPanel : JPanel(), LineDrawerMode, KeyListener, ObjectGenerator.Context {

	private val objects = mutableListOf<DrawObject>()
	override var isDebug = false
		private set

	init {
		val listener = MyMouseListener()
		addMouseListener(listener)
		addMouseMotionListener(listener)
	}

	private inner class MyMouseListener : MouseAdapter() {

		override fun mousePressed(e: MouseEvent) {
			generator.press(this@MyPanel, e.x / PIXEL_SIZE, e.y / PIXEL_SIZE)
		}

		override fun mouseReleased(e: MouseEvent) {
			generator.release(this@MyPanel, e.x / PIXEL_SIZE, e.y / PIXEL_SIZE)
		}

		override fun mouseClicked(e: MouseEvent) {
			if(e.button == 1)
				generator.click(this@MyPanel, e.x / PIXEL_SIZE, e.y / PIXEL_SIZE)
			if(e.button == 3)
				generator.end(this@MyPanel)
		}

		override fun mouseDragged(e: MouseEvent) {
			generator.move(this@MyPanel, e.x / PIXEL_SIZE, e.y / PIXEL_SIZE)
		}

		override fun mouseMoved(e: MouseEvent) {
			generator.move(this@MyPanel, e.x / PIXEL_SIZE, e.y / PIXEL_SIZE)
		}
	}

	override fun paint(g: Graphics) {
		super.paint(g)
		if(isDebug) {
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
		for(obj in objects)
			obj.draw(g)
		g.setColor(Color.red) {
			val g = GraphicsPixelDrawer(g)
			for(obj in objects)
				for(point in obj)
					g.drawPixel(point.x, point.y)
//		for(a in objects)
//			for(l in a.lines)
//				CDALineDrawer.drawTwoPointObject(g, l.p1.x, l.p1.y, l.p2.x, l.p2.y)
			for(a in objects)
				for(b in objects)
					if(a !== b)
						for(a in a.lines)
							for(b in b.lines) {
								val point = cross(a, b)
								if(point != null)
									g.drawPixel(point.x, point.y)
							}
		}
	}

	override fun debug() {
		if(isDebug) {
			val toAdd = mutableListOf<DrawObject>()
			objects.removeIf {
				if(it is DebugDrawObject) {
					toAdd.add(it.origin)
					true
				} else
					false
			}
			objects.addAll(toAdd)
		}
		isDebug = !isDebug
		repaint()
	}

	private var _generator: ObjectGenerator = MouseMove
	override var generator: ObjectGenerator
		get() = _generator
		set(value) {
			val mouse = getMousePosition(false)
			_generator.end(this)
			_generator = value
			_generator.begin(this, mouse.x, mouse.y)
		}

	override fun keyTyped(e: KeyEvent?) {
	}

	override fun keyPressed(e: KeyEvent) {
		if(e.keyCode == KeyEvent.VK_ESCAPE)
			exitProcess(0)

		if(isDebug) {
			if(e.keyCode == KeyEvent.VK_RIGHT)
				addPoint()
			if(e.keyCode == KeyEvent.VK_LEFT)
				removePoint()
			repaint()
		}
	}

	private fun addPoint() {
		for(obj in objects)
			if(obj is DebugDrawObject)
				obj.addPoint()
	}

	private fun removePoint() {
		for(obj in objects)
			if(obj is DebugDrawObject)
				obj.removePoint()
	}

	override fun keyReleased(e: KeyEvent?) {
	}

	override fun add(obj: DrawObject) {
		objects.add(obj)
	}

	override fun remove(obj: DrawObject) {
		objects.remove(obj)
	}

	override fun iterator() = objects.iterator()
}