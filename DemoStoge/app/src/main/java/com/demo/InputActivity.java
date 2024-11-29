package com.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputActivity extends AppCompatActivity {

    EditText input_title,input_author;
    Button submit;
    ImageView inputIcon;
    private static final String DATABASE_NAME = "Store.db";
    private static final int DATABASE_VERSION = 1;

    DBHelper dbHelper = new DBHelper(InputActivity.this,DATABASE_NAME,null,DATABASE_VERSION);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        input_author=findViewById(R.id.inputAuthor);
        input_title=findViewById(R.id.inputTitle);
        submit=findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(input_title.getText().toString())){
                    input_title.setError("Nhap ten truyen");
                    return;
                }else if(TextUtils.isEmpty(input_author.getText().toString())){
                    input_author.setError("Nhap ten tac gia");
                    return;
                }else if(inputIcon!= null){
                    uploadToSQLite(inputIcon);
                    return;
                }else {
                    Toast.makeText(InputActivity.this, "Nhap hinh anh", Toast.LENGTH_SHORT).show();
                }
            }

            private void uploadToSQLite(ImageView inputIcon) {
                dbHelper.insert(
                        imageviewToByte(inputIcon),
                        input_title.getText().toString().trim(),
                        input_author.getText().toString().trim()
                );
            }
            private byte[] imageviewToByte(ImageView inputIcon) {
                Bitmap bitmap = ((BitmapDrawable)inputIcon.getDrawable()).getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
                byte[] byteArray = stream.toByteArray();
                return byteArray;
            }
        });

        inputIcon=findViewById(R.id.inputImage);
        inputIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage(v);
            }
        });
    }
    private void selectImage(View view){
        Intent gallery = new Intent(Intent.ACTION_GET_CONTENT);
        gallery.setType("image/*");
        startActivityForResult(gallery,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2&& resultCode==RESULT_OK&&data!=null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputIcon.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}