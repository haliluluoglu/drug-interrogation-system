package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EczaneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane);

        Database database = Database.getInstance(this);
        ArrayList<ArrayList<String>> list = database.eczaneStokSorgula(getIntent().getIntExtra("id",-1));

        RecyclerView rv=(RecyclerView)findViewById(R.id.eczaneStokRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        EczaneStokAdapter adapter=new EczaneStokAdapter(this,list);
        rv.setAdapter(adapter);
    }
}
