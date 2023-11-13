package com.example.labs.giis_3.generator

import com.example.labs.giis_3.obj.DrawObject
import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.obj.PolygonDrawObject
import com.example.labs.giis_3.obj.inside
import com.example.labs.giis_3.pixel.PixelDrawer
import com.example.labs.giis_3.pixel.drawPixel
import java.awt.Color
import java.awt.Color.*

object PointInsidePolygon : ObjectGenerator {

	private lateinit var obj: ColorPoint
	private val mouse
		get() = obj.point

	override fun begin(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		obj = ColorPoint(Point(x, y), RED)
		ctx.add(obj)
		ctx.repaint()
		println("begin")
	}

	override fun end(ctx: ObjectGenerator.Context) {
		ctx.remove(obj)
		ctx.repaint()
	}

	override fun move(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		mouse.x = x
		mouse.y = y
		obj.color =
			if(ctx.any { it is PolygonDrawObject && mouse inside it })
				GREEN
			else
				RED
		ctx.repaint()
	}

}

private class ColorPoint(val point: Point, var color: Color) : DrawObject {

	override fun draw(drawer: PixelDrawer) {
		drawer.drawPixel(point, color)
	}

	override fun iterator() = listOf<Point>().iterator()
}
