package com.multitype.library

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
public class MultiTypePool : TypePool {
    private val classes: MutableList<Class<*>>
    private val holders: MutableList<BaseViewHolder<*>>

    constructor() {
        classes = ArrayList()
        holders = ArrayList()
    }

    constructor(initialCapacity: Int) {
        classes = ArrayList(initialCapacity)
        holders = ArrayList(initialCapacity)
    }

    override fun <T> register(
        clazz: Class<out T>,
        holder: BaseViewHolder<T>
    ) {
        classes.add(clazz)
        holders.add(holder)
    }

    override fun unregister(clazz: Class<*>) {
        val postion = indexOf(clazz)
        classes.remove(clazz)
        holders.removeAt(postion)
    }

    override fun size(): Int {
        return classes.size
    }

    override fun indexOf(clazz: Class<*>): Int {
        return classes.indexOf(clazz)
    }

    override fun getBaseViewHolder(index: Int): BaseViewHolder<*> {
        return holders[index]
    }
}