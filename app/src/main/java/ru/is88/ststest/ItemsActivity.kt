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

        val random1 = (3..33).random()
        val random2 = (3..33).random()
        val random3 = (3..33).random()

        for (i in 0..random1) {
            val d1 = (70000000 .. 100000000).random()
            list1.add(Models.Notice(Date(d1.toLong()), i.toString()))
        }
        for (i in 0..random2) {
            val d1 = (80000000 .. 100000000).random()
            val k1 = (2 .. 3).random()
            val d2 = d1 * k1
            list2.add(Models.Event(Date(d1.toLong()), Date(d2.toLong()), i.toString()))
        }
        for (i in 0..random3) {
            list3.add(Models.Move(i.toString(), i.toString() + i.toString(), TimeInterval(i.toLong())))
        }

        list.addAll(list1)
        list.addAll(list2)
        list.addAll(list3)
    }

    fun IntRange.random() = (Math.random() * ((endInclusive + 1) - start) + start).toInt()
}
