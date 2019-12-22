package com.jack.mbolang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jack.mbolang.model.Wisata;

public class DetailWisataAcivity extends AppCompatActivity {
    Wisata dataWisata;
    private TextView tv_nama, tv_rating, tv_konten;
    private ImageView img_cover;
    public static final String EXTRA_WISATA = "extra_wisata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        dataWisata =getIntent().getParcelableExtra(EXTRA_WISATA);
        getSupportActionBar().setTitle("Detail Wisata");
        inisialisasi();
        setData();

    }

    private void inisialisasi() {
        tv_nama = findViewById(R.id.tv_detail_title);
        tv_rating = findViewById(R.id.tv_detail_rating);
        tv_konten = findViewById(R.id.tv_detail_description);
        img_cover = findViewById(R.id.img_detail_wisata);
    }

    private void setData() {
        tv_nama.setText(dataWisata.getName());
        tv_rating.setText(dataWisata.getRating() + "/10");
        tv_konten.setText(dataWisata.getDescription());
        Glide.with(DetailWisataAcivity.this)
                .load(dataWisata.getImg_url())
                .into(img_cover);
    }
}