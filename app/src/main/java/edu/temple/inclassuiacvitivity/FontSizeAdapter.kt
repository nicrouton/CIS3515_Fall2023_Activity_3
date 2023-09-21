package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

// Custom adapter class
class FontSizeAdapter (private val context: Context, private val fontSizes: Array<Int>): BaseAdapter() {
   // size of array
    override fun getCount() = fontSizes.size

    // gets the array element at that index
    override fun getItem(position: Int) = fontSizes[position]

    //
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getDropDownView(position, convertView, parent).apply {
            (this as TextView).textSize = 22f
        }
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // convertView stores references to view we will recycle
        val textView: TextView

        // *late instantiation of a val
        if (convertView != null) {
            textView = convertView as TextView
        } else {
            textView = TextView(context)
            textView.setPadding(5, 10, 0, 10)
        }

        // each text view in spinner will be the font size you will trying to change it to
        textView.text = fontSizes[position].toString()
        textView.textSize = fontSizes[position].toFloat()
        textView.setPadding(5, 10, 0, 10)

        return textView
    }
}