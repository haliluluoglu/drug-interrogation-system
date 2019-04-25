package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

public class HastaYakinEczaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_yakin_eczane);

        RecyclerView rv = (RecyclerView)findViewById(R.id.eczaneRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(HastaYakinEczaneActivity.this));
        ArrayList<String> list = getIntent().getStringArrayListExtra("list");
        EczaneAdapter myAdapter = new EczaneAdapter(list,HastaYakinEczaneActivity.this);
        rv.setAdapter(myAdapter);
    }
}
