package com.example.labs.giis_2

import com.example.labs.giis_2.generator.LineGenerator
import com.example.labs.giis_2.generator.ObjectGenerator
import com.example.labs.giis_2.obj.DebugDrawObject
import com.example.labs.giis_2.obj.DrawObject
import com.example.labs.giis_2.obj.draw
import com.example.labs.giis_2.obj.drawer.CDALineDrawer
import com.example.labs.giis_2.pixel.PIXEL_SIZE
import com.example.labs.giis_2.pixel.setColor
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

		override fun mouseClicked(e: MouseEvent) {
			generator.click(this@MyPanel, e.x / PIXEL_SIZE, e.y / PIXEL_SIZE)
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
		for(line in objects)
			line.draw(g)
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

	override var generator: ObjectGenerator = LineGenerator(CDALineDrawer)

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
}