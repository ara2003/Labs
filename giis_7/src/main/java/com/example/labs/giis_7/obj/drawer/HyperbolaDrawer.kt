package com.example.labs.giis_7.obj.drawer

import com.example.labs.giis_7.pixel.PixelDrawer
import java.lang.StrictMath.*

object HyperbolaDrawer : TwoPointDrawer {

	override fun draw(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		val a = abs(x2 - x1)
		val b = abs(y2 - y1)
		drawHyperbola(x2, y2, a, b)
	}
}

private fun PixelDrawer.drawPixel(
	xc: Int,
	yc: Int,
	x: Int,
	y: Int,
) {
	drawPixel(xc - x, yc - y)
	drawPixel(xc - x, yc + y)
	drawPixel(xc + x, yc - y)
	drawPixel(xc + x, yc + y)
}

private fun PixelDrawer.drawHyperbola(xc: Int, yc: Int, rx: Int, ry: Int, bound: Int = 1000) {
	var x: Int
	var y: Int
	var d: Int
	var mida: Int
	var midb: Int
	var tworx2: Int
	var twory2: Int
	var rx2: Int
	var ry2: Int
	var x_slop: Int
	var y_slop: Int
	x = rx; y = 0
	rx2 = rx * rx; ry2 = ry * ry
	tworx2 = 2 * rx2; twory2 = 2 * ry2
	x_slop = 2 * twory2 * (x + 1)
	y_slop = 2 * tworx2
	mida = x_slop / 2; midb = y_slop / 2
	d = tworx2 - ry2 * (1 + 2 * rx) + midb
	while((d < x_slop) && (y <= bound)) {
		println("$x $y")
		drawPixel(xc, yc, x, y)
		if(d >= 0) {
			d -= x_slop
			x++
			x_slop += 2 * tworx2
		}
		d += tworx2 + y_slop
		y++
		y_slop += 2 * tworx2
	}
	d -= (x_slop + y_slop) / 2 + (rx2 + ry2) - midb - mida
	if(rx === 0 || ry === 0)
		return
	if(rx > ry)
		while(y <= bound) {
			drawPixel(xc, yc, x, y)
			if(d <= 0) {
				d += y_slop
				y++
				y += 2 * tworx2
			}
			d -= twory2 - x_slop
			x++
			x_slop += 2 * twory2
		}
}