package com.jsjy.activitydemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jsjy.activitydemo.R;
import com.jsjy.activitydemo.fragment.Fragment1;
import com.jsjy.activitydemo.fragment.Fragment2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * author：dong.jingfeng
 * date：2020-04-20:16:32
 * email：315975450@qq.com
 * description：
 * remark：
 */
public class ActivityFragmentCommunicationActivity extends AppCompatActivity implements View.OnClickListener, Fragment1.CommunicationInterface {

    private FrameLayout mFrameLayout;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(ActivityFragmentCommunicationActivity.this, "fragment通过handler传递来了消息", Toast.LENGTH_SHORT).show();
        }
    };

    public Handler getHandler() {
        return mHandler;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);
        mFrameLayout = findViewById(R.id.fm_fragment);
        Log.d("============","onCreate");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_way_1:
                Fragment1 fragment1 = new Fragment1();
                Bundle bundle = new Bundle();
                bundle.putString("key", "第一种方式传递");
                fragment1.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.fm_fragment, fragment1).commit();
                break;
            case R.id.btn_way_2:
                Fragment2 fragment2 = new Fragment2();
                getSupportFragmentManager().beginTransaction().replace(R.id.fm_fragment, fragment2).commit();
                break;
        }
    }

    public String getInfo() {
        return "第二种方式传递";
    }

    @Override
    public void showMessage() {
        Toast.makeText(this, "fragment传递信息到activity", Toast.LENGTH_SHORT).show();
    }
}
