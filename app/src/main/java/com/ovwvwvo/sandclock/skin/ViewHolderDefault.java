package com.ovwvwvo.sandclock.skin;

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

    @BindView(R.id.title)
    TextView titleTv;
    @BindView(R.id.desc)
    TextView descTv;
    @BindView(R.id.time)
    TextView timeTv;
    @BindView(R.id.unit)
    TextView unitTv;
    @BindView(R.id.target)
    TextView targetTv;

    ViewHolderDefault(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setModel(SandClockModel model) {
    }

    @Override
    public void setTitle(String title) {
        titleTv.setText(title);
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


}
