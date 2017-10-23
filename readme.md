# 混合开发框架JSWebView的使用
---
开源地址：[https://github.com/jiyouliang2/QQShare](https://github.com/jiyouliang2/QQShare)

# 运行效果

![](screenshot.gif)

## 使用步骤

### 1. 在project的build.gradle添加如下代码(如下图)

	allprojects {
	    repositories {
	        maven { url "https://jitpack.io" }
	    }
	}

![](tu_1.png)

### 2. 在Module的build.gradle添加依赖

    compile 'com.github.jiyouliang2:QQShare:v1.0.0'

### 3.清单文件添加权限（QQ分享需要）

	<uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!-- SDK2.1新增获取用户位置信息 -->
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.GET_TASKS" />


		
	
### 4.布局使用JSWebView

	<com.itheima.jswebview.view.JSWebView xmlns:android="http://schemas.android.com/apk/res/android"
	    android:layout_width="match_parent"
	    android:id="@+id/webview"
	    android:layout_height="match_parent" />


	
### 5.代码中初始化并使用

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



	


	
