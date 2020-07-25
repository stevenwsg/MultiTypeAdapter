package com.multitype.listviewadapter

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.multitype.library.MultiTypeListViewAdapter
import com.multitype.listviewadapter.bean.ImageItem
import com.multitype.listviewadapter.bean.RichItem
import com.multitype.listviewadapter.bean.TextItem
import com.multitype.listviewadapter.viewholder.ImageViewHolder
import com.multitype.listviewadapter.viewholder.RichTextViewHolder
import com.multitype.listviewadapter.viewholder.TextViewHolder

class MainActivity : AppCompatActivity() {

    private var mList: MutableList<Any>? = null
    private var mListView: ListView? = null
    private var adapter: MultiTypeListViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData();
        initAdapter();

        mListView = findViewById(R.id.listview)
        mListView?.adapter = adapter
    }

    private fun initData() {
        mList = ArrayList()
        for (i in 1..100) {
            mList?.add(ImageItem(R.mipmap.ic_launcher))
            mList?.add(RichItem("小艾大人赛高", R.drawable.ic_launcher_foreground))
            mList?.add(TextItem("没有什么能够阻挡，你对自由的向往~"))
        }
    }

    private fun initAdapter() {
        adapter = MultiTypeListViewAdapter(this, mList)
        adapter?.register(RichItem::class.java, RichTextViewHolder())
        adapter?.register(ImageItem::class.java, ImageViewHolder())
        adapter?.register(TextItem::class.java, TextViewHolder())
    }
}