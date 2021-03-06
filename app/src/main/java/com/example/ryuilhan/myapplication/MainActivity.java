package com.example.ryuilhan.myapplication;

import android.graphics.Color;
import android.media.Image;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout LL2;
    LinearLayout LL3;
    LinearLayout LL4;
    LinearLayout LL5;
    FrameLayout FL1;

    ImageView IV1;

    Switch SW;
    Chronometer CM;

    EditText ET1;
    EditText ET2;
    EditText ET3;

    RadioGroup RG1;
    RadioButton RB1;
    RadioButton RB2;
    RadioButton RB3;
    RadioButton RB4;
    RadioButton RB5;

    TextView TV5;
    TextView TV6;
    TextView TV7;

    Button BT1;
    Button BT2;


    CalendarView CV1;
    TimePicker TP1;

    String hour;
    String min;
    String year;
    String day;
    String mon;
    boolean isTP = false;
    boolean isCal = false;
    boolean isStart = false;
    Button BT3;
    Button BT4;

    FrameLayout FL2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LL2 = (LinearLayout) findViewById(R.id.LinearLayout2);
        LL3 = (LinearLayout) findViewById(R.id.LinearLayout3);
        LL4 = (LinearLayout) findViewById(R.id.LinearLayout4);
        LL5 = (LinearLayout) findViewById(R.id.LinearLayout5);

        CM = (Chronometer) findViewById(R.id.chronometer1);
        SW = (Switch) findViewById(R.id.switch1);
        FL1 = (FrameLayout) findViewById(R.id.FrameLAyout1);
        SW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (SW.isChecked()) {
                    CM.setBase(SystemClock.elapsedRealtime());
                    CM.start();
                    CM.setTextColor(Color.parseColor("blue"));
                    FL1.setVisibility(View.VISIBLE);
                } else {
                    FL1.setVisibility(View.INVISIBLE);
                    ET1.setText("");
                    ET2.setText("");
                    ET3.setText("");
                    isStart = false;
                    RB1.setChecked(true);
                    TV5.setText("총 명수 : ");
                    TV6.setText("할인금액 : ");
                    TV7.setText("결제금액 : ");
                    CM.setTextColor(Color.parseColor("black"));
                    CM.setBase(SystemClock.elapsedRealtime());
                    CM.stop();
                }
            }
        });

        ET1 = (EditText) findViewById(R.id.editText);
        ET2 = (EditText) findViewById(R.id.editText2);
        ET3 = (EditText) findViewById(R.id.editText3);
        TV5 = (TextView) findViewById(R.id.textView5);
        TV6 = (TextView) findViewById(R.id.textView6);
        TV7 = (TextView) findViewById(R.id.textView7);
        RB1 = (RadioButton) findViewById(R.id.radioButton);
        RB2 = (RadioButton) findViewById(R.id.radioButton2);
        RB3 = (RadioButton) findViewById(R.id.radioButton3);
        BT1 = (Button) findViewById(R.id.button);

        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ET1.getText() == null || ET1.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "인원 입력", Toast.LENGTH_SHORT).show();
                } else if (ET2.getText() == null || ET1.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "인원 입력", Toast.LENGTH_SHORT).show();
                } else if (ET3.getText() == null || ET1.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "인원 입력", Toast.LENGTH_SHORT).show();
                } else {
                    isStart = true;
                    double ad = Double.parseDouble(ET1.getText().toString());
                    double ad2 = Double.parseDouble(ET2.getText().toString());
                    double ch = Double.parseDouble(ET3.getText().toString());
                    double total2 = 0.0;
                    int sum = 0;
                    double dc = 0.0;
                    double total = 0;
                    String a = "총 명수 : ";
                    String b = "할인금액 : ";
                    String c = "결제금액 : ";
                    sum = Integer.parseInt(ET1.getText().toString()) + Integer.parseInt(ET2.getText().toString()) + Integer.parseInt(ET3.getText().toString());
                    total = (ad * 15000) + (ad2 * 12000) + (ch * 8000);
                    TV5.setText(a + Integer.toString(sum));
                    total2 = total;

                    if (RB1.isChecked()) {
                        total = total * 0.95;
                        TV7.setText(c + Double.toString(total));
                        dc = total2 - total;
                        TV6.setText(b + Double.toString(dc));

                    } else if (RB2.isChecked()) {
                        total = total * 0.9;
                        TV7.setText(c + Double.toString(total));
                        dc = total2 - total;
                        TV6.setText(b + Double.toString(dc));
                    } else if (RB3.isChecked()) {
                        total = total * 0.8;
                        TV7.setText(c + Double.toString(total));
                        dc = total2 - total;
                        TV6.setText(b + Double.toString(dc));
                    }
                }
            }
        });

        BT2 = (Button) findViewById(R.id.button2);

        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL3.setVisibility(View.INVISIBLE);
                LL5.setVisibility(View.VISIBLE);
            }
        });
        RG1 = (RadioGroup) findViewById(R.id.radioGroup1);
        IV1 = (ImageView) findViewById(R.id.imageView);

        RG1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                IV1.setImageResource(R.drawable.a);
                if (RB1.isChecked()) {
                    IV1.setImageResource(R.drawable.a);
                } else if (RB2.isChecked()) {
                    IV1.setImageResource(R.drawable.b);
                } else if (RB3.isChecked()) {
                    IV1.setImageResource(R.drawable.c);
                }
            }
        });

        TP1 = (TimePicker) findViewById(R.id.timePicker);
        CV1 = (CalendarView) findViewById(R.id.calendarView);
        RB4 = (RadioButton) findViewById(R.id.radioButton4);
        RB5 = (RadioButton) findViewById(R.id.radioButton5);
        FL2 = (FrameLayout) findViewById(R.id.FrameLaout2);

        RB4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (RB4.isChecked()) {
                    CV1.setVisibility(View.VISIBLE);
                    TP1.setVisibility(View.INVISIBLE);
                }
            }
        });
        RB5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (RB5.isChecked()) {
                    TP1.setVisibility(View.VISIBLE);
                    CV1.setVisibility(View.INVISIBLE);
                }
            }
        });


        BT3 = (Button) findViewById(R.id.button3);
        BT4 = (Button) findViewById(R.id.button4);
        TP1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour = i + "시 ";
                min = i1 + "분 ";
                isTP = true;
            }
        });

        CV1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                year = i + "년 ";
                mon = i1 + "월 ";
                day = i2 + "일 ";
                isCal = true;
            }
        });

        BT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStart == true) {
                    CM.stop();
                    String tv1 = year + mon + day + hour + min + "예약";
                    Toast.makeText(getApplicationContext(), tv1, Toast.LENGTH_SHORT).show();
                }else if(isStart == false){
                    Toast.makeText(getApplicationContext(), "인원예약먼저 하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LL3.setVisibility(View.VISIBLE);;
                LL5.setVisibility(View.INVISIBLE);
            }
        });
    }
}
