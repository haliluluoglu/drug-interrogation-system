package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class HastaYakinEczaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_yakin_eczane);
        RecyclerView rv = (RecyclerView)findViewById(R.id.eczaneRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(HastaYakinEczaneActivity.this));

    }
}
