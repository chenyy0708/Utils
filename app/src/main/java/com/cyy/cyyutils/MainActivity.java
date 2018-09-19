package com.cyy.cyyutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cyy.utils.MD5Utils;

import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            System.out.println(MD5Utils.getMD5("是服务服务"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
