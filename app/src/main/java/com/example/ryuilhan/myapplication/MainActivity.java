package com.example.ryuilhan.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout LL2;
    LinearLayout LL3;
    LinearLayout LL4;
    LinearLayout LL5;
    FrameLayout FL1;

    Switch SW;
    Chronometer CM;

    EditText ET1;
    EditText ET2;
    EditText ET3;

    RadioGroup RG1;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;

    TextView TV5;
    TextView TV6;
    TextView TV7;

    String TV5Text;
    String TV6Text;
    String TV7Text;

    Button BT1;
    Button BT2;

    int sum = 0;
    double dc = 0.0;
    double total = 0;


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
                    CM.setTextColor(Color.parseColor("blue"));
                    FL1.setVisibility(View.VISIBLE);
                }else{
                    FL1.setVisibility(View.INVISIBLE);
                }
            }
        });

        ET1 = (EditText)findViewById(R.id.editText);
        ET2 = (EditText)findViewById(R.id.editText2);
        ET3 = (EditText)findViewById(R.id.editText3);
        TV5 = (TextView)findViewById(R.id.textView5);
        TV6 = (TextView)findViewById(R.id.textView6);
        TV7 = (TextView)findViewById(R.id.textView7);
        RB1 = (RadioButton)findViewById(R.id.radioButton);
        RB2 = (RadioButton)findViewById(R.id.radioButton2);
        RB3 = (RadioButton)findViewById(R.id.radioButton3);
        BT1 = (Button)findViewById(R.id.button);

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ad = Double.parseDouble(ET1.getText().toString());
                double ad2 = Double.parseDouble(ET2.getText().toString());
                double ch = Double.parseDouble(ET3.getText().toString());
                double total2=0.0;
                sum = Integer.parseInt(ET1.getText().toString()) + Integer.parseInt(ET2.getText().toString()) + Integer.parseInt(ET3.getText().toString());
                total = (ad*15000)+(ad2*12000)+(ch*8000);
                TV5.setText(TV5.getText()+Integer.toString(sum));
                total2 = total;

                if(RB1.isChecked()){
                    total=total*0.95;
                    TV7.setText(TV7.getText()+Double.toString(total));
                    dc = total2-total;
                    TV6.setText(TV6.getText()+Double.toString(dc));
                }else if (RB2.isChecked()){
                    total=total*0.9;
                    TV7.setText(TV7.getText()+Double.toString(total));
                    dc = total2-total;
                    TV6.setText(TV6.getText()+Double.toString(dc));
                }else if(RB3.isChecked()){
                    total=total*0.8;
                    TV7.setText(TV7.getText()+Double.toString(total));
                    dc = total2-total;
                    TV6.setText(TV6.getText()+Double.toString(dc));
                }
            }
        });

        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
