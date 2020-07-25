package com.multitype.listviewadapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.multitype.library.BaseViewHolder
import com.multitype.listviewadapter.R
import com.multitype.listviewadapter.bean.RichItem

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
class RichTextViewHolder : BaseViewHolder<RichItem>() {

    private var image: ImageView? = null
    private var text: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.item_rich
    }

    override fun onBindViewHolder(rootView: View) {
        image = rootView.findViewById(R.id.image)
        text = rootView.findViewById(R.id.text)
    }

    override fun render(item: RichItem, position: Int) {
        text?.setText(item.text)
        image?.setImageResource(item.imageResId)
    }
}