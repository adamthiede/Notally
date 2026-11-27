package com.omgodse.notally.recyclerview

import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class DashedDividerItemDecoration(color: Int) : RecyclerView.ItemDecoration() {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        this.color = color
    }

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val density = parent.resources.displayMetrics.density
        paint.strokeWidth = density
        paint.pathEffect = DashPathEffect(floatArrayOf(2 * density, 2 * density), 0f)

        for (index in 0 until parent.childCount) {
            val child = parent.getChildAt(index)
            val y = child.bottom.toFloat()
            canvas.drawLine(child.left.toFloat(), y, child.right.toFloat(), y, paint)
        }
    }
}
