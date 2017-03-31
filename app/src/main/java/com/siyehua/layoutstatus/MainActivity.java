package com.siyehua.layoutstatus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void use(View view) {
        startActivity(new Intent(this, Main1Activity.class));

    }
    public void one(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }

    public void moreLinearLayout(View view) {
        startActivity(new Intent(this, Main3Activity.class));


    }

    public void moreId(View view) {
        startActivity(new Intent(this, Main4Activity.class));

    }

    public void moreLevel(View view) {
        startActivity(new Intent(this, Main5Activity.class));

    }
}
