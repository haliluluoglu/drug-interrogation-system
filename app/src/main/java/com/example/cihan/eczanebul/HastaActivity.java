package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class HastaActivity extends AppCompatActivity {
    private static final String TAG = "HastaActivity";
    public float koordx,koordy;
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
        database.nobetciGir();

        Log.d(TAG, "onCreate: x = "+koordx+" y = "+koordy);

        Button eczBul = (Button)findViewById(R.id.eczaneBul);
        Button ilacDisiBul = (Button)findViewById(R.id.ilacDisiBul);
        Button hangiEczane = (Button)findViewById(R.id.hangiEczane);
        Button tumReceteler = (Button)findViewById(R.id.receteleriGoster);
        Button nobetciEczaneBul = (Button)findViewById(R.id.nobetciEczaneBul);

        eczBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list=database.hastaEnYakinEczane(koordx,koordy,null,-1);
                Intent intent = new Intent(HastaActivity.this,HastaYakinEczaneActivity.class);
                intent.putExtra("list",list);
                startActivity(intent);
            }
        });

        ilacDisiBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText et=(EditText)findViewById(R.id.ilacDisiArama);
                String put = et.getText().toString();
                if(put!=null&&put.length()!=0) {
                    ArrayList<ArrayList<String>> list=database.hastaIlacDisiSorgula(put);
                    Intent intent = new Intent(HastaActivity.this, IlacDisiActivity.class);
                    intent.putExtra("list",list);

                    startActivity(intent);
                }
            }
        });

        hangiEczane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int receteid=Integer.parseInt("0"+((EditText)findViewById(R.id.receteNumara)).getText().toString());
                Intent intent = new Intent(HastaActivity.this,HastaGirisActivity.class);
                intent.putExtra("id",receteid);
                intent.putExtra("mode","RECETE_BUL");
                intent.putExtra("x",koordx);
                intent.putExtra("y",koordy);
                startActivity(intent);
            }
        });

        tumReceteler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HastaActivity.this,HastaGirisActivity.class);
                intent.putExtra("mode","TUM_RECETELER");
                intent.putExtra("x",koordx);
                intent.putExtra("y",koordy);
                startActivity(intent);
            }
        });

        nobetciEczaneBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HastaActivity.this,NobetciActivity.class);
                intent.putExtra("x",koordx);
                intent.putExtra("y",koordy);
                startActivity(intent);
            }
        });
    }

}
