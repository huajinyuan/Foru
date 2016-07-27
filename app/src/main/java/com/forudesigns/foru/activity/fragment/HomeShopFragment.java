package com.forudesigns.foru.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.forudesigns.foru.R;
import com.forudesigns.foru.wigets.SlideShowView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjy on 16/7/14.
 */
public class HomeShopFragment extends BaseFragment {
    @BindView(R.id.slideshowview)
    public SlideShowView mSlideShowView;
    @BindView(R.id.viewpager_homeshop_product)
    public ViewPager mViewPager;
    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private TabFragmentPagerAdapter adapter;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeshop, null);
        ButterKnife.bind(this, view);
        fragmentManager = getActivity().getSupportFragmentManager();
        for (int i = 0; i < 5; i++) {
            mFragments.add(new NetFragment());
        }
        adapter = new TabFragmentPagerAdapter(fragmentManager, mFragments);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(adapter);
        ArrayList<Integer> uris = new ArrayList<>();
        uris.add(R.mipmap.img_1);
        uris.add(R.mipmap.img_2);
        uris.add(R.mipmap.img_3);
        uris.add(R.mipmap.img_4);
        uris.add(R.mipmap.img_5);
        mSlideShowView.setImageUris(uris);
        return view;
    }

    @OnClick(R.id.slideshowview)
    public void click() {
        showTast("TabShop");
    }
}
