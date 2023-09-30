package com.example.labs.giis_2

import com.example.labs.giis_2.obj.drawer.AntialiasingLineDrawer
import com.example.labs.giis_2.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_2.obj.drawer.CDALineDrawer
import com.example.labs.giis_2.obj.drawer.CircleDrawer
import com.example.labs.giis_2.obj.drawer.EllipseDrawer
import com.example.labs.giis_2.obj.drawer.HyperbolaDrawer
import com.example.labs.giis_2.obj.drawer.ParabolaDrawer
import java.awt.Button
import java.awt.Menu
import java.awt.MenuBar
import java.awt.MenuItem
import java.awt.Toolkit
import java.awt.Window
import javax.swing.JFrame

private infix fun Any.new(obj: Any) = obj

fun main() {
	val f = JFrame("giis 1")
	val panel = MyPanel()
	val menuBar = MenuBar()
	val m = Menu("объект")
	m.add(MenuItem("ЦДА").also { it.addActionListener { panel.drawer = CDALineDrawer } })
	m.add(MenuItem("Брезенхем").also { it.addActionListener { panel.drawer = BresenhamLineDrawer } })
	m.add(MenuItem("Ву").also { it.addActionListener { panel.drawer = AntialiasingLineDrawer } })
	m.addSeparator()
	m.add(MenuItem("Окружность").also { it.addActionListener { panel.drawer = CircleDrawer } })
	m.add(MenuItem("Эллипс").also { it.addActionListener { panel.drawer = EllipseDrawer } })
	m.add(MenuItem("Гипербола").also { it.addActionListener { panel.drawer = HyperbolaDrawer } })
	m.add(MenuItem("Парабола").also { it.addActionListener { panel.drawer = ParabolaDrawer } })
	menuBar.add(m)
	f.menuBar = menuBar
//	val b1 = Button("ЦДА")
//	b1.addActionListener { panel.drawer = CDALineDrawer }
//	b1.setSize(100, 100)
//	f.add(b1)
//	val b2 = Button("Брезенхем")
//	b2.addActionListener { panel.drawer = BresenhamLineDrawer }
//	b2.setSize(100, 100)
//	b2.setLocation(100, 0)
//	f.add(b2)
//	val b3 = Button("Ву")
//	b3.addActionListener { panel.drawer = AntialiasingLineDrawer }
//	b3.setSize(100, 100)
//	b3.setLocation(200, 0)
//	f.add(b3)
//	val b4 = Button("Окружность")
//	b4.addActionListener { panel.generator = CircleGenerator }
//	b4.setSize(100, 100)
//	b4.setLocation(300, 0)
//	f.add(b4)
	val debugButton = Button("debug")
	debugButton.addActionListener { panel.debug() }
	debugButton.setSize(100, 100)
	debugButton.setLocation(1920 - 100, 0)
	f.add(debugButton)
//	b1.isFocusable = false
//	b2.isFocusable = false
//	b4.isFocusable = false
	debugButton.isFocusable = false
	f.add(panel)
	f.addKeyListener(panel)
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