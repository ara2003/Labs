package com.example.labs.giis_1

import java.awt.Button
import java.awt.Toolkit
import java.awt.Window
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JFrame
import kotlin.system.exitProcess

private const val WIDTH = 800
private const val HEIGHT = 600

fun main() {
	val f = JFrame("giis 1")
	val lineDrawer = MyPanel()
	val b1 = Button("ЦДА")
	b1.addActionListener { lineDrawer.drawer = CDALineDrawer }
	b1.setSize(100, 100)
	f.add(b1)
	val b2 = Button("Брезенхем")
	b2.addActionListener { lineDrawer.drawer = BresenhamLineDrawer }
	b2.setSize(100, 100)
	b2.setLocation(100, 0)
	f.add(b2)
	val b3 = Button("Antialiasing")
	b3.addActionListener { lineDrawer.drawer = AntialiasingLineDrawer }
	b3.setSize(100, 100)
	b3.setLocation(200, 0)
	f.add(b3)
	f.add(lineDrawer)
	f.setSize(WIDTH, HEIGHT)
	b1.isFocusable = false
	b2.isFocusable = false
	b3.isFocusable = false
	f.addKeyListener(object : KeyAdapter() {
		override fun keyPressed(e: KeyEvent) {
			if(e.keyCode == KeyEvent.VK_ESCAPE)
				exitProcess(0)
		}
	})
	centreWindow(f)
	f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
	f.isResizable = false
	f.isVisible = true
}

fun centreWindow(frame: Window) {
	val dimension = Toolkit.getDefaultToolkit().screenSize
	val x = ((dimension.getWidth() - frame.width) / 2).toInt()
	val y = ((dimension.getHeight() - frame.height) / 2).toInt()
	frame.setLocation(x, y)
}