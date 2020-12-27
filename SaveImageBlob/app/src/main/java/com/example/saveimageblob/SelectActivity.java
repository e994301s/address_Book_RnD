package com.example.saveimageblob;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import DBHelper.DBHelper;
import Utils.Utils;

public class SelectActivity extends AppCompatActivity {

    private static final int SELECT_PHOTO = 7777;
    ImageView imageView;
    Button btn_choose, bnt_save;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        imageView = findViewById(R.id.image_view);
        btn_choose = findViewById(R.id.select_image);
        bnt_save = findViewById(R.id.save_image);

        dbHelper = new DBHelper(this);

        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, SELECT_PHOTO);

            }
        });

        bnt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

                AlertDialog.Builder builder = new AlertDialog.Builder(SelectActivity.this);
                builder.setTitle("Enter name");

                EditText editText = new EditText(SelectActivity.this);
                builder.setView(editText);

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!TextUtils.isEmpty(editText.getText().toString())){
                            dbHelper.addBitmap(Utils.getBytes(bitmap));
                        }else {

                        }
                    }
                });
                builder.show();

            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SELECT_PHOTO && resultCode == RESULT_OK && data != null){
            Uri pickedImage = data.getData();

            imageView.setImageURI(pickedImage);

            bnt_save.setEnabled(true);
        }

    }
}