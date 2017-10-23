package com.itheima.jswebview.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 自定义的WebView
 */

public class JSWebView extends WebView {

    private Activity activity;

    public JSWebView(Context context) {
        this(context, null);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        addJavascriptInterface(new JavascriptMethods(activity), "jsInerface");
    }

    public JSWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //设置WebView
        //开启js和android通信开关
        getSettings().setJavaScriptEnabled(true);
        //设置2个Client
        setWebViewClient(new WebViewClient());
        setWebChromeClient(new WebChromeClient());
        if(activity == null){
            return;
        }
        addJavascriptInterface(new JavascriptMethods(activity), "jsInerface");
    }

    public JSWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    public JSWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        this(context, attrs);
    }
}
