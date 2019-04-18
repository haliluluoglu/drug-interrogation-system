package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoktorGirisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doktor_giris);

        final Database database = Database.getInstance(DoktorGirisActivity.this);

        Button dokBilGir = (Button)findViewById(R.id.doktorGirisButon);
        dokBilGir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim = ((EditText)findViewById(R.id.tescilNoText)).getText().toString();
                String sifre = ((EditText)findViewById(R.id.tescilSifreText)).getText().toString();
                if(database.doktorSifreSorgula(isim,sifre)) {
                    Intent intent = new Intent(DoktorGirisActivity.this, DoktorActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
