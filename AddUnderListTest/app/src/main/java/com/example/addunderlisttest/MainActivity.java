package com.example.addunderlisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int DYNAMIC_VIEW_ID2  = 0x7000;
    private final int MAX_DYNAMIC_VIEW = 99;
    private Button pushButton;
    private Button       popButton;
    private TextView statusText;
    private TextView     infoText;
    private LinearLayout dynamicLayout;
    private int          numButton = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushButton = (Button)findViewById(R.id.pushButton);
        popButton  = (Button)findViewById(R.id.popButton);
        statusText = (TextView)findViewById(R.id.statusText);
        infoText   = (TextView)findViewById(R.id.infoText);

        pushButton.setOnClickListener((View.OnClickListener) MainActivity.this);
        popButton.setOnClickListener((View.OnClickListener) MainActivity.this);



        dynamicLayout = (LinearLayout)findViewById(R.id.dynamicArea);
    }

    private void pushButton() {     // Tv추가 버튼
        if ( numButton >= MAX_DYNAMIC_VIEW ) {
            return;
        }
        String tv1 = "Text";


        TextView txtV = new TextView(this);
        txtV.setId(DYNAMIC_VIEW_ID2 + numButton);
        txtV.setText(tv1 + numButton);
        txtV.setGravity(Gravity.RIGHT);
        dynamicLayout.addView(txtV, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        infoText.setText("Selected Button ID: " + DYNAMIC_VIEW_ID2 + numButton);
    }
}