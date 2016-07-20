package com.pro.foru.net;

import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by hjy on 16/6/22.
 */
public interface IRetrofitService {
    @POST("api/v1/login")
    Observable<BaseResponse> getInfo(@Query("email") String accouont,@Query("password") String pwd ,@Query("key") String apiKey);
    @GET("api/v1/user/orders")
    Observable<BaseResponse> getOrders(@Header("Authorization")String header, @Query("key") String apiKey,@Query("per_page") int per_page,@Query("page") int page);
}
