package com.adityaladwa.circle

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

private val TAG = Circle::class.java.simpleName

class Circle @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int? = null
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private var cX: Float = 0f
    private var cY: Float = 0f
    private var radius: Float = 0f

    init {
        paint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.run {
            cX = width / 2f
            cY = height / 2f
            radius = width / 2f
            canvas.drawCircle(cX, cY, radius, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.run {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {

                }
                MotionEvent.ACTION_MOVE -> {
                    if (isPointInCircle(x, y)) {
                        cX = x
                        cY = y
                        invalidate()
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (isPointInCircle(x, y)) {
                        paint.color = getNewColor()
                        invalidate()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    private fun getNewColor(): Int {
        return Color.rgb(Random.nextInt(0, 250), Random.nextInt(0, 250), Random.nextInt(0, 250))
    }

    private fun isPointInCircle(x: Float, y: Float): Boolean {
        val dx = x - cX
        val dy = y - cY
        if ((dx * dx) + (dy * dy) <= (radius * radius)) {
            return true
        }
        return false
    }
}