package com.siyehua.layoutstatus;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.siyehua.layoutstatus.widget.LayoutStatusControl;

/**
 * Created by huangxuanke on 2017/3/31.
 */

public class BaseActivity extends AppCompatActivity {
    public LayoutStatusControl lyControl;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    lyControl.showLoadingView();
                    handler.sendEmptyMessageDelayed(2, 5000);
                    break;
                case 2:
                    lyControl.showEmptyView();
                    handler.sendEmptyMessageDelayed(3, 5000);
                    break;
                case 3:
                    lyControl.showErrorView();
                    handler.sendEmptyMessageDelayed(4, 5000);
                    break;
                case 4:
                    lyControl.showSuccessView();
                    handler.sendEmptyMessageDelayed(1, 5000);
                    break;
            }
        }
    };
}
