package com.mikaela.kindergarten_workshop.utils

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class RotatedTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        canvas.rotate(90f, (width / 2).toFloat(), (height / 2).toFloat())
//        canvas.translate((width / 2 - height / 2).toFloat(), (height / 2 - width / 2).toFloat())

        super.onDraw(canvas)

        canvas.restore()
    }
}