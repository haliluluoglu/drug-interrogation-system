package com.example.cihan.eczanebul;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Girdiğiniz tescil numarası veya şifre yanlıştır.Lütfen tekrar deneyiniz!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
                    v.setTextColor(Color.RED);
                    toast.show();
                }
            }
        });
    }
}
