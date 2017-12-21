package com.ovwvwvo.sandclock.skin.mainItem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ovwvwvo.sandclock.model.SandClockModel;

/**
 * Created by guang on 2017/12/15
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setModel(SandClockModel model);

    public abstract void setName(String title);

    public abstract void setDesc(String desc);

    public abstract void setTime(String time);

    public abstract void setUnit(String unit);

    public abstract void setTarget(String target);

    public abstract void setPriority(Context context,int priority);

    public abstract void setRepeat(int repeat);

}
