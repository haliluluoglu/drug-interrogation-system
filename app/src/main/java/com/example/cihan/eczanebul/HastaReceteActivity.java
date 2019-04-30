package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class HastaReceteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_recete);
        ArrayList<String> list = getIntent().getStringArrayListExtra("list");

        RecyclerView rv=(RecyclerView)findViewById(R.id.receteBulRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ReceteBulAdapter adapter = new ReceteBulAdapter(this,getIntent().getStringArrayListExtra("list"));
        rv.setAdapter(adapter);
    }
}
