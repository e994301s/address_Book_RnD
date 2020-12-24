package com.example.addphonenumbertest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "Test_Alert_Dialog";

    Button btn01;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn01 = (Button) findViewById(R.id.btn01);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);

                ad.setTitle("Title");       // 제목 설정
                ad.setMessage("Message");   // 내용 설정
                final EditText et = new EditText(MainActivity.this);
                ad.setView(et);


                // 확인 버튼 설정
                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"Yes Btn Click");
                        String value = et.getText().toString();
                        Log.v(TAG, value);


                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                // 중립 버튼 설정
                ad.setNeutralButton("What?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"Neutral Btn Click");
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                // 취소 버튼 설정
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.v(TAG,"No Btn Click");
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });

                // 창 띄우기
                ad.show();
            }
        });
    }
}
