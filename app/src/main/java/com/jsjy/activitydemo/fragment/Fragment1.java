package com.jsjy.activitydemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jsjy.activitydemo.R;

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
public class Fragment1 extends Fragment {
    CommunicationInterface mCommunicationInterface;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof CommunicationInterface) {
            mCommunicationInterface = (CommunicationInterface) context;
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
        info.setText(getArguments().getString("key"));
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCommunicationInterface.showMessage();
            }
        });
        return view;

    }

    public interface CommunicationInterface {
        void showMessage();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCommunicationInterface = null;
    }
}
