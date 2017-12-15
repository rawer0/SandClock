package com.ovwvwvo.sandclock.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.ovwvwvo.common.utils.ToastMaster;
import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.model.Constants;
import com.ovwvwvo.sandclock.model.SandClockModel;
import com.ovwvwvo.sandclock.presenter.AddPresenter;
import com.ovwvwvo.sandclock.view.AddView;
import com.ovwvwvo.sandclock.widgets.DatePickView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright ©2017 by rawer
 */

public class AddActivity extends BaseActivity implements TextWatcher, AddView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.name_et)
    EditText nameEt;
    @BindView(R.id.date_tv)
    TextView dateTv;
    @BindView(R.id.priority_iv)
    ImageView priorityIv;
    @BindView(R.id.priority_tv)
    TextView priorityTv;
    @BindView(R.id.repeat_tv)
    TextView repeatTv;
    @BindView(R.id.remark_tv)
    TextView remarkTv;

    private SandClockModel model = new SandClockModel(System.currentTimeMillis());
    private AddPresenter addPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        initView();
        addPresenter = new AddPresenter(this);
    }

    private void initView() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        nameEt.addTextChangedListener(this);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        dateTv.setText(DateFormat.format(Constants.DATE_FORMAT, calendar.getTime()));
        model.setTargetDate(calendar.getTimeInMillis());
        priorityTv.setText(getResources().getStringArray(R.array.prioritys)[0]);
        repeatTv.setText(getResources().getStringArray(R.array.repeats)[0]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done_active, menu);
        MenuItem doneItem = menu.findItem(R.id.menu_done);
        doneItem.setIcon(TextUtils.isEmpty(model.getName()) ? R.drawable.ic_done : R.drawable.ic_done_active);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.menu_done:
                if (TextUtils.isEmpty(model.getName()))
                    ToastMaster.showToastMsg(R.string.name_empty_tip);
                else {
                    model.setRemark(remarkTv.getText().toString().trim());
                    addPresenter.addDay(model);
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.date_tv)
    void onTimeClick() {
        DatePickView datePickView = new DatePickView(this, new Date(model.getTargetDate()));
        new MaterialDialog.Builder(this)
                .customView(datePickView, false)
                .positiveText(R.string.sure)
                .negativeText(R.string.cancel)
                .onPositive((dialog, which) -> {
                    dateTv.setText(DateFormat.format(Constants.DATE_FORMAT, datePickView.getDate()));
                    model.setTargetDate(datePickView.getDate().getTime());
                })
                .show();
    }

    @OnClick(R.id.repeat_tv)
    void onRepeatClick() {
        new MaterialDialog.Builder(this)
                .items(R.array.repeats)
                .itemsCallbackSingleChoice(model.getRepeat(), (dialog, itemView, position, text) -> {
                    repeatTv.setText(text);
                    model.setRepeat(position);
                    return true;
                })
                .show();
    }

    @OnClick(R.id.priority_tv)
    void onPriorityClick() {
        new MaterialDialog.Builder(this)
                .items(R.array.prioritys)
                .itemsCallbackSingleChoice(model.getPriority(), (dialog, itemView, position, text) -> {
                    priorityTv.setText(text);
                    priorityIv.setImageResource(position == 0 ? R.drawable.ic_circle :
                            position == 1 ? R.drawable.ic_circle_amber : R.drawable.ic_circle_red);
                    model.setPriority(position);
                    return true;
                })
                .show();
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        model.setName(charSequence.toString());
        invalidateMenu();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @Override
    public void onViewDestory() {
        finish();
    }

    @Override
    public void onAddComplete() {
        onViewDestory();
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoding() {

    }
}
