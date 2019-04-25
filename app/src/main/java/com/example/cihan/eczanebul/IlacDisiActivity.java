package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class IlacDisiActivity extends AppCompatActivity {
    private static final String TAG = "IlacDisiActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilac_disi);

        RecyclerView rv=(RecyclerView)findViewById(R.id.ilacDisiRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(IlacDisiActivity.this));
        Bundle b=getIntent().getExtras();
        ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>)b.get("list");

        Log.d(TAG, "onCreate: size = "+list.size());
        IlacDisiAdapter adapter = new IlacDisiAdapter(IlacDisiActivity.this, list);
        rv.setAdapter(adapter);
    }
}
