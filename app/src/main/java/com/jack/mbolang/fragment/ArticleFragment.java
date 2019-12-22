package com.jack.mbolang.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.jack.mbolang.adapter.ArtikelAdapter;
import com.jack.mbolang.adapter.WisataAdapter;
import com.jack.mbolang.model.Artikel;
import com.jack.mbolang.model.Wisata;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<Artikel> artikel;
    TextView cekKoneksi;
    ProgressBar progressBar;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("data_artikel");

    public ArticleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_article, container, false);
        recyclerView = v.findViewById(R.id.rv_article);
        getDataArticle();
        return v;
    }

    private void getDataArticle() { ValueEventListener valueEventListener= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            artikel = new ArrayList<>();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                Artikel mArtikel =snapshot.getValue(Artikel.class);

                artikel.add(mArtikel);
            }
            ArtikelAdapter artikelAdapter = new ArtikelAdapter(getContext(), artikel);
            if (artikelAdapter != null){
//                progressBar.setVisibility(View.GONE);
//                cekKoneksi.setVisibility(View.GONE);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(artikelAdapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
        reference.addValueEventListener(valueEventListener);
    }
}
