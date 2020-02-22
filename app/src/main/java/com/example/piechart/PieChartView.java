package com.example.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PieChartView extends View {

    private Paint slicePaint;
    private int[] sliceClrs = { Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW };
    private RectF rectf; // Our box
    private float[] datapoints; // Our values

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        slicePaint = new Paint();
        slicePaint.setAntiAlias(true);
        slicePaint.setDither(true);
        slicePaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.datapoints != null) {
            int startTop = 0;
            int startLeft = 0;
            int endBottom = getWidth();
            int endRight = endBottom; // To make this an equal square
            // Create the box
            rectf = new RectF(startLeft, startTop, endRight, endBottom); // Creating the box

            float[] scaledValues = scale(); // Get the scaled values
            float sliceStartPoint = 0;
            for (int i = 0; i < scaledValues.length; i++) {
                slicePaint.setColor(sliceClrs[i]);
                canvas.drawArc(rectf, sliceStartPoint, scaledValues[i], true, slicePaint); // Draw slice
                sliceStartPoint += scaledValues[i]; // Update starting point of the next slice
            }
        }
    }

    public void setDataPoints(float[] datapoints) {
        this.datapoints = datapoints;
        invalidate(); // Tells the chart to redraw itself
    }

    private float[] scale() {
        float[] scaledValues = new float[this.datapoints.length];
        float total = getTotal(); // Total all values supplied to the chart
        for (int i = 0; i < this.datapoints.length; i++) {
            scaledValues[i] = (this.datapoints[i] / total) * 360; // Scale each value
        }
        return scaledValues;
    }

    private float getTotal() {
        float total = 0;
        for (float val : this.datapoints)
            total += val;
        return total;
    }
}
