package com.pro.foru.net;

import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by hjy on 16/6/22.
 */
public interface IRetrofitService {
    @POST("api/v1/login")
    Observable<BaseResponse> getInfo(@Query("email") String accouont,@Query("password") String pwd ,@Query("key") String apiKey);
}
