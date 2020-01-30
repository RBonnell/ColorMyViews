package com.rightwinds.colormyviews

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun makeColored(view: View) {

        when (view.id) { // randomly colors TextView background
            R.id.box_one_text -> view.setBackgroundColor(randomColor())
            R.id.box_two_text -> view.setBackgroundColor(randomColor())
            R.id.box_three_text -> view.setBackgroundColor(randomColor())
            R.id.box_four_text -> view.setBackgroundColor(randomColor())
            R.id.box_five_text -> view.setBackgroundColor(randomColor())
            R.id.red_button -> box_three_text.setBackgroundColor(getResources().getColor(R.color.my_red))
            R.id.yellow_button -> box_four_text.setBackgroundColor(getResources().getColor(R.color.my_yellow))
            R.id.green_button -> box_five_text.setBackgroundColor(getResources().getColor(R.color.my_green))
            else -> view.setBackgroundColor(randomColor())
        }

        when (view.id) { // randomly colors TextView text
            R.id.box_one_text -> view.box_one_text.setTextColor(randomColor())
            R.id.box_two_text -> view.box_two_text.setTextColor(randomColor())
            R.id.box_three_text -> view.box_three_text.setTextColor(randomColor())
            R.id.box_four_text -> view.box_four_text.setTextColor(randomColor())
            R.id.box_five_text -> view.box_five_text.setTextColor(randomColor())
            else -> view.setBackgroundColor(randomColor())
        }


    }

    private fun makeTransparent(view: View) {

        when (view.id) {

            R.id.box_one_text -> view.setBackgroundColor(Color.TRANSPARENT)
            R.id.box_two_text -> view.setBackgroundColor(Color.TRANSPARENT)
            R.id.box_three_text -> view.setBackgroundColor(Color.TRANSPARENT)
            R.id.box_four_text -> view.setBackgroundColor(Color.TRANSPARENT)
            R.id.box_five_text -> view.setBackgroundColor(Color.TRANSPARENT)
            else -> view.setBackgroundColor(Color.TRANSPARENT)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<TextView>(R.id.red_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val yellowButton = findViewById<TextView>(R.id.yellow_button)

        val clickableViews: ArrayList<View> =
            arrayListOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton)
        for (view in clickableViews) {
            view.setOnClickListener { makeColored(it) }
        }
        for (view in clickableViews) {
            view.setOnLongClickListener {
               makeTransparent(it)
                true
            }
        }

    }

    private fun randomColor() : Int {
        val availableColors: ArrayList<Int> =
            arrayListOf(Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GRAY, Color.GREEN,
                Color.LTGRAY, Color.MAGENTA, Color.RED, Color.YELLOW)
        return availableColors.shuffled().take(1)[0]
    }
}
