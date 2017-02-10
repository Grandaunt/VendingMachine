package com.example.sjs.vendingmachine.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sjs.vendingmachine.R;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by SJS on 2017/1/4.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private  static  String TAG="RecyclerAdapter";
    private LayoutInflater mInflater;
    private ArrayList<HashMap<String, String>> mGoodsList;
    private String imageUrl;
    private float sumPrice;
    private int number;
    public   DecimalFormat decimalFormat;

    public RecyclerAdapter(Context context,ArrayList<HashMap<String, String>> showGoodsList) {
        this.mInflater = LayoutInflater.from(context);
        this.mGoodsList = showGoodsList;


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
//        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
//                HomeActivity.this).inflate(R.layout.item_home, parent,
//                false));
//        return holder;
    }


    /**
     * 数据的绑定显示
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
//        holder.item_tv.setText(mTitles[position]);
//        holder.tv.setText(mDatas.get(position));
//        holder.imGoods.setImageResource(mTitles[position]);
         decimalFormat=new DecimalFormat(".00");
        //构造方法的字符格式这里如果小数不足2位,会以0补足.
        imageUrl = "http://172.16.11.124:8080/MVNFHM/uploadFiles/uploadImgs/20170209/d9205a29278644fdbe6b37421bab17bb.png";
        number = Integer.parseInt(mGoodsList.get(position).get("goodsNumber"));
        sumPrice = Float.parseFloat(mGoodsList.get(position).get("goodsPrice"));
        Log.i(TAG,"goodsPrice*number="+sumPrice+"*"+number+"="+sumPrice*number);
        sumPrice = sumPrice*number;
        ImageOptions options = new ImageOptions.Builder()
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.testimage)
//设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.testimage)
                //设置圆形
                .setCircular(false)
                //某些手机拍照时图片自动旋转，设置图片是否自动旋转为正
                .setAutoRotate(true)
                //等比例缩放居中显示
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .build();
//        x.image().bind(imageView, iconUrl,imageOptions);
        x.image().bind(holder.imGoods, imageUrl, options);
        holder.tvGoodsName.setText(mGoodsList.get(position).get("goodsName"));
        holder.tvGoodsNumber.setText(mGoodsList.get(position).get("goodsNumber"));
        holder.tvGoodsSumPrice.setText(decimalFormat.format(sumPrice));

        // 如果设置了回调，则设置点击事件
        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);

                }
            });

//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
//            {
//                @Override
//                public boolean onLongClick(View v)
//                {
//                    int pos = holder.getLayoutPosition();
//                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
//                    return false;
//                }
//            });
        }
    }

    @Override
    public int getItemCount() {
//        return mTitles.length;
        return mGoodsList.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imGoods ;
        public TextView tvGoodsName,tvGoodsNumber,tvGoodsSumPrice;

        public ViewHolder(View view) {
            super(view);
            imGoods = (ImageView)view.findViewById(R.id.im_item_goods);
            tvGoodsName = (TextView) view.findViewById(R.id.tv_goods_name);
            tvGoodsNumber = (TextView) view.findViewById(R.id.tv_goods_number);
            tvGoodsSumPrice = (TextView) view.findViewById(R.id.tv_goods_sumPrice);
        }
    }

    public void addData(int position) {
//        mDatas.add(position, "Insert One");
        notifyItemInserted(position);
    }

    public void removeData(int position) {
//        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
//        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }


}