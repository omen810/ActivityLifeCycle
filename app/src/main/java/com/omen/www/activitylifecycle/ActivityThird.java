package com.omen.www.activitylifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityThird extends AppCompatActivity {
    private Button mButtonThirdBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_third);
        mButtonThirdBack=(Button)findViewById(R.id.activity_third_btn_back);
        mButtonThirdBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("thirdBack","33333333333");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
