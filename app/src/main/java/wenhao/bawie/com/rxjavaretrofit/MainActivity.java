package wenhao.bawie.com.rxjavaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.adapter.ShowAdapter;
import wenhao.bawie.com.rxjavaretrofit.bean.UserBean;
import wenhao.bawie.com.rxjavaretrofit.mvp.model.Common;
import wenhao.bawie.com.rxjavaretrofit.mvp.presenter.MainPresenter;
import wenhao.bawie.com.rxjavaretrofit.mvp.view.ShowView;

public class MainActivity extends AppCompatActivity implements ShowView{

    private RecyclerView recy_view;
    private int uid = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_view = (RecyclerView) findViewById(R.id.recy_view);

        MainPresenter presenter = new MainPresenter(this);
        presenter.getData(uid);

        recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void success(List<UserBean.DataBean> list) {
        ShowAdapter adapter = new ShowAdapter(MainActivity.this,list);
        list.remove(0);
        recy_view.setAdapter(adapter);
    }
}
