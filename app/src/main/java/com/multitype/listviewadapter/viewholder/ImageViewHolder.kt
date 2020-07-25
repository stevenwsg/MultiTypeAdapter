package com.multitype.listviewadapter.viewholder

import android.view.View
import android.widget.ImageView
import com.multitype.library.BaseViewHolder
import com.multitype.listviewadapter.R
import com.multitype.listviewadapter.bean.ImageItem

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
class ImageViewHolder : BaseViewHolder<ImageItem>() {

    private var image: ImageView? = null

    override fun getLayoutId(): Int {
        return R.layout.item_image
    }

    override fun onBindViewHolder(rootView: View) {
        image = rootView.findViewById(R.id.image)
    }

    override fun render(item: ImageItem, position: Int) {
        image?.setImageResource(item.resId)
    }
}