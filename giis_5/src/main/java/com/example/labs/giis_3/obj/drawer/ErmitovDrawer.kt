package com.example.labs.giis_3.obj.drawer

import com.example.labs.giis_3.obj.Point
import com.example.labs.giis_3.pixel.PixelDrawer
import com.example.labs.giis_3.range
import org.apache.commons.math.linear.MatrixUtils

private val MATRIX = MatrixUtils.createRealMatrix(
	arrayOf(
		doubleArrayOf(2.0, -2.0, 1.0, 1.0),
		doubleArrayOf(-3.0, 3.0, -2.0, -1.0),
		doubleArrayOf(0.0, 0.0, 1.0, 0.0),
		doubleArrayOf(1.0, 0.0, 0.0, 0.0),
	)
)

object ErmitovDrawer : FourPointDrawer {

	override fun draw(g: PixelDrawer, p1: Point, p2: Point, p3: Point, p4: Point) = g.run {
		var m = MatrixUtils.createRealMatrix(
			arrayOf(
				doubleArrayOf(p1.x.toDouble(), p1.y.toDouble()),
				doubleArrayOf(p2.x.toDouble(), p2.y.toDouble()),
				doubleArrayOf(p3.x.toDouble(), p3.y.toDouble()),
				doubleArrayOf(p4.x.toDouble(), p4.y.toDouble()),
			)
		)
		m = MATRIX.multiply(m)
		for(t in range(0.0, 1.0, 0.0001)) {
			var tMatrix = MatrixUtils.createRealMatrix(
				arrayOf(
					doubleArrayOf(t * t * t, t * t, t, 1.0),
				)
			)
			tMatrix = tMatrix.multiply(m)
			drawPixel(tMatrix.data[0][0].toInt(), tMatrix.data[0][1].toInt())
		}
	}
}