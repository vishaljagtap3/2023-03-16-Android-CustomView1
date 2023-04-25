package com.bitcodetech.customviews1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.widget.TextView

class TaskView(
    context: Context,
    attributeSet: AttributeSet?
) : androidx.appcompat.widget.AppCompatTextView(context, attributeSet) {

    companion object {
        val STATE_PENDING = 0
        val STATE_IN_PROGRESS = 1
        val STATE_NEAR_COMPLETION = 2
        val STATE_COMPLETED = 3
    }

    var currentState = 0
        set(value) {
            field = value
            updateState()
        }
    val paint = Paint()

    constructor(context: Context) : this(context, null)

    init {
        setupListeners()
        setPadding(80, 0, 0, 0)
        initPaint()
    }

    private fun initPaint() {
        paint.setColor(Color.RED)
        paint.strokeWidth = 5f
    }

    private fun setupListeners() {
        this.setOnClickListener {
            currentState = (currentState + 1) % 4
            updateState()
        }
    }

    private fun updateState() {
        setBackgroundColor(
            when (currentState) {
                STATE_PENDING -> Color.WHITE
                STATE_IN_PROGRESS -> Color.GRAY
                STATE_NEAR_COMPLETION -> Color.BLUE
                STATE_COMPLETED -> Color.GREEN
                else -> Color.WHITE
            }
        )
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.e("tag", "onDraw: TaskView")

        canvas!!.drawLine(50F, 0F, 50F, height.toFloat(), paint)
        canvas!!.drawLine(60F, 0F, 60F, height.toFloat(), paint)
    }

}








