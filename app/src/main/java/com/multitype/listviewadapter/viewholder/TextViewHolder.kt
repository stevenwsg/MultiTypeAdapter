package com.multitype.listviewadapter.viewholder

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.multitype.library.BaseViewHolder
import com.multitype.listviewadapter.R
import com.multitype.listviewadapter.bean.TextItem

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
class TextViewHolder : BaseViewHolder<TextItem>() {

    private var text: TextView? = null
    private var context: Context? = null

    override fun getLayoutId(): Int {
        return R.layout.item_text
    }

    override fun onBindViewHolder(rootView: View) {
        context = rootView.context
        text = rootView.findViewById(R.id.text)
    }

    override fun render(item: TextItem, position: Int) {
        text?.text = item.text
        text?.setOnClickListener {
            Log.d("WSG", position.toString())
            Toast.makeText(context, item.text + position, Toast.LENGTH_SHORT).show()
        }
    }
}