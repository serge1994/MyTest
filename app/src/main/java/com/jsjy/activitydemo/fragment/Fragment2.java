package com.jsjy.activitydemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jsjy.activitydemo.R;
import com.jsjy.activitydemo.activity.ActivityFragmentCommunicationActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * author：dong.jingfeng
 * date：2020-04-20:16:36
 * email：315975450@qq.com
 * description：
 * remark：
 */
public class Fragment2 extends Fragment {

    private String mInfo;
    private Handler mHandler;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityFragmentCommunicationActivity) {
            mInfo = ((ActivityFragmentCommunicationActivity) context).getInfo();
            mHandler = ((ActivityFragmentCommunicationActivity) context).getHandler();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        Button info = view.findViewById(R.id.btn_info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessage(0);
            }
        });
        info.setText(mInfo);
        return view;

    }

}
