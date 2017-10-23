package com.itheima.qqshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.itheima.qqshare.view.JSWebView;

public class H5NativeShareAdvance extends AppCompatActivity {

    private JSWebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_native_share);
        initView();
        mWebview.setActivity(this);
        //显示网页
        mWebview.loadUrl("http://10.0.3.2:8080/html38/share.html");
    }

    private void initView() {
        mWebview = (JSWebView) findViewById(R.id.webview);
    }
}
