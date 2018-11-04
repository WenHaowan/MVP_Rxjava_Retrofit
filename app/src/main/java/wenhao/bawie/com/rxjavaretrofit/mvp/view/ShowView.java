package wenhao.bawie.com.rxjavaretrofit.mvp.view;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.bean.UserBean;

/**
 * Created by HP on 2018/11/4.
 */

public interface ShowView {
    void success(List<UserBean.DataBean> list);
}
