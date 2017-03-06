package com.lzy.networkstatus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lzy.netstatus.ConnectivityType;
import com.lzy.netstatus.NetWorkStateCallBack;
import com.lzy.netstatus.NetWorkStateManager;
import com.lzy.netstatus.NetworkHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NetWorkStateManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = NetWorkStateManager.getInstance(getApplicationContext());
        findViewById(R.id.btn_net).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //获取一次网络状态
        ConnectivityType connectedType = manager.getNetWorkState();
        //实时获取网络状态
        manager.getRealTimeNetWorkState(new NetWorkStateCallBack() {
            @Override
            public void netWorkState(ConnectivityType type) {
                Toast.makeText(MainActivity.this, type.getType(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
