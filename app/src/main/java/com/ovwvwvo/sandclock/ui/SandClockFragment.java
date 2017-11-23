package com.ovwvwvo.sandclock.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ovwvwvo.common.widget.AutoLoadMoreAdapter;
import com.ovwvwvo.common.widget.DividerGridItemDecoration;
import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.adapter.SandClockAdapter;
import com.ovwvwvo.sandclock.model.SandClockModel;
import com.ovwvwvo.sandclock.presenter.SandClockPresenter;
import com.ovwvwvo.sandclock.view.SandClockView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guang on 2017/11/8.
 */

public class SandClockFragment extends BaseFragment implements AutoLoadMoreAdapter.OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener, SandClockView {

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private DividerGridItemDecoration gridIecoration;
    private DividerItemDecoration listDecoration;

    private final static int LIST_LAYOUT = 1;
    private final static int GRID_LAYOUT = 2;
    private int currentLayout = LIST_LAYOUT;

    private MainActivity activity;
    private SandClockPresenter presenter;
    private SandClockAdapter adapter;

    public static SandClockFragment newInstance() {
        return new SandClockFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//添加 optionsMenu
        presenter = new SandClockPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sandclock, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            activity = (MainActivity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void initView() {
        swipeRefreshLayout.setOnRefreshListener(this);

        adapter = new SandClockAdapter(getContext());
        adapter.setLoadMoreListener(this);
        recyclerView.setAdapter(adapter);

        listDecoration = new DividerItemDecoration(getContext(), LinearLayout.VERTICAL);
        gridIecoration = new DividerGridItemDecoration(getContext());
//        recyclerView.addItemDecoration(gridIecoration);
//        recyclerView.addItemDecoration(listDecoration);
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
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (activity != null)
                    if (dy > 20)
                        activity.hideBootomNavigation();
                    else if (dy < -20)
                        activity.showBootomNavigation();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.sandclock_option_menu, menu);
    }

    @Override
    public void onLoadMore() {
        presenter.loadData();
    }

    @Override
    public void onRefresh() {
        presenter.loadData();
    }

    @Override
    public void onLoadComplete(List<SandClockModel> models) {
        adapter.setModels(models);
    }

    @Override
    public void onShowLoading() {
    }

    @Override
    public void onHideLoding() {
        swipeRefreshLayout.setRefreshing(false);
    }
}
