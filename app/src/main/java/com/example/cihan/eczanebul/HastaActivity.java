package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class HastaActivity extends AppCompatActivity {
    private static final String TAG = "HastaActivity";
    private float koordx,koordy;
    private ArrayList<String> list = null;
    private ArrayList<ArrayList<String>> list2 = null;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta);
        database = Database.getInstance(HastaActivity.this);
        koordx=1000.0f*(float)Math.random();
        koordy=1000.0f*(float)Math.random();

        Log.d(TAG, "onCreate: x = "+koordx+" y = "+koordy);

        Button eczBul = (Button)findViewById(R.id.eczaneBul);
        Button ilacDisiBul = (Button)findViewById(R.id.ilacDisiBul);

        eczBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list=database.hastaEnYakinEczane(koordx,koordy);
                Intent intent = new Intent(HastaActivity.this,HastaYakinEczaneActivity.class);
                intent.putExtra("list",list);
                startActivity(intent);
            }
        });

        ilacDisiBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list2=database.hastaIlacDisiSorgula();
                Intent intent = new Intent(HastaActivity.this,IlacDisiActivity.class);
                intent.putExtra("list",list2);
                startActivity(intent);
            }
        });
    }

}
