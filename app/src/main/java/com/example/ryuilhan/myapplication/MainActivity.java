package com.example.ryuilhan.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    LinearLayout LL2;
    LinearLayout LL3;
    LinearLayout LL4;
    LinearLayout LL5;
    FrameLayout FL1;

    Switch SW;
    Chronometer CM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LL2 = (LinearLayout)findViewById(R.id.LinearLayout2);
        LL3 = (LinearLayout)findViewById(R.id.LinearLayout3);
        LL4 = (LinearLayout)findViewById(R.id.LinearLayout4);
        LL5 = (LinearLayout)findViewById(R.id.LinearLayout5);

        CM = (Chronometer)findViewById(R.id.chronometer1);
        SW = (Switch)findViewById(R.id.switch1);
        FL1 = (FrameLayout)findViewById(R.id.FrameLAyout1);
        SW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(SW.isChecked()){
                    CM.setBase(SystemClock.elapsedRealtime());
                    CM.start();
                    FL1.setVisibility(View.VISIBLE);
                }else{
                    FL1.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
