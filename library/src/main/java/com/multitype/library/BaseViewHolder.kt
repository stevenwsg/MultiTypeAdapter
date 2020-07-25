package com.multitype.library

import android.view.View

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
public abstract class BaseViewHolder<T> {

    protected var adapter: MultiTypeListViewAdapter? = null

    // 获取布局id
    abstract fun getLayoutId(): Int
    abstract fun onBindViewHolder(rootView: View) // 绑定View
    abstract fun render(item: T, position: Int) // 渲染数据
}