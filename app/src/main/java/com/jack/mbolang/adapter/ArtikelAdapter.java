package com.jack.mbolang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jack.mbolang.DetailArtikel;
import com.jack.mbolang.R;
import com.jack.mbolang.model.Artikel;

import java.util.List;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.MyViewHolder>{

private Context mContext;
private List<Artikel> mData;

public ArtikelAdapter(Context mContext,List<Artikel> mData){
        this.mContext=mContext;
        this.mData=mData;
        }

@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i){

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.row_article,viewGroup,false);
final MyViewHolder iniholder=new MyViewHolder(v);

        return iniholder;
        }

    @Override
public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i){
        myViewHolder.tv_nama.setText(mData.get(i).getArTitle());
//        myViewHolder.tv_lokasi.setText(mData.get(i).getLokasi());
final Artikel iniwisata=mData.get(i);
        Glide.with(myViewHolder.baris_item.getContext())
        .load(iniwisata.getArImage())
        .apply(new RequestOptions().override(200,300))
        .into(myViewHolder.img_cover);

        myViewHolder.baris_item.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        Context context=v.getContext();
        Intent inidetail=new Intent(context, DetailArtikel.class);
        inidetail.putExtra(DetailArtikel.EXTRA_WISATA,mData.get(i));
        inidetail.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(inidetail);
        }
        });
        }

@Override
public int getItemCount(){
        return mData.size();
        }


public static class MyViewHolder extends RecyclerView.ViewHolder {
    private RelativeLayout baris_item;
    private TextView tv_nama, tv_lokasi, tv_deskripsi, tv_Rating;
    private ImageView img_cover;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        baris_item = itemView.findViewById(R.id.baris_artikel);
        tv_nama = itemView.findViewById(R.id.tv_article_title);
        img_cover = itemView.findViewById(R.id.img_article);
    }
}
}

