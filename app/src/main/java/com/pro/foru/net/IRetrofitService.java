package com.pro.foru.net;

import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by hjy on 16/6/22.
 */
public interface IRetrofitService {
    @POST("wbaiju/cgi/user_detailed.api")
    Observable<BaseResponse> getInfo(@Query("account") String accouont);
}
