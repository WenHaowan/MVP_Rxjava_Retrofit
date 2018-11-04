package wenhao.bawie.com.rxjavaretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import okhttp3.Call;
import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.bean.UserBean;

/**
 * Created by HP on 2018/11/4.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowViewholder>{
    private Context context;
    private List<UserBean.DataBean> list;

    public ShowAdapter(Context context, List<UserBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowAdapter.ShowViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.show_adapter, parent, false);
        ShowViewholder showViewholder = new ShowViewholder(inflate);
        return showViewholder;
    }

    @Override
    public void onBindViewHolder(ShowAdapter.ShowViewholder holder, int position) {
        holder.text_view_name.setText(list.get(position).getSellerName());
        holder.list_recy_view.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        ShowListAdapter showListAdapter = new ShowListAdapter(context,list.get(position).getList());
        holder.list_recy_view.setAdapter(showListAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ShowViewholder extends RecyclerView.ViewHolder {

        private TextView text_view_name;
        private RecyclerView list_recy_view;

        public ShowViewholder(View itemView) {
            super(itemView);
            list_recy_view = (RecyclerView) itemView.findViewById(R.id.list_recy_view);
            text_view_name = (TextView) itemView.findViewById(R.id.text_view_name);
        }
    }
}
