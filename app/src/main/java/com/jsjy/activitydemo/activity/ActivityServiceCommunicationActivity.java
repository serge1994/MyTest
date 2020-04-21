package com.jsjy.activitydemo.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jsjy.activitydemo.R;
import com.jsjy.activitydemo.service.Service1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * author：dong.jingfeng
 * date：2020-04-21:13:33
 * email：315975450@qq.com
 * description：
 * remark：
 */
public class ActivityServiceCommunicationActivity extends AppCompatActivity implements View.OnClickListener, ServiceConnection {

    private Service1 mService1;
    private Intent mIntent;
    private TextView mData;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mData.setText("接受数据" + msg.obj);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_communication);
        mData = findViewById(R.id.txt_data);
        mIntent = new Intent(this, Service1.class);
        Log.d("Jeffrey", Thread.currentThread().getName());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                mIntent.putExtra("key", "Intent传递消息1");
                startService(mIntent);
                break;
            case R.id.btn_stop:
                stopService(mIntent);
                break;
            case R.id.btn_bind://普通传递
                mIntent.putExtra("key", "Intent传递消息2");
                bindService(mIntent, this, BIND_AUTO_CREATE);
                break;
            case R.id.btn_bind2://有异步情况利用callback+handler
                mIntent.putExtra("key", "Intent传递消息3");
                bindService(mIntent, this, BIND_AUTO_CREATE);
                break;
            case R.id.btn_unBind:
                unbindService(this);
                break;
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d("Jeffrey", "onServiceConnected线程" + Thread.currentThread().getName());
        if (service instanceof Service1.MyBind) {
            ((Service1.MyBind) service).showMessage();
        }
        if (service instanceof Service1.MyBind2) {
            ((Service1.MyBind2) service).getMyService().setCallBack(new Service1.MyCallBack() {
                @Override
                public void onDataChange(int data) {
                    Log.d("Jeffrey", "onDataChange线程" + Thread.currentThread().getName());
                    Message message = new Message();
                    message.obj = data;
                    mHandler.sendMessage(message);
                }
            });
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d("Jeffrey", "onServiceDisconnected");
    }
}
