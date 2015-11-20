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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.okar.druidmonitor.R;
import cn.okar.druidmonitor.common.BaseFragment;
import cn.okar.druidmonitor.common.HttpClient;
import cn.okar.druidmonitor.model.SpringStat;
import roboguice.inject.InjectView;

/**
 * Created by wangfengchen on 15/11/19.
 */
public class SpringStatFragment extends StatBaseFragment {

    SpringStat[] springStats;

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(inflater.inflate(R.layout.item_spring_stat, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            myViewHolder.bindView(springStats[i]);
        }

        @Override
        public int getItemCount() {
            return springStats==null?0:springStats.length;
        }
    }

    MyAdapter mAdapter = new MyAdapter();

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView classTV,
                methodTV,
                runningCountTV,
                concurrentMaxTV,
                executeCountTV,
                executeErrorCountTV,
                executeTimeMillisTV,
                jdbcCommitCountTV,
                jdbcRollbackCountTV,
                jdbcPoolConnectionOpenCountTV,
                jdbcPoolConnectionCloseCountTV,
                jdbcResultSetOpenCountTV,
                jdbcResultSetCloseCountTV,
                jdbcExecuteCountTV,
                jdbcExecuteErrorCountTV,
                jdbcExecuteTimeMillisTV,
                jdbcFetchRowCountTV,
                jdbcUpdateCountTV,
                lastErrorTV,
                lastErrorTimeTV,
                histogramTV;
        public MyViewHolder(View itemView) {
            super(itemView);
            classTV = (TextView) itemView.findViewById(R.id.item_spring_class_text);
            methodTV = (TextView) itemView.findViewById(R.id.item_spring_method_text);
            runningCountTV = (TextView) itemView.findViewById(R.id.item_spring_runningcount_text);
            concurrentMaxTV = (TextView) itemView.findViewById(R.id.item_spring_concurrentmax_text);
            executeCountTV = (TextView) itemView.findViewById(R.id.item_spring_executecount_text);
            executeErrorCountTV = (TextView) itemView.findViewById(R.id.item_spring_executeerrorcount_text);
            executeTimeMillisTV = (TextView) itemView.findViewById(R.id.item_spring_executetimemillis_text);
            jdbcCommitCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbccommitcount_text);
            jdbcRollbackCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcrollbackcount_text);
            jdbcPoolConnectionOpenCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcpoolconnectionopencount_text);
            jdbcPoolConnectionCloseCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcpoolconnectionclosecount_text);
            jdbcResultSetOpenCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcresultsetopencount_text);
            jdbcResultSetCloseCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcresultsetclosecount_text);
            jdbcExecuteCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcexecutecount_text);
            jdbcExecuteErrorCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcexecuteerrorcount_text);
            jdbcExecuteTimeMillisTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcexecutetimemillis_text);
            jdbcFetchRowCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcfetchrowcount_text);
            jdbcUpdateCountTV = (TextView) itemView.findViewById(R.id.item_spring_jdbcupdatecount_text);
            lastErrorTV = (TextView) itemView.findViewById(R.id.item_spring_lasterror_text);
            lastErrorTimeTV = (TextView) itemView.findViewById(R.id.item_spring_lasterrortime_text);
            histogramTV = (TextView) itemView.findViewById(R.id.item_spring_histogram_text);
        }

        void bindView(SpringStat item) {
            classTV.setText(item.getClassName());
            methodTV.setText(item.getMethod());
            runningCountTV.setText(""+item.getRunningCount());
            concurrentMaxTV.setText(""+item.getConcurrentMax());
            executeCountTV.setText(""+item.getExecuteCount());
            executeErrorCountTV.setText(""+item.getExecuteErrorCount());
            executeTimeMillisTV.setText(""+item.getExecuteTimeMillis());
            jdbcCommitCountTV.setText(""+item.getJdbcCommitCount());
            jdbcRollbackCountTV.setText(""+item.getJdbcRollbackCount());
            jdbcPoolConnectionOpenCountTV.setText(""+item.getJdbcPoolConnectionOpenCount());
            jdbcPoolConnectionCloseCountTV.setText(""+item.getJdbcPoolConnectionCloseCount());
            jdbcResultSetOpenCountTV.setText(""+item.getJdbcResultSetOpenCount());
            jdbcResultSetCloseCountTV.setText(""+item.getJdbcResultSetCloseCount());
            jdbcExecuteCountTV.setText(""+item.getJdbcExecuteCount());
            jdbcExecuteErrorCountTV.setText(""+item.getJdbcExecuteErrorCount());
            jdbcExecuteTimeMillisTV.setText(""+item.getJdbcExecuteTimeMillis());
            jdbcFetchRowCountTV.setText(""+item.getJdbcFetchRowCount());
            jdbcUpdateCountTV.setText(""+item.getJdbcUpdateCount());
            lastErrorTV.setText(item.getLastError());
            lastErrorTimeTV.setText(item.getLastErrorTime());
            histogramTV.setText(""+item.getHistogram());
        }
    }

    @Override
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        return mAdapter;
    }

    public void load() {
        HttpClient.getInstance().sprintStat(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.d("load", "response " + response);
                super.onSuccess(response);
                if (response.optInt("ResultCode") != 1) {
                    Log.d("load", "失败");
                    return;
                }
                String json = response.optJSONArray("Content").toString();
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                springStats = gson.fromJson(json, SpringStat[].class);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                refreshFinish();
            }
        });
    }
}
