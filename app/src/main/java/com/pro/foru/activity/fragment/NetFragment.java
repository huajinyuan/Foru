package com.pro.foru.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pro.foru.foru.R;
import com.pro.foru.net.BaseResponse;
import com.pro.foru.net.IRetrofitService;
import com.pro.foru.net.RetrofitRequest;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by hjy on 16/6/4.
 */
public class NetFragment extends RxFragment {
    @BindView(R.id.tv_tip)
    public TextView mTip;
    @BindView(R.id.imageView)
    public ImageView mImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nettest, null);
        ButterKnife.bind(this, view);
        Glide.with(this).load("http://goo.gl/gEgYUd").into(mImageView);
        return view;
    }

    @OnClick(R.id.btn_post)
    public void doPost() {
        IRetrofitService retrofitService = RetrofitRequest.getInstance().getmRetrofit().create(IRetrofitService.class);
        retrofitService.getInfo("15280479951")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {

                        mTip.setText(baseResponse.data.toString());
                    }
                });
    }

    @OnClick(R.id.btn_get)
    public void doGet() {
    }

}
