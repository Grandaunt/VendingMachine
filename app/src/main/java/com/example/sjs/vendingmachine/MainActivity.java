package com.example.sjs.vendingmachine;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.sjs.vendingmachine.View.FloatView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


/**
 * BottomNavigationBar实现
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//    private BottomNavigationBar bottomNavigationBar;
////    int lastSelectedPosition = 0;
//    private String TAG = MainActivity.class.getSimpleName();
    public  static  String TAG="MainActivity";
    private GoodsFragment mGoodsFragment;
    private FetchCodeFragment mFetchCodeFragment;
    private HelpFragment mHelpFragment;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private TextView tv_goods,tv_fetchcode,tv_help;
    private LinearLayout ly_goods,ly_fetchcode,ly_help;
    private ImageView im_goods,im_fetchcode,im_help;
    private TextView floatView;

    private GoogleApiClient client;
//    private BookFragment mBookFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"<<onCreate>>");
          floatView  = new FloatView(getApplicationContext());
          floatView.setText("已投入： 0 元");
          floatView.setTextColor(Color.WHITE);
          floatView.setBackgroundColor(Color.RED);
//          floatView.setTextSize(10);

          tv_goods = (TextView)findViewById(R.id.text_goods);
          tv_fetchcode = (TextView)findViewById(R.id.text_fetchcode);
          tv_help = (TextView)findViewById(R.id.text_help);
          ly_goods = (LinearLayout) findViewById(R.id.ly_goods);
          ly_fetchcode = (LinearLayout) findViewById(R.id.ly_fetchcode);
          ly_help = (LinearLayout) findViewById(R.id.ly_help);
          im_goods = (ImageView) findViewById(R.id.image_goods);
          im_fetchcode= (ImageView) findViewById(R.id.image_fetchcode);
          im_help= (ImageView) findViewById(R.id.image_help);
          ly_goods.setOnClickListener(this);
          ly_fetchcode.setOnClickListener(this);
          ly_help.setOnClickListener(this);
          setDefaultFragment();
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        /***
         * MODE_DEFAULT
         如果Item的个数<=3就会使用MODE_FIXED模式，否则使用MODE_SHIFTING模式
         MODE_FIXED
         填充模式，未选中的Item会显示文字，没有换挡动画。
         MODE_SHIFTING
         换挡模式，未选中的Item不会显示文字，选中的会显示文字。在切换的时候会有一个像换挡的动画
         BACKGROUND_STYLE_STATIC
         点击的时候没有水波纹效果
         n-active color
         表示未选中Item中的图标和文本颜色。默认为 Color.LTGRAY
         active color :
         在BACKGROUND_STYLE_STATIC下，表示选中Item的图标和文本颜色。而在BACKGROUND_STYLE_RIPPLE下，表示整个容器的背景色。默认Theme's Primary Color
         background color :
         在BACKGROUND_STYLE_STATIC下，表示整个容器的背景色。而在BACKGROUND_STYLE_RIPPLE下，表示选中Item的图标和文本颜色。默认 Color.WHITE
         */
//        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
//        bottomNavigationBar.setMode(BottomNavigationBar.MODE_DEFAULT);
//        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        bottomNavigationBar
//                .setActiveColor(R.color.colorPrimary)
//                .setInActiveColor(R.color.Black)
//                .setBarBackgroundColor(R.color.White);
//        bottomNavigationBar
//                .addItem(new BottomNavigationItem(R.mipmap.ic_goods_black_200dp, "商品").setActiveColor(R.color.Red).setInActiveColor(R.color.Black))
////                        .setInActiveColor(R.color.Orange))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_fetchcode_black_200, "提取码").setActiveColor(R.color.Red).setInActiveColor(R.color.Black))
//                .addItem(new BottomNavigationItem(R.mipmap.ic_help_black_200dp, "帮助").setActiveColor(R.color.Red))
////                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "图书").setActiveColor(R.color.blue))
//                .setFirstSelectedPosition(lastSelectedPosition)
//                .initialise();
//
//        bottomNavigationBar.setTabSelectedListener(this);
//        setDefaultFragment();
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        Log.i(TAG,"<<setDefaultFragment>>");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mGoodsFragment = GoodsFragment.newInstance("商品");
        // mFetchCodeFragment = FetchCodeFragment.newInstance("提取码");
        transaction.replace(R.id.tb, mGoodsFragment);
        transaction.commit();
        showFloatView();
    }

