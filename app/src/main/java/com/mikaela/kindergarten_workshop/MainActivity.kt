package com.mikaela.kindergarten_workshop

import android.content.res.ColorStateList
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.TextView
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slider: Slider = findViewById(R.id.slider)

        slider.addOnChangeListener { _, _, _ ->
            val shadowLayerPaint = Paint().apply {
                color = resources.getColor(R.color.pink_glow_transparent, null)
                style = Paint.Style.STROKE
                strokeWidth = 0.02f
                setShadowLayer(0.2f, 4f, 4f, resources.getColor(R.color.pink_glow_transparent, null))
            }
        }

        slider.trackActiveTintList = ColorStateList.valueOf(resources.getColor(R.color.pink_transparent, null))
        slider.trackInactiveTintList = ColorStateList.valueOf(resources.getColor(R.color.white, null))
    }
}