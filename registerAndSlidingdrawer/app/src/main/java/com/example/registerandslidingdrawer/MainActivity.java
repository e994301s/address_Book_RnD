package com.example.registerandslidingdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add_view, ok;
    EditText telM, tel1, tel2, tel3, tel4;

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
                add_view.setVisibility(View.INVISIBLE);
            }
        });

        ok = findViewById(R.id.registerButton);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telM = findViewById(R.id.registerMainTelNo);
                tel1 = findViewById(R.id.addTelNoET1);
                tel2 = findViewById(R.id.addTelNoET2);
                tel3 = findViewById(R.id.addTelNoET3);
                tel4 = findViewById(R.id.addTelNoET4);

                String telMa =  telM.getText().toString();
                String tel1a =  tel1.getText().toString();
                String tel2a =  tel2.getText().toString();
                String tel3a =  tel3.getText().toString();
                String tel4a =  tel4.getText().toString();
                Toast.makeText(MainActivity.this, tel4a, Toast.LENGTH_SHORT).show();
            }
        });

    }
}