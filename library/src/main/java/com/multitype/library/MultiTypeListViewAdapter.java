package com.multitype.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by wsg
 * on         2020/7/25
 * function:
 */
public class MultiTypeListViewAdapter extends BaseAdapter {

    private static final String TAG = "MultiTypeListViewAdapter";
    private List<?> items;
    private TypePool typePool;
    private LayoutInflater inflater;

    MultiTypeListViewAdapter(Context context) {
        this(context, Collections.emptyList());
    }

    MultiTypeListViewAdapter(Context context, List<?> items) {
        this(context, items, new MultiTypePool());
    }

    MultiTypeListViewAdapter(Context context, List<?> items, int initialCapacity) {
        this(context, items, new MultiTypePool(initialCapacity));
    }

    MultiTypeListViewAdapter(Context context, List<?> items, TypePool pool) {
        this.items = items;
        this.typePool = pool;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    <T> void register(Class<? extends T> clazz, BaseViewHolder<T> holder) {
        typePool.register(clazz, holder);
        holder.setAdapter(this);
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder = null;
        int viewType = getItemViewType(position);
        if (convertView == null) {
            viewHolder = typePool.getBaseViewHolder(viewType);
            convertView = inflater.inflate(viewHolder.getLayoutId(), parent, false);
            viewHolder.onBindViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (BaseViewHolder) convertView.getTag();
        }
        viewHolder.render(getItem(position), position); //渲染
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return typePool.size();
    }

    @Override
    public int getItemViewType(int position) {
        return typePool.indexOf(items.get(position).getClass());
    }
}
