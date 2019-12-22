package com.jack.mbolang.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jack.mbolang.R;
import com.jack.mbolang.ViewImage;
import com.jack.mbolang.model.Wisata;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {



    private Context context;
    private ArrayList<Wisata> galleryList;

    public GalleryAdapter(Context context, ArrayList<Wisata> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.img_grid, parent, false);
        GalleryAdapter.MyViewHolder viewHolder = new GalleryAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Wisata gallery = galleryList.get(position);
        ImageView imageView = holder.imageView;
            Glide.with(context)
                .load(gallery.getImg_url())
                .apply(new RequestOptions().override(200, 200))
                .into(imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent dataImage = new Intent(context, ViewImage.class);
                dataImage.putExtra(ViewImage.EXTRA_IMAGE, galleryList.get(position));
                context.startActivity(dataImage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout grid;
        private ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            grid = itemView.findViewById(R.id.)
            imageView = itemView.findViewById(R.id.img_grid);

        }
    }

}

