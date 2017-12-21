package com.ovwvwvo.sandclock.skin.mainItem;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.model.SandClockModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guang on 2017/12/15
 */

public class ViewHolderDefault extends BaseViewHolder {

    @BindView(R.id.name)
    TextView nameTv;
    @BindView(R.id.desc)
    TextView descTv;
    @BindView(R.id.time)
    TextView timeTv;
    @BindView(R.id.unit)
    TextView unitTv;
    @BindView(R.id.target)
    TextView targetTv;

    public ViewHolderDefault(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setModel(SandClockModel model) {
    }

    @Override
    public void setName(String title) {
        nameTv.setText(title);
    }

    @Override
    public void setDesc(String desc) {
        descTv.setText(desc);
    }

    @Override
    public void setTime(String time) {
        timeTv.setText(time);
    }

    @Override
    public void setUnit(String unit) {
        unitTv.setText(unit);
    }

    @Override
    public void setTarget(String target) {
        targetTv.setText(target);
    }

    @Override
    public void setPriority(Context context, int priority) {
        if (priority == 1) {
            nameTv.setTextColor(ContextCompat.getColor(context, R.color.priority_level_1));
        } else if (priority == 2) {
            nameTv.setTextColor(ContextCompat.getColor(context, R.color.priority_level_2));
        } else {
            nameTv.setTextColor(ContextCompat.getColor(context, android.R.color.black));
        }
    }

    @Override
    public void setRepeat(int repeat) {

    }


}
