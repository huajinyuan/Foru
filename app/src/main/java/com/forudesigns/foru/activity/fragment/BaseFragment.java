package com.forudesigns.foru.activity.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.forudesigns.foru.activity.BaseActivity;
import com.forudesigns.foru.activity.MainActivity;
import com.forudesigns.foru.R;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * Created by Administrator on 2016/7/26.
 */
public class BaseFragment extends RxFragment {

//    @BindView(R.id.toolbar)
//    protected Toolbar mToolBar;
//    @BindView(R.id.tv_nav_toolbar_title)
//    TextView mCenterTitle;
//    @BindView(R.id.tv_nav_toobar_left_menu)
//    TextView mNavLeftText;

    protected void initToolBar(Toolbar toolbar, TextView centerTitle, TextView navLeftText) {
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.icon_home_normal);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                popFragment();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }


    public void showTast(String msg) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showToask(msg);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
