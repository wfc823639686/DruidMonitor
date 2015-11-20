package cn.okar.druidmonitor.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.inject.Inject;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cn.okar.druidmonitor.R;
import cn.okar.druidmonitor.common.BaseFragment;
import cn.okar.druidmonitor.common.HttpClient;
import roboguice.inject.InjectView;

/**
 * Created by wangfengchen on 15/11/20.
 */
public abstract class StatBaseFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    @InjectView(R.id.swipe)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @InjectView(R.id.list)
    RecyclerView mRecyclerView;
    @Inject
    protected LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(android.R.color.holo_orange_light, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_red_light);
        mRecyclerView.setAdapter(getAdapter());
        mSwipeRefreshLayout.setRefreshing(true);
        load();
    }

    public abstract RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter();

    @Override
    public void onRefresh() {
        load();
    }

    public abstract void load();

    public void refreshFinish() {
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
