package com.example.testapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageviewActivity extends AppCompatActivity {

    private static final String TAG = "ImageviewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);

        Intent intent = getIntent();
        Bitmap bitmap;
        //bitmap = (Bitmap)intent.getExtras().get("data"); //setzt Bitmap auf low-res thumbnail
        //imageView.setImageBitmap(bitmap);

        Uri imageUri = intent.getParcelableExtra(MainActivity.EXTRA_URI);
        getContentResolver().notifyChange(imageUri, null);
        ContentResolver contentResolver = getContentResolver();

        try {
            bitmap = android.provider.MediaStore.Images.Media.getBitmap(contentResolver, imageUri);
            imageView.setImageBitmap(bitmap);
        } catch (IOException ioe) {
            Toast.makeText(this, "Could not load high res-version of the image.", Toast.LENGTH_LONG).show();
            Log.e(TAG, ioe.toString());
        }
    }
}
