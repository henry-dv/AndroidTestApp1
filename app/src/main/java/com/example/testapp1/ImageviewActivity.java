package com.example.testapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bitmap bitmap = (Bitmap)intent.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }
}
