package com.pro.foru.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pro.foru.foru.R;
import com.pro.foru.wigets.SlideShowView;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hjy on 16/7/14.
 */
public class HomeShopFragment extends RxFragment {
    @BindView(R.id.slideshowview)
    public SlideShowView mSlideShowView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeshop, null);
        ButterKnife.bind(this, view);
        ArrayList<Integer> uris = new ArrayList<>();
        uris.add(R.mipmap.img_1);
        uris.add(R.mipmap.img_2);
        uris.add(R.mipmap.img_3);
        uris.add(R.mipmap.img_4);
        uris.add(R.mipmap.img_5);
        mSlideShowView.setImageUris(uris);
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
