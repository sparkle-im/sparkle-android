package com.edsgerlin.sparkle;

import android.content.Context;
import android.database.DataSetObserver;
import android.databinding.ObservableArrayList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by edsge on 4/11/2016.
 */
public class MessageListAdapter implements ListAdapter {
    final Set<DataSetObserver> observers = new HashSet<>();
    final ArrayList<SparkleMessage> messages = new ArrayList<>();
    final Context context;

    public MessageListAdapter(Context context, ArrayList<SparkleMessage> messages) {
        this.context = context;
        this.messages.addAll(messages);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(final DataSetObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void unregisterDataSetObserver(final DataSetObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public SparkleMessage getItem(final int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view;
        if (convertView != null) {
            view = (TextView) convertView;
        }
        else {
            view = new TextView(this.context);
        }
        view.setText((CharSequence) getItem(position).toString());
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return IGNORE_ITEM_VIEW_TYPE;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return messages.isEmpty();
    }
}
