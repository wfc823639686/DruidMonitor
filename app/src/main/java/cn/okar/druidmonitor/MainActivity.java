package cn.okar.druidmonitor;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.google.inject.Inject;

import cn.okar.druidmonitor.common.BaseActivity;
import cn.okar.druidmonitor.fragments.IndexFragment;
import cn.okar.druidmonitor.fragments.SpringStatFragment;

public class MainActivity extends BaseActivity {

    @Inject
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.replace(R.id.content, new SpringStatFragment(), "index");
        trans.commitAllowingStateLoss();
    }

}
