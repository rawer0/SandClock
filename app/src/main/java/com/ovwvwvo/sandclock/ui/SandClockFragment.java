package com.ovwvwvo.sandclock.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ovwvwvo.common.widget.AutoLoadMoreAdapter;
import com.ovwvwvo.common.widget.DividerGridItemDecoration;
import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.adapter.SandClockAdapter;
import com.ovwvwvo.sandclock.presenter.SandClockPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guang on 2017/11/8.
 */

public class SandClockFragment extends BaseFragment implements AutoLoadMoreAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DividerGridItemDecoration gridIecoration;
    private DividerItemDecoration listDecoration;

    private final static int LIST_LAYOUT = 1;
    private final static int GRID_LAYOUT = 2;
    private int currentLayout = LIST_LAYOUT;

    private SandClockPresenter presenter;
    private SandClockAdapter adapter;

    public static SandClockFragment newInstance() {
        return new SandClockFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//添加 optionsMenu
        presenter = new SandClockPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sandclock, container, false);
        ButterKnife.bind(this, view);
        presenter.loadData();
        initView();
        return view;
    }

    private void initView() {
        listDecoration = new DividerItemDecoration(getContext(), LinearLayout.VERTICAL);
        gridIecoration = new DividerGridItemDecoration(getContext());
//        recyclerView.addItemDecoration(gridIecoration);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (currentLayout == GRID_LAYOUT) {
                    boolean bo = SandClockAdapter.ItemType.LOAD_MORE.ordinal() == adapter.getItemViewType(position);
                    return bo ? 2 : 1;
                } else if (currentLayout == LIST_LAYOUT) {
                    return 2;
                } else return 0;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new SandClockAdapter(getContext());
        adapter.setLoadMoreListener(this);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.sandclock_option_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }
}
