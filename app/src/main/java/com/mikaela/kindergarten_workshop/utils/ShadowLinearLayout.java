package com.mikaela.kindergarten_workshop.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.mikaela.kindergarten_workshop.R;

public class ShadowLinearLayout extends LinearLayout {

    private Paint shadowPaint;
    private RectF shadowRect;
    private int shadowColor = Color.BLACK;
    private float shadowRadius = 10.0f;
    private float shadowDx = 5.0f;
    private float shadowDy = 5.0f;

    public ShadowLinearLayout(Context context) {
        super(context);
        init(context, null);
    }

    public ShadowLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShadowLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShadowLinearLayout);
            shadowColor = a.getColor(R.styleable.ShadowLinearLayout_shadowColor, shadowColor);
            shadowRadius = a.getDimension(R.styleable.ShadowLinearLayout_shadowRadius, shadowRadius);
            shadowDx = a.getDimension(R.styleable.ShadowLinearLayout_shadowDx, shadowDx);
            shadowDy = a.getDimension(R.styleable.ShadowLinearLayout_shadowDy, shadowDy);
            a.recycle();
        }

        shadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        shadowPaint.setColor(Color.TRANSPARENT);
        shadowPaint.setShadowLayer(shadowRadius, shadowDx, shadowDy, shadowColor);
        setLayerType(LAYER_TYPE_SOFTWARE, shadowPaint);
    }

    @Override
    protected void dispatchDraw(@NonNull Canvas canvas) {
        if (shadowRect == null) {
            shadowRect = new RectF(
                    shadowRadius + Math.abs(shadowDx),
                    shadowRadius + Math.abs(shadowDy),
                    getWidth() - shadowRadius - Math.abs(shadowDx),
                    getHeight() - shadowRadius - Math.abs(shadowDy)
            );
        }

        canvas.drawRoundRect(shadowRect, 0, 0, shadowPaint);  // Радиус углов 0 (прямоугольник)


        super.dispatchDraw(canvas);
    }
}
