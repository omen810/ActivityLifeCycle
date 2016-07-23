package com.omen.www.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public static final String BOOK_OF_CATEGORY_PHYSICAL = "bookNameCategoryPhysical";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate执行了");
        Button button = (Button) findViewById(R.id.activity_main_btn_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Toast.makeText(MainActivity.this,"you are about to see the second Activity",Toast.LENGTH_LONG).show();*/
                String data = "你好，第二个活动（Activity）！";
                int num = 999;
                EditText editText = (EditText) findViewById(R.id.activity_main_et_name);
                Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
                intent.putExtra("extra_data", data);
                intent.putExtra("num", num);
                intent.putExtra(BOOK_OF_CATEGORY_PHYSICAL, editText.getText().toString());
//                startActivity(intent);
                /*第二个参数为requestCode，在启动多个Activity时，用于标识不同的Activity*/
                startActivityForResult(intent, 1);
            }
        });

    }

    /*由于我们是使用startActivityForResult（）方法来启动ActivitySecond的*/
    /*在ActivitySecond被销毁后，会回调上一个活动的onActivityResult()方法*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String sendName = data.getStringExtra("backname");
                    Toast.makeText(this, sendName, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}

