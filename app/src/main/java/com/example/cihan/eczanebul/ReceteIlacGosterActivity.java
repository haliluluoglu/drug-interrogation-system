package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ReceteIlacGosterActivity extends AppCompatActivity {
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recete_ilac_goster);
        database=Database.getInstance(this);

        float x=getIntent().getFloatExtra("x",-1.0f),y=getIntent().getFloatExtra("y",-1.0f);
        String isim=getIntent().getStringExtra("isim");
        int mg=Integer.parseInt(getIntent().getStringExtra("mg"));

        RecyclerView rv = (RecyclerView)findViewById(R.id.ilacGosterRecyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> list = database.hastaEnYakinEczane(x,y,isim,mg);
        EczaneAdapter adapter = new EczaneAdapter(list,this);
        rv.setAdapter(adapter);
    }
}
