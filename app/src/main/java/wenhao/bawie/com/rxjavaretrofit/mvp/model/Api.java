package wenhao.bawie.com.rxjavaretrofit.mvp.model;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wenhao.bawie.com.rxjavaretrofit.bean.UserBean;

/**
 * Created by HP on 2018/11/4.
 */

public interface Api {
    @GET("product/getCarts")
    Observable<UserBean> toget(@Query("uid") int uid);//被观察者
}
