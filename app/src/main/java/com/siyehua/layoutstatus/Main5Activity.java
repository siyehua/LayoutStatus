package com.siyehua.layoutstatus;

import android.os.Bundle;

import com.siyehua.layoutstatus.widget.LayoutStatusControl;

public class Main5Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //view出现层级关系时,
        //例如RelativeLayout与FrameLayout会出现层级问题
        //替换后前后层级不变
        lyControl = new LayoutStatusControl(this, R.id.tv_content);
        handler.sendEmptyMessageDelayed(1, 5000);
    }
}
