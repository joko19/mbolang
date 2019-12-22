package com.jack.mbolang.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jack.mbolang.R;
import com.jack.mbolang.adapter.GalleryAdapter;
import com.jack.mbolang.model.Wisata;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<Wisata> dataGallery;
    private ProgressBar progressBar;
    private TextView cekkoneksi;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("data_wisata");

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = v.findViewById(R.id.rv_gallery);
        getDataImages();
        return v;
    }

    private void getDataImages() {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataGallery = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Wisata gallery = snapshot.getValue(Wisata.class);
                    dataGallery.add(gallery);
                }
                GalleryAdapter galleryAdapter = new GalleryAdapter(getContext(), dataGallery);
                if (galleryAdapter != null){
//                    progressBar.setVisibility(View.GONE);
//                    cekkoneksi.setVisibility(View.GONE);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
                    recyclerView.setAdapter(galleryAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
