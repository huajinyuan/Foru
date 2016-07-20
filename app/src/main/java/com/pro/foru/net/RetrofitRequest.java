package com.pro.foru.net;

import com.pro.foru.config.Constants;
import com.pro.foru.utils.FastJsonConverterFactory;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by hjy on 16/6/22.
 */
public class RetrofitRequest {
    private static RetrofitRequest mRetrofitRequest = null;

    public Retrofit mRetrofit;

    public RetrofitRequest() {

        if (null == mRetrofit) {
            mRetrofit = new Retrofit.Builder()//FastJsonConverterFactory
                    .baseUrl(Constants.BASE_PATH)
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }
    }

    public static RetrofitRequest getInstance() {
        if (null == mRetrofitRequest) {
            mRetrofitRequest = new RetrofitRequest();

        }
        return mRetrofitRequest;
    }

    public Retrofit getmRetrofit() {
        return mRetrofit;
    }

    public void reSetRetrofit(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

}
