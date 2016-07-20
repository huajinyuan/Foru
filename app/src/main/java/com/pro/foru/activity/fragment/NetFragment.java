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
import com.pro.foru.net.RequestA;
import com.pro.foru.net.RetrofitRequest;
import com.pro.foru.utils.F;
import com.pro.foru.utils.StringUtils;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
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
        retrofitService.getInfo("abc@qq.com", "123456", "IkD4M40BxKbnVheA2Lq3Em87OOqKEH1o")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        F.e("onError :data is null");
                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        F.e(baseResponse.getData(RequestA.class).token);
                        mTip.setText(baseResponse.getData(RequestA.class).token);
                    }
                });
    }

    @OnClick(R.id.btn_get)
    public void doGet() {
        IRetrofitService retrofitService = RetrofitRequest.getInstance().getmRetrofit().create(IRetrofitService.class);
        retrofitService.getOrders("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1Nzg3NGQyMjA1NmYyOTBmMWY3ZGY3YzEiLCJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjEwLjI0OTo4MDgwXC9hcGlcL3YxXC9sb2dpbiIsImlhdCI6MTQ2OTAwMTkxMSwiZXhwIjoxNDcxNTkzOTExLCJuYmYiOjE0NjkwMDE5MTEsImp0aSI6IjM0YjJkMmQ4NTQyYzc0ZDg4NTZkNWIzNzNmMGE1NGFjIn0.oFFczl8giHJeXxN9D-jjGsyKQFc7feTDOoiZz-MSA44","IkD4M40BxKbnVheA2Lq3Em87OOqKEH1o", 10, 1)
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
                        F.e(baseResponse.toString());
                    }
                });

    }

}
