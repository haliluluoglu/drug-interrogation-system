package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HastaActivity extends AppCompatActivity {
    private float koordx,koordy;
    private ArrayList<String> list = null;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta);
        database = Database.getInstance(HastaActivity.this);
        koordx=1000.0f*(float)Math.random();
        koordy=1000.0f*(float)Math.random();

        Button eczBul = (Button)findViewById(R.id.eczaneBul);

        eczBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list=database.hastaEnYakinEczane(koordx,koordy);
            }
        });
    }

}
