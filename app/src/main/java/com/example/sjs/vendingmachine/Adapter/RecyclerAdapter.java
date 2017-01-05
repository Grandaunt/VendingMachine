package com.example.sjs.vendingmachine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sjs.vendingmachine.R;

/**
 * Created by SJS on 2017/1/4.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private String[] mTitles = null;

    public RecyclerAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mTitles = new String[20];
        for (int i = 0; i < 20; i++) {
            int index = i + 1;
            mTitles[i] = "item" + index;
        }
    }

    /**
     * item显示类型
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_recycler_layout, parent, false);
        //view.setBackgroundColor(Color.RED);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    /**
     * 数据的绑定显示
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.item_tv.setText(mTitles[position]);
    }

    @Override
    public int getItemCount() {
        return mTitles.length;
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView item_tv;

        public ViewHolder(View view) {
            super(view);
//            item_tv = (TextView) view.findViewById(R.id.item_tv);
        }
    }

//    public void addData(int position) {
//        mDatas.add(position, "Insert One");
//        notifyItemInserted(position);
//    }
//
//    public void removeData(int position) {
//        mDatas.remove(position);
//        notifyItemRemoved(position);
//    }
}