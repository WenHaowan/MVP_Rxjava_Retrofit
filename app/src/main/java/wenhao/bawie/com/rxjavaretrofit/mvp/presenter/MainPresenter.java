package wenhao.bawie.com.rxjavaretrofit.mvp.presenter;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.rxjavaretrofit.bean.UserBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.model.HttpUtils;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.ShowView;

/**
 * Created by HP on 2018/11/4.
 */

public class MainPresenter implements IPresenter{
     private ShowView showView;

    public MainPresenter(ShowView showView) {
        this.showView = showView;
    }

    public void getData(int uid){
        Observable<UserBean> toget = HttpUtils.getUtilsInstance().api.toget(uid);
        toget.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        showView.success(userBean.getData());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    @Override
    public void onDestroy() {
        if (showView!=null){
            showView = null;
        }
    }
}
