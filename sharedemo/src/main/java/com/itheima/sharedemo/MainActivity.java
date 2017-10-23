package com.itheima.sharedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.itheima.jswebview.view.JSWebView;

public class MainActivity extends AppCompatActivity {

    private JSWebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mWebview.setActivity(this);
        mWebview.loadUrl("http://10.0.3.2:8080/html38/share.html");
    }

    private void initView() {
        mWebview = (JSWebView) findViewById(R.id.webview);
    }
}
