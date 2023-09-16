package com.example.labs.giis_1

import java.awt.Button
import java.awt.Toolkit
import java.awt.Window
import javax.swing.JFrame

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
	val b4 = Button("debug")
	b4.addActionListener { lineDrawer.debug() }
	b4.setSize(100, 100)
	b4.setLocation(300, 0)
	f.add(b4)
	f.add(lineDrawer)
	b1.isFocusable = false
	b2.isFocusable = false
	b3.isFocusable = false
	b4.isFocusable = false
	f.addKeyListener(lineDrawer)
	centreWindow(f)
	f.extendedState = JFrame.MAXIMIZED_BOTH
	f.isUndecorated = true
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