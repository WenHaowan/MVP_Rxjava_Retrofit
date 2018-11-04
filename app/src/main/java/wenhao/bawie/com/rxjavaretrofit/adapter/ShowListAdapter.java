package wenhao.bawie.com.rxjavaretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import wenhao.bawie.com.rxjavaretrofit.R;
import wenhao.bawie.com.rxjavaretrofit.bean.UserBean;

/**
 * Created by HP on 2018/11/4.
 */

public class ShowListAdapter extends RecyclerView.Adapter<ShowListAdapter.ListViewHolder>{
    private Context context;
    private List<UserBean.DataBean.ListBean> list;

    public ShowListAdapter(Context context, List<UserBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ShowListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.show_list_adapter, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(inflate);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ShowListAdapter.ListViewHolder holder, int position) {
        holder.text_name.setText(list.get(position).getTitle());
        holder.text_price.setText("价格："+list.get(position).getPrice());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.image_view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView text_name,text_price;
        private ImageView image_view;

        public ListViewHolder(View itemView) {
            super(itemView);
            image_view = (ImageView) itemView.findViewById(R.id.image_view);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_price = (TextView) itemView.findViewById(R.id.text_price);
        }
    }
}
