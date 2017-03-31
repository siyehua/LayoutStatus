package com.siyehua.layoutstatus;

import android.os.Bundle;

import com.siyehua.layoutstatus.widget.LayoutStatusControl;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //当父布局只有单个view时,
        //替换不受任何影响
        lyControl = new LayoutStatusControl(this, R.id.tv_content);
        handler.sendEmptyMessageDelayed(1, 5000);
    }
}
