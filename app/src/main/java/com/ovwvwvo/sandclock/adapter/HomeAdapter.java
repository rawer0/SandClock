package com.ovwvwvo.sandclock.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ovwvwvo.common.widget.AutoLoadMoreAdapter;
import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.model.Constants;
import com.ovwvwvo.sandclock.model.SandClockModel;
import com.ovwvwvo.sandclock.skin.BaseViewHolder;
import com.ovwvwvo.sandclock.skin.ViewHolderFactory;
import com.ovwvwvo.sandclock.utils.TimeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by guang on 2017/11/8.
 */

public class HomeAdapter extends AutoLoadMoreAdapter {

    public final static int ITEM_TYPE_NORMAL = -1, ITEM_TYPE_LOAD_MORE = -2;
    private ArrayList<SandClockModel> models = new ArrayList<>();
    private Context context;

    private LayoutInflater inflater;

    public HomeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
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
        if (viewType == ITEM_TYPE_LOAD_MORE) {
            return new LoadMoreViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_loadmore, parent, false));
        } else {
            return ViewHolderFactory.getDefault().buildViewHolder(viewType, layoutId -> inflater.inflate(layoutId, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SandClockModel model = models.get(position);
        if (holder instanceof BaseViewHolder) {
            long interval = TimeUtil.getDayOfInterval(model.getTargetDate());
            String desc = TextUtils.isEmpty(model.getDesc()) ? getIntervalDesc(interval) : model.getDesc();
            BaseViewHolder baseViewHolder = (BaseViewHolder) holder;
            baseViewHolder.setTitle(model.getName());
            baseViewHolder.setDesc(desc);
            baseViewHolder.setTime(String.valueOf(Math.abs(interval)));
            baseViewHolder.setUnit(context.getResources().getStringArray(R.array.unit)[model.getUnit()]);
            baseViewHolder.setTarget("" + DateFormat.format(Constants.DATE_FORMAT, new Date(model.getTargetDate())));
        }
    }

    @Override
    public int getItemCount() {
        return models.size() + (isLoading ? 1 : 0);
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= models.size())
            return ITEM_TYPE_LOAD_MORE;
        else {
            return models.get(position).getSkin();
        }
    }

    private String getIntervalDesc(long interval) {
        if (interval > 0) {
            return context.getResources().getString(R.string.time_desc_future);
        } else {
            return context.getResources().getString(R.string.time_desc_past);
        }
    }

    class LoadMoreViewHolder extends RecyclerView.ViewHolder {

        LoadMoreViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
