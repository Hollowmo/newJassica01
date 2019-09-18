package com.jassica.jassica.ui.classify.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jassica.jassica.R;
import com.jassica.jassica.bean.ClassifyBean;
import com.jassica.jassica.widget.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.ViewHoder> {
    private Context context;
    private ArrayList<ClassifyBean.DatasBean> list;

    public ClassifyAdapter(Context context, ArrayList<ClassifyBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_flow, null);
        return new ViewHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder viewHoder, final int i) {
        viewHoder.mFl.removeAllViews();
        ClassifyBean.DatasBean dataBean = list.get(i);
        List<ClassifyBean.DatasBean.CategoryListBeanXX> categoryList = dataBean.getCategoryList();
        for (int j = 0; j < categoryList.size(); j++) {
            //获取视图,视图可以自定义,可以添加自己想要的效果
            View inflate = View.inflate(context, R.layout.item_text, null);
            TextView tv_title = inflate.findViewById(R.id.tv_title);
            //获取数据
            final String title = categoryList.get(j).getCategoryName();
            //绑定数据
            tv_title.setText(title);
            //设置字体颜色
//            setTextColor(title, tv_title, j);
            //加到容器中,parent是FlowLayout
            viewHoder.mFl.addView(inflate);
            final int finalJ = j;

            tv_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickListener!=null){
                        onClickListener.onClick(i,finalJ);
                    }
                }
            });
        }
        int index = 0;
        for (int j = index; j < categoryList.size(); j++) {
            String name = categoryList.get(j).getCategoryName();
            viewHoder.mTitle.setText(name);
            index++;
            return;
        }


    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    /*private void setTextColor(String title, TextView label, int j) {
        String s = label.getText().toString();
        if (title.length() > 0 && title.length() < 3) {
            label.setTextColor(UIUtils.getColor(R.color.c_fa6a13));
        } else if (title.length() >= 3 && title.length() < 6) {
            label.setTextColor(UIUtils.getColor(R.color.colorPrimaryDark));
        } else if (title.length() >= 6 && title.length() < 9) {
            label.setTextColor(UIUtils.getColor(R.color.c_ff9D53));
        } else if (title.length() >= 9 && title.length() < 12) {
            label.setTextColor(UIUtils.getColor(R.color.c_c0c0c0));
        } else if (title.length() >= 12) {
            label.setTextColor(UIUtils.getColor(R.color.c_333333));
        }
    }*/

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView mTitle;
        FlowLayout mFl;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            this.mTitle = (TextView) itemView.findViewById(R.id.title);
            this.mFl = (FlowLayout) itemView.findViewById(R.id.fl);
        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int position, int newPosition);
    }


}
