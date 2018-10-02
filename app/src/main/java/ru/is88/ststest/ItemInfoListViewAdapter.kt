package ru.is88.ststest

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.lang.reflect.Field

class ItemInfoListViewAdapter(context: Context,
                              private val item: Models.Inlinable) : BaseAdapter() {

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder") // потому что использую не свой layout, а из android.R
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rootView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)

        val textView1 = rootView.findViewById<TextView>(android.R.id.text1)
        val textView2 = rootView.findViewById<TextView>(android.R.id.text2)

        textView1.text = getItem(position)!!.name
        textView2.text = getItem(position)?.get(item).toString()

        return rootView
    }

    // actually a Field
    override fun getItem(position: Int): Field? {
        val field = item.javaClass.getDeclaredField(item.javaClass.declaredFields[position].name)
        field.isAccessible = true
        return field
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return item.javaClass.declaredFields.count()
    }
}