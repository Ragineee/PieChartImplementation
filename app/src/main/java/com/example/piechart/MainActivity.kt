package com.example.piechart


import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File


class MainActivity : AppCompatActivity() {

    var petNames = arrayOf(
        "Dogs", "Cats", "Fish", "Rabbits",
        "Roddents"
    )
    var percentage = intArrayOf(100, 25, 10, 5, 5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        set(pie_view)
        txtheader.setOnClickListener {
            startActivity(Intent(this@MainActivity,PieChartNext::class.java))
        }



    }

    private fun set(pieView: PieView) {
        val pieHelperArrayList = ArrayList<PieHelper>()
//        val color0: Int = Color.rgb(0, 128, 255)
//        val color1: Int = Color.rgb(252, 3, 71)
//        val color2: Int = Color.rgb(117, 91, 4)
//        val color3: Int = Color.rgb(3, 7, 173)
//        val color4: Int = Color.rgb(20, 156, 82)
        pieHelperArrayList.add(PieHelper(55f, Color.BLUE))
        pieHelperArrayList.add(PieHelper(25f, Color.RED))
        pieHelperArrayList.add(PieHelper(10f, Color.MAGENTA))
        pieHelperArrayList.add(PieHelper(5f, Color.BLACK))
        pieHelperArrayList.add(PieHelper(5f, Color.DKGRAY))
        lvOne.setBackgroundColor(Color.BLUE)
        txtOne.text = petNames[0]
        lvTwo.setBackgroundColor(Color.RED)
        txtTwo.text = petNames[1]
        lvThree.setBackgroundColor( Color.MAGENTA)
        txtThree.text = petNames[2]
        lvFour.setBackgroundColor(Color.BLACK)
        txtFour.text = petNames[3]
        lvFive.setBackgroundColor(Color.DKGRAY)
        txtFive.text = petNames[4]
        pieView.setDate(pieHelperArrayList)
        pieView.setOnPieClickListener { index ->
            if (index != PieView.NO_SELECTED_INDEX) {
                txtinfo.text = (percentage[index].toString() + "% owns "
                        + petNames[index] + ".")
            } else {
                txtinfo.text = "No selected pie"
            }
        }
    }
}
