package com.example.sjs.vendingmachine.Http;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sjs.vendingmachine.R;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;

/**
 * Created by SJS on 2017/1/17.
 */

@ContentView(R.layout.activity_http)
class httptest extends AppCompatActivity {
    //    private Context context;
    @ViewInject(R.id.get)
    private Button GET;

    @ViewInject(R.id.post)
    private Button POST;

    @ViewInject(R.id.other)
    private Button OTHER;

    @ViewInject(R.id.download)
    private Button DOWNLOAD;

    @ViewInject(R.id.cache)
    private Button CACHE;

    @ViewInject(R.id.httptextView)
    private TextView TX;

    @ViewInject(R.id.httpimageView)
    private ImageView imageView;

    ImageOptions imageOptions;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //注入view和事件

        x.view().inject(this);

        //        context=this;

        imageOptions = new ImageOptions.Builder()

                .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))

                .setRadius(DensityUtil.dip2px(5))

                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true)

                // 加载中或错误图片的ScaleType

                //.setPlaceholderScaleType(ImageView.ScaleType.MATRIX)

                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)

                //设置加载过程中的图片

                .setLoadingDrawableId(R.mipmap.ic_launcher)

                //设置加载失败后的图片

                .setFailureDrawableId(R.mipmap.ic_launcher)

                //设置使用缓存

                .setUseMemCache(true)

                //设置支持gif

                .setIgnoreGif(false)

                //设置显示圆形图片

                //      .setCircular(false)

                .build();

    }

    String url = "http://www.baidu.com/";

    @Event(R.id.get)

    private void get(View v) {

        final ProgressDialog progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("正在下载");

        RequestParams params = new RequestParams(url);

        params.addQueryStringParameter("username", "11000");

        params.addQueryStringParameter("password", "888888");

        Callback.Cancelable cancelable = x.http().get(params, new Callback.CommonCallback() {

            @Override
            public void onSuccess(Object result) {
                Log.i("get_onSuccess", "result" + result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                //请求不管成功还是失败都会调用

                progressDialog.cancel();

            }

        });

        cancelable.cancel();

    }

    @Event(value = {R.id.httpimageView})
    private void loadImage(View view) {
        x.image().bind(imageView, "http://img2.3lian.com/2014/f2/164/d/17.jpg", imageOptions);

    }

    @Event(R.id.post)

    private void post(View view) {
        RequestParams params = new RequestParams(url);
        params.addBodyParameter("username", "12323");

        //根据当前请求方式添加参数位置

        params.addParameter("password", "2313");

        //        params.addHeader("head","xs");
        x.http().post(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.i("get_onSuccess", "result" + result);

                TX.setText(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }

    @Event(R.id.other)

    private void other(View view) {

        RequestParams params = new RequestParams(url);

        params.addBodyParameter("usrname", "34234");

        x.http().request(HttpMethod.PUT, params, new Callback.CacheCallback<String>() {

            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override

            public void onSuccess(String result) {
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override

            public void onCancelled(CancelledException cex) {

            }

            @Override

            public void onFinished() {

            }

        });

    }

    @Event(R.id.upload)

    private void upload(View view) {

        String path = "//";

        RequestParams params = new RequestParams(url);

        params.addBodyParameter("file", new File(path));

        x.http().post(params, new Callback.CacheCallback<String>() {

            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override

            public void onSuccess(String result) {

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }


            @Override

            public void onCancelled(CancelledException cex) {

            }

            @Override

            public void onFinished() {

            }

        });

    }

    @Event(R.id.download)

    private void download(View view) {

        url = "";

        RequestParams params = new RequestParams(url);

        Callback.Cancelable post =
                x.http().post(params, new Callback.ProgressCallback<File>() {

                    @Override

                    public void onSuccess(File result) {

                    }

                    @Override

                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override

                    public void onCancelled(CancelledException cex) {

                    }

                    @Override

                    public void onFinished() {
                    }

                    @Override

                    public void onWaiting() {

                    }

                    @Override

                    public void onStarted() {

                    }

                    @Override
                    public void onLoading(long total, long current, boolean isDownloading) {
                        //文件下载时回调的方法

                        Log.i("xxxxxxxxxxxxx", "current<<" + current + "total<<" + total);
                    }


                });

    }

    @Event(R.id.cache)

    private void cache(View view) {
        RequestParams params = new RequestParams(url);

        params.setCacheMaxAge(1000 * 60);

        Callback.Cancelable cancelable =
                x.http().get(params, new Callback.CacheCallback<String>() {

                    @Override

                    public boolean onCache(String result) {

                        //false 不相信本地缓存

                        //相信本地缓存

                        Log.i("sdadasd", "cache<<" + result);

                        return false;

                    }

                    @Override

                    public void onSuccess(String result) {

                        Log.i("get_onSuccess", "result" + result);

                    }

                    @Override

                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override

                    public void onCancelled(CancelledException cex) {

                    }

                    @Override

                    public void onFinished() {

                        //请求不管成功还是失败都会调用

                    }

                });
        cancelable.cancel();
    }


}
