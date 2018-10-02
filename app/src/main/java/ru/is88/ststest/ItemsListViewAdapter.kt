package ru.is88.ststest

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ItemsListViewAdapter(context: Context,
                           private val items: ArrayList<Models.Inlinable>) : BaseAdapter() {


    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder") // потому что использую не свой layout, а из android.R
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)

        val textView = rootView.findViewById<TextView>(android.R.id.text1)

        textView.text = getItem(position).inline()

        return rootView
    }

    override fun getItem(position: Int): Models.Inlinable {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}