//    @Override
//    public void onTabSelected(int position) {
//        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
//        FragmentManager fm = this.getFragmentManager();
//        //开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        switch (position) {
//            case 0:
//                if (mGoodsFragment == null) {
//                    mGoodsFragment = GoodsFragment.newInstance("商品");
//                }
//                transaction.replace(R.id.tb, mGoodsFragment);
//                break;
//            case 1:
//                if (mFetchCodeFragment == null) {
//                    mFetchCodeFragment = FetchCodeFragment.newInstance("提取码");
//                }
//                transaction.replace(R.id.tb, mFetchCodeFragment);
//                break;
//            case 2:
//                if (mHelpFragment == null) {
//                    mHelpFragment = HelpFragment.newInstance("帮助");
//                }
//                transaction.replace(R.id.tb, mHelpFragment);
//                break;
////            case 3:
////                if (mBookFragment == null) {
////                    mBookFragment = BookFragment.newInstance("图书");
////                }
////                transaction.replace(R.id.tb, mBookFragment);
////                break;
//            default:
//                break;
//        }
//        // 事务提交
//        transaction.commit();
//    }
//
//    @Override
//    public void onTabUnselected(int position) {
////        if (fragments != null) {
////            if (position < fragments.size()) {
////                FragmentManager fm = getSupportFragmentManager();
////                FragmentTransaction ft = fm.beginTransaction();
////                Fragment fragment = fragments.get(position);
////                ft.remove(fragment);
////                ft.commitAllowingStateLoss();
////            }
////        }
//        Log.d(TAG, "onTabUnselected() called with: " + "position = [" + position + "]");
//    }
//
//    @Override
//    public void onTabReselected(int position) {
//
//    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    public Action getIndexApiAction() {
//        Thing object = new Thing.Builder()
//                .setName("Main Page") // TODO: Define a title for the content shown.
//                // TODO: Make sure this auto-generated URL is correct.
//                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//                .build();
//        return new Action.Builder(Action.TYPE_VIEW)
//                .setObject(object)
//                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//                .build();
//    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"<<onStart>>");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"<<onStop>>");
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG,"<<onClick>>");
//        Log.d(TAG, "onTabSelected() called with: " + "position = [" + position + "]");
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (v.getId()){
            case R.id.ly_goods :
                showFloatView();
                Log.i(TAG,"<<ly_goods>>");
                im_goods.setImageResource(R.mipmap.ic_goods_red_200dp);
                tv_goods.setTextColor(Color.RED);
                im_fetchcode.setImageResource(R.mipmap.ic_fetchcode_black_200);
                tv_fetchcode.setTextColor(Color.BLACK);
                im_help.setImageResource(R.mipmap.ic_help_black_200dp);
                tv_help.setTextColor(Color.BLACK);
                if (mGoodsFragment == null) {
                    mGoodsFragment = GoodsFragment.newInstance("商品");
                }
                transaction.replace(R.id.tb, mGoodsFragment);
                // 事务提交
                transaction.commit();
                break;
            case R.id.ly_fetchcode :
                removeFloatView();
                Log.i(TAG,"<<ly_fetchcode>>");
                im_goods.setImageResource(R.mipmap.ic_goods_black_200dp);
                tv_goods.setTextColor(Color.BLACK);
                im_fetchcode.setImageResource(R.mipmap.ic_fetchcode_red_200);
                tv_fetchcode.setTextColor(Color.RED);
                im_help.setImageResource(R.mipmap.ic_help_black_200dp);
                tv_help.setTextColor(Color.BLACK);
                if (mFetchCodeFragment == null) {
                    mFetchCodeFragment = FetchCodeFragment.newInstance("提取码");
                }
                transaction.replace(R.id.tb, mFetchCodeFragment);
                // 事务提交
                transaction.commit();
                break;
            case R.id.ly_help :
                removeFloatView();
                Log.i(TAG,"<<ly_help>>");
                im_goods.setImageResource(R.mipmap.ic_goods_black_200dp);
                tv_goods.setTextColor(Color.BLACK);
                im_fetchcode.setImageResource(R.mipmap.ic_fetchcode_black_200);
                tv_fetchcode.setTextColor(Color.BLACK);
                im_help.setImageResource(R.mipmap.ic_help_red_200dp);
                tv_help.setTextColor(Color.RED);
                if (mHelpFragment == null) {
                    mHelpFragment = HelpFragment.newInstance("帮助");
                }
                transaction.replace(R.id.tb, mHelpFragment);
                // 事务提交
                transaction.commit();
                break;
            default:
                break;

        }


    }



    /**
     * 悬浮按钮
     */
    public void removeFloatView() {
        Log.i(TAG,"<<removeFloatView>>");
        WindowManager wManager = (WindowManager) getApplicationContext().getSystemService( Context.WINDOW_SERVICE);
//        如果要将其从WindowManager中移除，则可以执行以下语句：
        if(floatView.getParent()!=null)
            wManager.removeView(floatView);
    }
    public void showFloatView() {
        Log.i(TAG,"<<showFloatView>>");
        // 首先，得到WindoeManager对象：
        WindowManager wManager = (WindowManager) getApplicationContext().getSystemService( Context.WINDOW_SERVICE);
        //其次，得到WindowManager.LayoutParams对象，为后续设置相关参数做准备：
         WindowManager.LayoutParams wmParams=new WindowManager.LayoutParams();
        // 接着，设置相关的窗口布局参数，要实现悬浮窗口效果，主要需要设置的参数有：
        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 设置window type
        wmParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
        /*
        * 下面的flags属性的效果形同“锁定”。 悬浮窗不可触摸，不接受任何事件,同时不影响后面的事件响应。
        */
        wmParams.flags= WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        wmParams.gravity = Gravity.RIGHT| Gravity.TOP; // 调整悬浮窗口至右上 CENTER_VERTICAL是中间
        // 以屏幕左上角为原点，设置x、y初始值
        wmParams.x = 0;
        wmParams.y = 0;

// 设置悬浮窗口长宽数据
        wmParams.width = 170;
        wmParams.height = 170;
//        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;;
//        wmParams.height =WindowManager.LayoutParams.WRAP_CONTENT;;

        //  然后，就可以将需要加到悬浮窗口中的View加入到窗口中了：
        // if(floatView.getParent==null)如果view没有被加入到某个父组件中，则加入WindowManager中
            wManager.addView(floatView,wmParams);
        //  其中，view为需要放到悬浮窗口中的视图组件。


    }
    @Override
    protected void onPostResume() {
        Log.i(TAG,"<<onPostResume>>");
        super.onPostResume();
    }
    @Override
    protected void onDestroy() {
        Log.i(TAG,"<<onDestroy>>");

        super.onDestroy();
    }



}