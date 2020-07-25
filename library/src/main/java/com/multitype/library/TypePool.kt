package com.multitype.library

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
interface TypePool {
    fun <T> register(clazz: Class<out T>, holder: BaseViewHolder<T>)
    fun unregister(clazz: Class<*>)
    fun size(): Int
    fun indexOf(clazz: Class<*>): Int
    fun getBaseViewHolder(index: Int): BaseViewHolder<*>
}