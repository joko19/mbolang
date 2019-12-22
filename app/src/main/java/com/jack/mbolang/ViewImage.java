package com.jack.mbolang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jack.mbolang.model.Wisata;

public class ViewImage extends AppCompatActivity {
    public static final String EXTRA_IMAGE = "extra_image";
    public ImageView imageView;
    public Wisata gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        imageView = findViewById(R.id.viewImage);
        gallery = getIntent().getParcelableExtra(EXTRA_IMAGE);
        Glide.with(ViewImage.this)
                .load(gallery.getImg_url())
                .into(imageView);
    }
}
