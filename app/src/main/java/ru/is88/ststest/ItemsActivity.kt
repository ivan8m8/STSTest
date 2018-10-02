package ru.is88.ststest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_items.*
import java.util.*
import kotlin.collections.ArrayList

class ItemsActivity : AppCompatActivity() {

    val ITEM_KEY: String = "item_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val list = ArrayList<Models.Inlinable>()

        populateList(list)

        val mListViewAdapter = ItemsListViewAdapter(this, list)
        itemsListView.adapter = mListViewAdapter
        itemsListView.setOnItemClickListener { _, _, position, _ ->
            intent = Intent(this@ItemsActivity, ItemInfoActivity::class.java)
            intent.putExtra(ITEM_KEY, list[position])
            startActivity(intent)
        }

    }

    private fun populateList(list: ArrayList<Models.Inlinable>) {

        val list1 = ArrayList<Models.Notice>()
        val list2 = ArrayList<Models.Event>()
        val list3 = ArrayList<Models.Move>()

        val random1 = (3..33)
        val random2 = (3..33)
        val random3 = (3..33)

        for (i in random1) {
            list1.add(Models.Notice(Date(i.toLong()), i.toString()))
        }
        for (i in random2) {
            list2.add(Models.Event(Date(i.toLong()), Date((i.toLong() + i.toLong())), i.toString()))
        }
        for (i in random3) {
            list3.add(Models.Move(i.toString(), i.toString() + i.toString(), TimeInterval(i.toLong())))
        }

        list.addAll(list1)
        list.addAll(list2)
        list.addAll(list3)
    }
}
