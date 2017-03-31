package com.siyehua.layoutstatus;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.siyehua.layoutstatus.widget.LayoutStatusControl;

public class Main1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //id 是你想替换的view的id
        lyControl = new LayoutStatusControl(this, R.id.tv_content);
    }


    /**
     * 切换不同的布局
     *
     * @param view
     */
    public void click1(View view) {
        i++;
        if (i > 4) {
            i = 1;
        }
        handler2.sendEmptyMessage(i);
    }

    /**
     * 设置空数据样式
     *
     * @param view
     */
    public void click2(View view) {
        //可以传layout id或 一个view
        lyControl.setEmptyView(R.layout.view_nodata);

    }

    public void click3(View view) {
        //为空数据样式设置监听
        //同样也可以为加载错误设置监听
        lyControl.setEmptyListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main1Activity.this, "空数据监听", Toast.LENGTH_SHORT).show();
            }
        }, -1);
        //-1表示监听整个空数据样式布局,假设仅想监听某个按钮,则传对应的id即可.
    }

    private int i = 0;
    public Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    lyControl.showLoadingView();
                    break;
                case 2:
                    lyControl.showEmptyView();
                    break;
                case 3:
                    lyControl.showErrorView();
                    break;
                case 4:
                    lyControl.showSuccessView();
                    break;
            }
        }
    };
}
