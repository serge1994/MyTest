package com.jsjy.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jsjy.activitydemo.activity.ActivityFragmentCommunicationActivity;
import com.jsjy.activitydemo.activity.ActivityServiceCommunicationActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_fragment:
                startActivity(new Intent(this, ActivityFragmentCommunicationActivity.class));
                break;
            case R.id.btn_main_service:
                startActivity(new Intent(this, ActivityServiceCommunicationActivity.class));
                break;
        }
    }
}
