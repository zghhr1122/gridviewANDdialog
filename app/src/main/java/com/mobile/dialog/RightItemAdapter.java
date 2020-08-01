package com.mobile.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class RightItemAdapter extends BaseAdapter {
    private List<RightItemModel> provinceBeanList;
    private LayoutInflater layoutInflater;

    public RightItemAdapter(Context context, List<RightItemModel> provinceBeanList) {
        this.provinceBeanList = provinceBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return provinceBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return provinceBeanList.get(position);

    }


    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.gridview_item, null);
            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text_view);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        RightItemModel rightbeanBean = provinceBeanList.get(position);
        if (rightbeanBean != null) {
            holder.text.setText(rightbeanBean.getName());
           /* Drawable drawable= convertView.getResources().getDrawable(R.drawable.logo);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());*/
            holder.text.setCompoundDrawables(null,rightbeanBean.getImage(),null,null);
        }
        return convertView;

    }



    class ViewHolder {
        TextView text;
        Drawable image;
    }

}
