package com.omgodse.notally.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.omgodse.notally.R

class DashedDividerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = ContextCompat.getColor(context, R.color.eink_divider)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val density = resources.displayMetrics.density
        paint.strokeWidth = density
        paint.pathEffect = DashPathEffect(floatArrayOf(2 * density, 2 * density), 0f)
        val y = height / 2f
        canvas.drawLine(0f, y, width.toFloat(), y, paint)
    }
}
