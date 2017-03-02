package com.example.sjs.vendingmachine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sjs.vendingmachine.Adapter.GoodsManagerReAdapter;
import com.example.sjs.vendingmachine.Adapter.GoodsShowReAdapter;
import com.example.sjs.vendingmachine.DB.Goods;
import com.example.sjs.vendingmachine.DB.GoodsRepo;
import com.example.sjs.vendingmachine.Http.GoodsBean;
import com.example.sjs.vendingmachine.Manager.MyCustomLayoutManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GoodsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GoodsFragment extends Fragment {
    public static String TAG="GoodsFragment";


    private RecyclerView Goos_RecyclerView;
//    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;
//    private List<String> mDatas;

    private ArrayList<HashMap<String, String>> showGoodsList;
    private GoodsShowReAdapter mAdapter;
    private ImageButton btn_up,btn_down;

        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

        // TODO: Rename and change types of parameters
        private String mParam1;
//    private String mParam2;

        private OnFragmentInteractionListener mListener;

        public GoodsFragment() {
            // Required empty public constructor
        }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @return A new instance of fragment GoodsFragment.
         */
        // TODO: Rename and change types and number of parameters
        public static GoodsFragment newInstance(String param1) {
            GoodsFragment fragment = new GoodsFragment();
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
//        Intent intent = new Intent(getActivity(),PayActivity.class);
////                intent.putExtra("MainActivity", "message");
//        startActivity(intent);
            View view = inflater.inflate(R.layout.fragment_goods, container, false);

            //初始化showGoodsList并获取showGoodsList数据
            showGoodsList = new  ArrayList<HashMap<String, String>> ();
            GoodsRepo repo = new GoodsRepo(getActivity());
            showGoodsList = repo.showGoodsList();
            Log.i(TAG,"showGoodsList.size="+showGoodsList.size());

            initData();

//开始设置RecyclerView
            Goos_RecyclerView=(RecyclerView)view.findViewById(R.id.recyclerview_goods);
            //设置固定大小
            Goos_RecyclerView.setHasFixedSize(true);
            //创建线性布局
            mLayoutManager = new LinearLayoutManager(getActivity());
//        mLayoutManager = new MyCustomLayoutManager(getActivity());
//        Goos_RecyclerView.setLayoutManager(mLayoutManager);
            //垂直方向
            mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            //给RecyclerView设置布局管理器
//        recyclerView_one.setLayoutManager(mLayoutManager);
            Goos_RecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));
//        recyclerView_one.setLayoutManager(new StaggeredGridLayoutManager(4,
//                StaggeredGridLayoutManager.VERTICAL));
            //创建适配器，并且设置
            mAdapter = new GoodsShowReAdapter(getActivity(),showGoodsList);
            Goos_RecyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickLitener(new GoodsShowReAdapter.OnItemClickLitener()
            {

                @Override
                public void onItemClick(View view, int position, String num)
                {
                    Intent intent = new Intent(getActivity(),PayActivity.class);
                    intent.putExtra("goodsNum", num);
                    startActivity(intent);

//                然后再新的Activity中：
//                String str = getIntent().getExtras().getString("MainActivity");
//                    Toast.makeText(getActivity(), position + " click",
//                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onItemLongClick(View view, int position,String num)
                {
                    Intent intent = new Intent(getActivity(),PayActivity.class);
                    intent.putExtra("goodsNum", "num");
                    startActivity(intent);
//                Toast.makeText(getActivity(), position + " long click",
//                        Toast.LENGTH_SHORT).show();
//                mAdapter.removeData(position);
                }
            });
            return view;

        }

    //初始化数据
    private void initData()
    {


    }
        // TODO: Rename method, update argument and hook method into UI event
        public void onButtonPressed(Uri uri) {
            if (mListener != null) {
                mListener.onFragmentInteraction(uri);
            }
        }

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof OnFragmentInteractionListener) {
                mListener = (OnFragmentInteractionListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement OnFragmentInteractionListener");
            }
        }

        @Override
        public void onDetach() {
            super.onDetach();
            mListener = null;
        }

        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
        public interface OnFragmentInteractionListener {
            // TODO: Update argument type and name
            void onFragmentInteraction(Uri uri);
        }
    }