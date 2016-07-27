package com.forudesigns.foru.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.pro.foru.foru.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjy on 16/6/4.
 */
public class MainFragment extends BaseFragment {
    @BindView(R.id.id_drawerLayout)
    public DrawerLayout mDrawerLayout;
    private FragmentManager fragmentManager;
    private NetFragment mNetFragment;
    private WebFragment mWebFragment;
    private HomeShopFragment mHomeShopFragment;
//    private GraphicsFragment mGraphicsFragment;
    /**
     * tab初始化
     */
    @BindView(R.id.img_main_tabA)
    public ImageView mImgTabA;
    @BindView(R.id.tv_main_tabA)
    public TextView mTvTabA;
    @BindView(R.id.img_main_tabB)
    public ImageView mImgTabB;
    @BindView(R.id.tv_main_tabB)
    public TextView mTvTabB;
    @BindView(R.id.img_main_tabC)
    public ImageView mImgTabC;
    @BindView(R.id.tv_main_tabC)
    public TextView mTvTabC;
    @BindView(R.id.img_main_tabD)
    public ImageView mImgTabD;
    @BindView(R.id.tv_main_tabD)
    public TextView mTvTabD;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                Gravity.RIGHT);
        initEvents();
        fragmentManager = getActivity().getSupportFragmentManager();
        if (null != fragmentManager) {
            hideFragments(fragmentManager.beginTransaction());
        }
        setTabSelection(0);
        return view;
    }


    private void initEvents() {
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerStateChanged(int newState) {
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = mDrawerLayout.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
                float rightScale = 0.8f + scale * 0.2f;

                if (drawerView.getTag().equals("LEFT")) {

                    float leftScale = 1 - 0.3f * scale;

                    ViewHelper.setScaleX(mMenu, leftScale);
                    ViewHelper.setScaleY(mMenu, leftScale);
                    ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                    ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));
                    ViewHelper.setPivotX(mContent, 0);
                    ViewHelper.setPivotY(mContent,
                            mContent.getMeasuredHeight() / 2);
                    mContent.invalidate();
                    ViewHelper.setScaleX(mContent, rightScale);
                    ViewHelper.setScaleY(mContent, rightScale);
                }

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                mDrawerLayout.setDrawerLockMode(
                        DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.RIGHT);
            }
        });
    }

    private void hideFragments(FragmentTransaction transaction) {

        if (null != mNetFragment) {
            transaction.hide(mNetFragment);
        }
        if (null != mWebFragment) {
            transaction.hide(mWebFragment);
        }
        if (null != mHomeShopFragment) {
            transaction.hide(mHomeShopFragment);
        }
//        if (null != mGraphicsFragment) {
//            transaction.hide(mGraphicsFragment);
//        }
    }

    public void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (null == mNetFragment) {
                    mNetFragment = new NetFragment();
                    transaction.add(R.id.content, mNetFragment);
                } else {
                    transaction.show(mNetFragment);
                }
                break;
            case 1:
                if (null == mHomeShopFragment) {
                    mHomeShopFragment = new HomeShopFragment();
                    transaction.add(R.id.content, mHomeShopFragment);
                } else {
                    transaction.show(mHomeShopFragment);
                }
               /* if (null == mWebFragment) {
                    mWebFragment = new WebFragment();
                    transaction.add(R.id.content, mWebFragment);
                }
                else {
                    transaction.show(mWebFragment);
                }*/
                break;
            case 2:
//                if (null == mGraphicsFragment) {
//                    mGraphicsFragment = new GraphicsFragment();
//                    transaction.add(R.id.content, mGraphicsFragment);
//                }
//                else
//                {
//                    transaction.show(mGraphicsFragment);
//                }

                break;
            case 3:

                break;
        }
        transaction.commitAllowingStateLoss();
    }

    @OnClick({R.id.main_tab_A, R.id.main_tab_B, R.id.main_tab_C, R.id.main_tab_D})
    public void actionClick(View view) {
        clearSelection();
        switch (view.getId()) {
            case R.id.main_tab_A:
                mTvTabA.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_white));
                mImgTabA.setImageResource(R.mipmap.icon_home_select);
                setTabSelection(0);
                break;
            case R.id.main_tab_B:
                mTvTabB.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_white));
                mImgTabB.setImageResource(R.mipmap.icon_shop_select);
                setTabSelection(1);
                break;
            case R.id.main_tab_C:
                mTvTabC.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_white));
                mImgTabC.setImageResource(R.mipmap.icon_create_select);
                setTabSelection(2);
                break;
            case R.id.main_tab_D:
                mTvTabD.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_white));
                mImgTabD.setImageResource(R.mipmap.icon_me_select);
                setTabSelection(3);
                break;
        }

    }

    /**
     * 还原tab状态
     */
    public void clearSelection() {
        mTvTabA.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_gray));
        mTvTabB.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_gray));
        mTvTabC.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_gray));
        mTvTabD.setTextColor(ContextCompat.getColor(getActivity(), R.color.text_gray));
        mImgTabA.setImageResource(R.mipmap.icon_home_normal);
        mImgTabB.setImageResource(R.mipmap.icon_shop_normal);
        mImgTabC.setImageResource(R.mipmap.icon_create_normal);
        mImgTabD.setImageResource(R.mipmap.icon_me_normal);
    }

    /**
     * 开启新的Fragment
     */
    private void open(Fragment fragment) {
        final String tag = fragment.getClass().toString();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.main_content, fragment, tag)
                .commit();
    }
}
