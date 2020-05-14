package com.jsjy.activitydemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.jsjy.activitydemo.activity.ActivityFragmentCommunicationActivity;
import com.jsjy.activitydemo.activity.ActivityServiceCommunicationActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("===========","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("===========","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("===========","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("===========","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("===========","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("===========","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("===========","onRestart");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("===========","onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("===========","onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("===========","onConfigurationChanged");
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
