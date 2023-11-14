package com.example.labs.giis_5

import com.example.labs.giis_5.generator.BasePolygonGenerator
import com.example.labs.giis_5.generator.LineGenerator
import com.example.labs.giis_5.generator.MouseMove
import com.example.labs.giis_5.generator.PointInsidePolygon
import com.example.labs.giis_5.generator.PolygonGenerator
import com.example.labs.giis_5.obj.drawer.AntialiasingLineDrawer
import com.example.labs.giis_5.obj.drawer.BSplinesDrawer
import com.example.labs.giis_5.obj.drawer.BezieDrawer
import com.example.labs.giis_5.obj.drawer.BresenhamLineDrawer
import com.example.labs.giis_5.obj.drawer.CDALineDrawer
import com.example.labs.giis_5.obj.drawer.CircleDrawer
import com.example.labs.giis_5.obj.drawer.EllipseDrawer
import com.example.labs.giis_5.obj.drawer.ErmitovDrawer
import com.example.labs.giis_5.obj.drawer.HyperbolaDrawer
import com.example.labs.giis_5.obj.drawer.ParabolaDrawer
import com.example.labs.giis_5.obj.drawer.SplitFour
import com.example.labs.giis_5.obj.solver.GrahamMinimalConvexHullSolver
import com.example.labs.giis_5.obj.solver.JarvisMinimalConvexHullSolver
import java.awt.Button
import java.awt.Menu
import java.awt.MenuBar
import java.awt.MenuItem
import java.awt.Toolkit
import java.awt.Window
import javax.swing.JFrame

private infix fun Any.new(obj: Any) = obj

fun main() {
	val f = JFrame("giis 5")
	val panel = MyPanel()
	val menuBar = MenuBar()
	val m = Menu("объект")
	m.add(MenuItem("Перемещение точек").also { it.addActionListener { panel.generator = MouseMove } })
	m.addSeparator()
	m.add(MenuItem("ЦДА").also { it.addActionListener { panel.generator = LineGenerator(CDALineDrawer) } })
	m.add(MenuItem("Брезенхем").also { it.addActionListener { panel.generator = LineGenerator(BresenhamLineDrawer) } })
	m.add(MenuItem("Ву").also { it.addActionListener { panel.generator = LineGenerator(AntialiasingLineDrawer) } })
	m.addSeparator()
	m.add(MenuItem("Окружность").also { it.addActionListener { panel.setDrawer(CircleDrawer) } })
	m.add(MenuItem("Эллипс").also { it.addActionListener { panel.setDrawer(EllipseDrawer) } })
	m.add(MenuItem("Гипербола").also { it.addActionListener { panel.setDrawer(HyperbolaDrawer) } })
	m.add(MenuItem("Парабола").also { it.addActionListener { panel.setDrawer(ParabolaDrawer) } })
	m.addSeparator()
	m.add(MenuItem("Эрмитов").also { it.addActionListener { panel.setDrawer(ErmitovDrawer) } })
	m.add(MenuItem("Безье").also { it.addActionListener { panel.setDrawer(BezieDrawer) } })
	m.add(MenuItem("B-сплайн").also { it.addActionListener { panel.setDrawer(SplitFour(BSplinesDrawer)) } })
	m.addSeparator()
	m.add(MenuItem("Полигон").also { it.addActionListener { panel.generator = BasePolygonGenerator } })
	m.add(MenuItem("Грехем").also { it.addActionListener { panel.setDrawer(GrahamMinimalConvexHullSolver) } })
	m.add(MenuItem("Джарвис").also { it.addActionListener { panel.setDrawer(JarvisMinimalConvexHullSolver) } })
	m.add(MenuItem("принадлежность точки").also { it.addActionListener { panel.generator = PointInsidePolygon } })
	menuBar.add(m)
	f.menuBar = menuBar
	val debugButton = Button("debug")
	debugButton.addActionListener { panel.debug() }
	debugButton.setSize(100, 100)
	debugButton.setLocation(1920 - 100, 0)
	f.add(debugButton)
	debugButton.isFocusable = false
	f.add(panel)
	f.addKeyListener(panel)
	centreWindow(f)
	f.extendedState = JFrame.MAXIMIZED_BOTH
	f.isUndecorated = true
//	f.setSize(800, 600)
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