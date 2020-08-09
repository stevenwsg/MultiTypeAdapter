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

    public MultiTypeListViewAdapter(Context context) {
        this(context, Collections.emptyList());
    }

    public MultiTypeListViewAdapter(Context context, List<?> items) {
        this(context, items, new MultiTypePool());
    }

    public MultiTypeListViewAdapter(Context context, List<?> items, int initialCapacity) {
        this(context, items, new MultiTypePool(initialCapacity));
    }

    public MultiTypeListViewAdapter(Context context, List<?> items, TypePool pool) {
        this.items = items;
        this.typePool = pool;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setItems(List<?> items) {
        this.items = items;
    }

    public List<?> getItems() {
        return items;
    }

    public <T> void register(Class<? extends T> clazz, BaseViewHolder<T> holder) {
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
        BaseViewHolder viewHolder;
        int viewType = getItemViewType(position);
//        if (convertView == null) {
//
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = typePool.getBaseViewHolder(viewType);
//        }
        viewHolder = typePool.getBaseViewHolder(viewType);
        convertView = inflater.inflate(viewHolder.getLayoutId(), parent, false);
        viewHolder.onBindViewHolder(convertView);
        // TODO: 2020/7/25 WSG VH复用问题需解决
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
