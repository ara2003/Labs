package com.example.labs.giis_6.generator

import com.example.labs.giis_6.obj.DebugDrawObject
import com.example.labs.giis_6.obj.DrawObject
import com.example.labs.giis_6.obj.FillPolygon
import com.example.labs.giis_6.obj.Point
import com.example.labs.giis_6.obj.PolygonDrawObject
import com.example.labs.giis_6.obj.filler.FillDrawer
import com.example.labs.giis_6.obj.inside

data class FillPolygonGenerator(val filler: FillDrawer) : ObjectGenerator {

	private var obj: DrawObject? = null

	private fun getPolygon(mouse: Point, ctx: ObjectGenerator.Context): PolygonDrawObject? {
		val polygons = ctx.filterIsInstance<PolygonDrawObject>()
		for(p in polygons) {
			if(mouse inside p)
				return p
		}
		return null
	}

	override fun begin(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		move(ctx, x, y)
	}

	override fun end(ctx: ObjectGenerator.Context) {
		obj = null
	}

	override fun click(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		move(ctx, x, y)
		val obj = obj
		if(obj != null) {
			if(ctx.isDebug) {
				ctx.remove(obj)
				val debug = DebugDrawObject(obj)
				ctx.add(debug)
				ctx.repaint()
			}
			this.obj = null
		}
	}

	override fun move(ctx: ObjectGenerator.Context, x: Int, y: Int) {
		val polygon = getPolygon(Point(x, y), ctx)
		var obj = obj
		if(obj != null)
			ctx.remove(obj)
		if(polygon != null) {
			obj = FillPolygon(polygon, filler)
			ctx.add(obj)
			this.obj = obj
		}
		ctx.repaint()
	}
}