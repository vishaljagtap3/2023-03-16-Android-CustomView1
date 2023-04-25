package com.bitcodetech.customviews1

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.Button

@SuppressLint("AppCompatCustomView")
class ExitButton(context : Context, attributeSet: AttributeSet?) : Button(context, attributeSet) {

    var exitable = true
    set(value) {
        field = value
    }

    init {
        setOnClickListener {
            if(exitable) {
                System.exit(0)
            }
            else {
                //you take action
            }
        }
    }

    constructor(context: Context) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawCircle(
            width.toFloat() / 2F,
            height.toFloat()/2F,
            25F,
            Paint()
        )
    }


}

