# NetworkStatus
一个网络状态获取的类库
定义如下4中网络类型 ：
---
UNKNOWN("未知网络")；<br>
MOBILE("移动蜂窝网络");<br>
WIFI("wifi网络");<br>
OFFLINE("网络连接已断开");
获取网络状态的两种方法：
---
###1、临时获取一次网络状态：
```Java
NetWorkStateManager manager = NetWorkStateManager.getInstance(getApplicationContext());
ConnectivityType connectedType = manager.getNetWorkState();
```
###2、实时获取网络状态：
```Java
    //实时获取网络状态
        manager.getRealTimeNetWorkState(new NetWorkStateCallBack() {
            @Override
            public void netWorkState(ConnectivityType type) {
                Toast.makeText(MainActivity.this, type.getType(), Toast.LENGTH_SHORT).show();
            }
        });
```
