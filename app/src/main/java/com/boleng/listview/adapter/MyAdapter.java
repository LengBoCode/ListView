package com.boleng.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boleng.listview.R;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.zip.Inflater;

/**
 * Created by boleng on 9/1/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mData;

    public MyAdapter(Context context, ArrayList<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        if (mData == null) {
            return 0;
        }
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            viewHolder.imgIcon = (ImageView) convertView.findViewById(R.id.imgIcon);
            viewHolder.txtContainer = (TextView) convertView.findViewById(R.id.txtContainer);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imgIcon.setImageResource(R.mipmap.ic_launcher);
        viewHolder.txtContainer.setText(mData.get(position));
        return convertView;
    }

    public final class ViewHolder {
        public ImageView imgIcon;
        public TextView txtContainer;
    }
}

