package com.itheima.jswebview.view;

import android.app.Activity;
import android.webkit.JavascriptInterface;

import com.itheima.jswebview.util.ShareSDK;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/**
 * H5和native通信桥梁类
 */

public class JavascriptMethods {

    private Activity context;

    public JavascriptMethods(Activity context) {
        this.context = context;
    }

    @JavascriptInterface
    public void share2QQ(String json){
        System.out.println(json);

        //调用QQ分享
        ShareSDK.share2QQ(json, context, new IUiListener() {
            @Override
            public void onComplete(Object o) {

            }

            @Override
            public void onError(UiError uiError) {

            }

            @Override
            public void onCancel() {

            }
        });
    }
}
