package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class HastaGirisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_giris);

        Button hasta = (Button)findViewById(R.id.tcGirisButon);

        final Database database = Database.getInstance(HastaGirisActivity.this);

        hasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim=((EditText)findViewById(R.id.tcNumaraText)).getText().toString();
                String sifre=((EditText)findViewById(R.id.tcSifreText)).getText().toString();



                if(database.hastaSifreSorgula(isim,sifre)&&getIntent().getStringExtra("mode").equals("RECETE_BUL")) {
                    int hastaid=Integer.parseInt(isim);
                    float x=getIntent().getFloatExtra("x",-1.0f),y=getIntent().getFloatExtra("y",-1.0f);
                    ArrayList<String> list=database.hastaIlacNerede(getIntent().getIntExtra("id",-1),hastaid,x,y);
                    Intent intent = new Intent(HastaGirisActivity.this, HastaReceteActivity.class);
                    intent.putExtra("list",list);
                    startActivity(intent);//bu bir denemedir
                }

                if(database.hastaSifreSorgula(isim,sifre)&&getIntent().getStringExtra("mode").equals("TUM_RECETELER")) {
                    int hastaid=Integer.parseInt(isim);
                    Intent intent=new Intent(HastaGirisActivity.this,TumRecetelerActivity.class);
                    intent.putExtra("id",hastaid);
                    intent.putExtra("x",getIntent().getFloatExtra("x",-1.0f));
                    intent.putExtra("y",getIntent().getFloatExtra("y",-1.0f));
                    startActivity(intent);
                }
            }
        });
    }
}