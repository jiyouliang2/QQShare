package com.itheima.jswebview.util;

import android.app.Activity;
import android.os.Bundle;

import com.tencent.connect.share.QQShare;
import com.tencent.open.utils.ThreadManager;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import org.json.JSONObject;

/**
 * Created by developer
 */

public class ShareSDK {

    public static void share2QQ(String json, final Activity context, final IUiListener listener){
        //解析js传递过来的分享信息
        System.out.println("分享到QQ的参数="+json);
        try {
            JSONObject jsonObject = new JSONObject(json);

            final Tencent mTencent = Tencent.createInstance("222222", context);
            //调用QQ分享
            final Bundle params = new Bundle();
            //设置分享参数：图片、标题...
            params.putString(QQShare.SHARE_TO_QQ_TITLE, jsonObject.optString("title"));//标题
            params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, jsonObject.optString("url"));//网站
            //简述
            params.putString(QQShare.SHARE_TO_QQ_SUMMARY, jsonObject.optString("summary"));
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, jsonObject.optString("img_url"));

            //调用QQ分享
            // QQ分享要在主线程做
            ThreadManager.getMainHandler().post(new Runnable() {

                @Override
                public void run() {
                    if (null != mTencent) {
                        mTencent.shareToQQ(context, params, listener);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
