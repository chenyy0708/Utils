package com.cyy.cyyutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cyy.utils.MD5Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(MD5Utils.getMD5("是服务服务"));
    }
}
