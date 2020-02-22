package com.example.piechart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pie_chart_next.*

class PieChartNext : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart_next)

        val datapoints = floatArrayOf(450f,400f,300f,100f)
        pie_chart.setDataPoints(datapoints)
    }
}
