package com.itheima.qqshare;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.open.utils.ThreadManager;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

public class MainActivity extends AppCompatActivity {

    private Tencent mTencent;
    private ShareListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTencent();
    }

    private void initTencent() {
        //初始化腾讯api
        mTencent = Tencent.createInstance("222222", this);
    }

    public void share(View v){
        //调用QQ分享
        final Bundle params = new Bundle();
        //设置分享参数：图片、标题...
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "中国共产党第十九次全国代表大会在京开幕");//标题
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://news.163.com/17/1018/20/D12A99E200018AOQ.html");//网站
        //简述
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "习近平代表第十八届中央委员会向大会作报告 李克强主持大会2338名代表和特邀代表出席大会");
        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://cms-bucket.nosdn.127.net/catchpic/9/92/92827db66f02919de4bd7f685d7a2163.jpg?imageView&thumbnail=550x0");

        //调用QQ分享
        // QQ分享要在主线程做
        mListener = new ShareListener();
        ThreadManager.getMainHandler().post(new Runnable() {

            @Override
            public void run() {
                if (null != mTencent) {
                    mTencent.shareToQQ(MainActivity.this, params, mListener);
                }
            }
        });
    }

    private class ShareListener implements IUiListener{

        //分享成功
        @Override
        public void onComplete(Object o) {
            Toast.makeText(MainActivity.this, ""+o.toString(), Toast.LENGTH_SHORT).show();
        }

        //分享失败
        @Override
        public void onError(UiError uiError) {

        }

        //取消分享
        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "取消分享", Toast.LENGTH_SHORT).show();
        }
    }

    //处理分享结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_QQ_SHARE) {
            Tencent.onActivityResultData(requestCode,resultCode,data,mListener);
        }
    }
}
