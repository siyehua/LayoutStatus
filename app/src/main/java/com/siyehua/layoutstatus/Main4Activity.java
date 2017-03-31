package com.siyehua.layoutstatus;

import android.os.Bundle;

import com.siyehua.layoutstatus.widget.LayoutStatusControl;

public class Main4Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //id相互依赖问题
        //当被替换的view的其他的view有相互依赖问题时
        //替换不会影响当前结构
        lyControl = new LayoutStatusControl(this, R.id.tv_content);
        handler.sendEmptyMessageDelayed(1, 5000);
    }
}
