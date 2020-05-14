package com.jsjy.activitydemo;

import android.app.Application;

/**
 * author：dong.jingfeng
 * date：2020-04-23:14:13
 * email：315975450@qq.com
 * description：
 * remark：
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
