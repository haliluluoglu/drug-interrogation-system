package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class NobetciActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nobetci);
        Database database = Database.getInstance(this);

        ArrayList<String> list = database.nobetciBul(getIntent().getFloatExtra("x",-1),getIntent().getFloatExtra("y",-1));

        RecyclerView rv = (RecyclerView)findViewById(R.id.nobetciRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        EczaneAdapter adapter = new EczaneAdapter(list,this);
        rv.setAdapter(adapter);
    }
}
