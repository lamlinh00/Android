package com.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallActivity extends AppCompatActivity {

    ImageView imgIcon;
    TextView dTitle,dAuthor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detall);

        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Category category = (Category) bundle.get("abc");

        imgIcon = findViewById(R.id.dImage);
        dAuthor = findViewById(R.id.dAuthor);
        dTitle= findViewById(R.id.dTitle);


        byte[] iconImage = category.getIcon();
        Bitmap bitmap= BitmapFactory.decodeByteArray(iconImage,0,iconImage.length);
        imgIcon.setImageBitmap(bitmap);//giai ma byte--> bitmap

        dTitle.setText(category.getTitle());
        dAuthor.setText(category.getAuthor());
    }
}