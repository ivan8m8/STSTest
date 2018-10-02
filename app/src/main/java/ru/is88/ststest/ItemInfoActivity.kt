package ru.is88.ststest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_item_info.*

class ItemInfoActivity : AppCompatActivity() {

    val ITEM_KEY: String = "item_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_info)

        val item = intent.extras.getSerializable(ITEM_KEY)

        val itemInfoListViewAdapter = ItemInfoListViewAdapter(this, item as Models.Inlinable)
        itemInfoListView.adapter = itemInfoListViewAdapter

    }
}