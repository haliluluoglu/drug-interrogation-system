package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReceteDetayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recete_detay);

        float x=getIntent().getFloatExtra("x",1.0f),y=getIntent().getFloatExtra("y",1.0f);

        RecyclerView rv=(RecyclerView)findViewById(R.id.receteDetayRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ReceteDetayAdapter adapter = new ReceteDetayAdapter(this,getIntent().getStringArrayListExtra("list"),getIntent().getStringExtra("num"),x,y);
        rv.setAdapter(adapter);
    }
}
