package com.ovwvwvo.sandclock.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ovwvwvo.common.widget.AutoLoadMoreAdapter;
import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.model.SandClockModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guang on 2017/11/8.
 */

public class SandClockAdapter extends AutoLoadMoreAdapter {
    private ArrayList<SandClockModel> models = new ArrayList<>();
    private Context context;

    private LayoutInflater inflater;
    private int spancount = 2;

    public enum ItemType {
        VERTICAL, HORIZONTAL, LOAD_MORE
    }

    public SandClockAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setSpancount(int spancount) {
        this.spancount = spancount;
    }

    public void setModels(List<SandClockModel> models) {
        clearModels();
        this.models.addAll(models);
        notifyDataChanged();
    }

    public void addModels(List<SandClockModel> models) {
        this.models.addAll(models);
        notifyDataChanged();
    }

    private void clearModels() {
        this.models.clear();
        notifyDataChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ItemType.VERTICAL.ordinal()) {
            return new MViewHolder(inflater.inflate(R.layout.item_detail_grid, parent, false));
        } else if (viewType == ItemType.HORIZONTAL.ordinal()) {
            return new MViewHolder(inflater.inflate(R.layout.item_detail_list, parent, false));
        } else {
            return new LoadMoreViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_loadmore, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SandClockModel model = models.get(position);
        if (holder instanceof MViewHolder) {
            ((MViewHolder) holder).title.setText(model.getContent());
            ((MViewHolder) holder).desc.setText("还有");
            ((MViewHolder) holder).time.setText("1");
            ((MViewHolder) holder).unit.setText("天");
            ((MViewHolder) holder).target.setText(new Date(model.getTargetDate()).toString());
        } else {
        }
    }

    @Override
    public int getItemCount() {
        return models.size() + (isLoading ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
//        if (position >= models.size())
//            return ItemType.LOAD_MORE.ordinal();
//        else if (spancount == 2) {
//            return ItemType.VERTICAL.ordinal();
//        } else return ItemType.HORIZONTAL.ordinal();
        return ItemType.HORIZONTAL.ordinal();
    }

    class MViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.unit)
        TextView unit;
        @BindView(R.id.target)
        TextView target;

        MViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        LoadMoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
