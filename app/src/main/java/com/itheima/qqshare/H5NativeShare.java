package com.itheima.qqshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.itheima.qqshare.view.JavascriptMethods;

public class H5NativeShare extends AppCompatActivity {

    private WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_native_share);
        initView();
        //开启js和android通信开关
        mWebview.getSettings().setJavaScriptEnabled(true);
        //设置2个Client
        mWebview.setWebViewClient(new WebViewClient());
        mWebview.setWebChromeClient(new WebChromeClient());

        //设置h5和native通信桥梁类：通信桥梁接口
        //参数1：对象,参数2：字符串，代表参数1的别名
        mWebview.addJavascriptInterface(new JavascriptMethods(this), "jsInerface");

        //显示网页
        mWebview.loadUrl("http://10.0.3.2:8080/html38/share.html");
    }

    private void initView() {
        mWebview = (WebView) findViewById(R.id.webview);
    }
}
