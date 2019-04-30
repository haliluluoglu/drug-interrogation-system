package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class TumRecetelerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tum_receteler);
        int hastaid=getIntent().getIntExtra("id",-1);

        RecyclerView rv = (RecyclerView)findViewById(R.id.tumRecetelerRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        float x=getIntent().getFloatExtra("x",-1.0f),y=getIntent().getFloatExtra("y",-1.0f);
        TumRecetelerAdapter adapter = new TumRecetelerAdapter(TumRecetelerActivity.this,hastaid,x,y);
        rv.setAdapter(adapter);
    }
}
