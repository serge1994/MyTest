package com.jsjy.activitydemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;


import androidx.annotation.Nullable;

/**
 * author：dong.jingfeng
 * date：2020-04-21:13:37
 * email：315975450@qq.com
 * description：
 * remark：
 */
public class Service1 extends Service {
    private MyCallBack mCallback;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("Jeffrey", "service====onCreate===service线程" + Looper.getMainLooper().getThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String key = intent.getStringExtra("key");
        Log.d("Jeffrey", "onStartCommand=====" + key);
        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String key = intent.getStringExtra("key");
        Log.d("Jeffrey", "onBind=====" + key);
        Log.d("Jeffrey", "onBind===绑定了服务");
        if (key.equals("Intent传递消息2")) {
            return new MyBind();
        } else {
            return new MyBind2();
        }
    }

    public class MyBind extends Binder {
        public void showMessage() {
            Log.d("Jeffrey", "bindService传递消息");
        }
    }

    public class MyBind2 extends Binder {
        public Service1 getMyService() {
            return Service1.this;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Jeffrey", "onDestroy=====结束了service");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("Jeffrey", "onUnbind======结束绑定service");
        return super.onUnbind(intent);
    }

    public void setCallBack(MyCallBack callBack) {
        this.mCallback = callBack;
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4; i++) {
                    mCallback.onDataChange(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public interface MyCallBack {
        void onDataChange(int data);
    }

}
