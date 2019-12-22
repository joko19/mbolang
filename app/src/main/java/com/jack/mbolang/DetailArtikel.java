package com.jack.mbolang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jack.mbolang.model.Artikel;
import com.jack.mbolang.model.Wisata;

public class DetailArtikel extends AppCompatActivity {
    Artikel dataArtikel;
    private TextView tv_title, tv_content;
    private ImageView img_cover;
    public static final String EXTRA_WISATA = "extra_artikel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artikel);

        dataArtikel =getIntent().getParcelableExtra(EXTRA_WISATA);
        getSupportActionBar().setTitle("Detail");
        inisialisasi();
        setData();

    }

    private void inisialisasi() {
        tv_title = findViewById(R.id.ardet_title);
        tv_content = findViewById(R.id.ardet_konten);
        img_cover = findViewById(R.id.ardet_img);
    }
    private void setData() {
        tv_title.setText(dataArtikel.getArTitle());
        tv_content.setText(dataArtikel.getArContent());
        Glide.with(DetailArtikel.this)
                .load(dataArtikel.getArImage())
                .into(img_cover);
    }

}
