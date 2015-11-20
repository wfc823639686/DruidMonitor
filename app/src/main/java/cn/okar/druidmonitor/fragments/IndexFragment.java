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
 * Created by wangfengchen on 15/11/19.
 */
public class IndexFragment extends StatBaseFragment {

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private JSONObject jsonData;

        public void setJsonData(JSONObject data) {
            jsonData = data;
            notifyDataSetChanged();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(inflater.inflate(R.layout.item_sample_text, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if(jsonData==null) return;
            MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
            switch (i) {
                case 0:
                    myViewHolder.labelTV.setText("版本");
                    myViewHolder.textTV.setText(jsonData.optString("Version"));
                    break;
                case 1:
                    myViewHolder.labelTV.setText("驱动");
                    myViewHolder.textTV.setText(jsonData.optString("Drivers"));
                    break;
                case 2:
                    myViewHolder.labelTV.setText("是否允许重置");
                    myViewHolder.textTV.setText(jsonData.optString("ResetEnable"));
                    break;
                case 3:
                    myViewHolder.labelTV.setText("重置次数");
                    myViewHolder.textTV.setText(jsonData.optString("ResetCount"));
                    break;
                case 4:
                    myViewHolder.labelTV.setText("java版本");
                    myViewHolder.textTV.setText(jsonData.optString("JavaVersion"));
                    break;
                case 5:
                    myViewHolder.labelTV.setText("jvm名称");
                    myViewHolder.textTV.setText(jsonData.optString("JavaVMName"));
                    break;
                case 6:
                    myViewHolder.labelTV.setText("classpath路径");
                    myViewHolder.textTV.setText(jsonData.optString("JavaClassPath"));
                    break;
                case 7:
                    myViewHolder.labelTV.setText("启动时间");
                    myViewHolder.textTV.setText(jsonData.optString("StartTime"));
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return jsonData==null?0:8;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }
    }

    MyAdapter mAdapter = new MyAdapter();

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView labelTV, textTV;
        public MyViewHolder(View itemView) {
            super(itemView);
            labelTV = (TextView) itemView.findViewById(R.id.item_label);
            textTV = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    @Override
    public RecyclerView.Adapter<? extends RecyclerView.ViewHolder> getAdapter() {
        return mAdapter;
    }

    public void load() {
        HttpClient.getInstance().indexStat(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONObject response) {
                Log.d("load", "response " + response);
                super.onSuccess(response);
                if (response.optInt("ResultCode") != 1) {
                    Log.d("load", "失败");
                    return;
                }
                mAdapter.setJsonData(response.optJSONObject("Content"));
            }

            @Override
            public void onFinish() {
                super.onFinish();
                refreshFinish();
            }
        });
    }
}
