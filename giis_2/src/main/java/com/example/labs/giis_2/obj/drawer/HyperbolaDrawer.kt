package com.example.labs.giis_2.obj.drawer

import com.example.labs.giis_2.pixel.PixelDrawer

object HyperbolaDrawer : TwoPointDrawer {

	override fun drawLine(g: PixelDrawer, x1: Int, y1: Int, x2: Int, y2: Int) = g.run {
		val a = StrictMath.abs(x2 - x1)
		val b = StrictMath.abs(y2 - y1)
		drawHyperbola(x1, y2, a, b)
	}
}

private fun PixelDrawer.pixel4(
	x: Int,
	y: Int,
	a: Int,
	b: Int,
	_x: Int,
	_y: Int,
) {
	drawPixel(x - _x + a + 10, y + _y)
	drawPixel(x - _x + a + 10, y - _y)
	drawPixel(x + _x - a - 10, y - _y)
	drawPixel(x + _x - a - 10, y + _y)
}

private fun PixelDrawer.drawHyperbola(x: Int, y: Int, a: Int, b: Int) {
	var _x = 0 // Компонента x
	var _y = b // Компонента y
	val a_sqr = a * a // a^2, a - большая полуось
	val b_sqr = b * b // b^2, b - малая полуось
	var delta =
		4 * b_sqr * ((_x + 1) * (_x + 1)) + a_sqr * ((2 * _y - 1) * (2 * _y - 1)) - 4 * a_sqr * b_sqr // Функция координат точки (x+1, y-1/2)

	while(a_sqr * (2 * _y - 1) > 2 * b_sqr * (_x + 1)) // Первая часть дуги
	{
		pixel4(x, y, a, b, _x, _y)
		if(delta < 0) // Переход по горизонтали
		{
			_x++
			delta += 4 * b_sqr * (2 * _x + 3)
		} else  // Переход по диагонали
		{
			_x++
			delta = delta - 8 * a_sqr * (_y - 1) + 4 * b_sqr * (2 * _x + 3)
			_y--
		}
	}
	delta =
		b_sqr * ((2 * _x + 1) * (2 * _x + 1)) + 4 * a_sqr * ((_y + 1) * (_y + 1)) - 4 * a_sqr * b_sqr // Функция координат точки (x+1/2, y-1)
	while(_y + 1 != 0) // Вторая часть дуги, если не выполняется условие первого цикла, значит выполняется a^2(2y - 1) <= 2b^2(x + 1)
	{
		pixel4(x, y, a, b, _x, _y)
		if(delta < 0) // Переход по вертикали
		{
			_y--
			delta += 4 * a_sqr * (2 * _y + 3)
		} else  // Переход по диагонали
		{
			_y--
			delta = delta - 8 * b_sqr * (_x + 1) + 4 * a_sqr * (2 * _y + 3)
			_x++
		}
	}
}