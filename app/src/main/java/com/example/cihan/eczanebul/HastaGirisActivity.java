package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                if(database.hastaSifreSorgula(isim,sifre)) {
                    Intent intent = new Intent(HastaGirisActivity.this, HastaActivity.class);
                    startActivity(intent);//bu bir denemedir
                }
            }
        });
    }
}