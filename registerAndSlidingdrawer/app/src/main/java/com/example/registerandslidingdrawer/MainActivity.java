package com.example.registerandslidingdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button add_view, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_view = findViewById(R.id.addTelNoButton);

        add_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sub n_layout = new Sub(getApplicationContext());
                LinearLayout con = (LinearLayout)findViewById(R.id.con);
                con.addView(n_layout);
            }
        });

    }
}