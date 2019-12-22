package com.jack.mbolang.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import com.jack.mbolang.adapter.WisataAdapter;
import com.jack.mbolang.model.Wisata;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Wisata> dataWisata;
    TextView cekKoneksi;
    ProgressBar progressBar;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("data_wisata");

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
//        cekKoneksi = v.findViewById(R.id.tv_cek_koneksi);
//        progressBar = v.findViewById(R.id.progressBar);
        recyclerView = v.findViewById(R.id.rv_home);
//        getSupportActionBar().setTitle("Wisata Mojokerto");
        getData();

        // Inflate the layout for this fragment
        return v;
    }

    private void getData() { ValueEventListener valueEventListener= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            dataWisata = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                Wisata wisata =snapshot.getValue(Wisata.class);

                dataWisata.add(wisata);
            }
            WisataAdapter wisataAdapter = new WisataAdapter(getContext(), dataWisata);
            if (wisataAdapter != null){
//                progressBar.setVisibility(View.GONE);
//                cekKoneksi.setVisibility(View.GONE);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(wisataAdapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
        reference.addValueEventListener(valueEventListener);
    }
}
