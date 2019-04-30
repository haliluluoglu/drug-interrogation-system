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

public class EczaneGirisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane_giris);


        Button eczBilGir = (Button)findViewById(R.id.eczGirisButon);

        final Database database = Database.getInstance(EczaneGirisActivity.this);

        eczBilGir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isim = ((EditText)findViewById(R.id.editText)).getText().toString();
                String sifre = ((EditText)findViewById(R.id.eczSifreText)).getText().toString();

                if(database.eczaneSifreSorgula(isim,sifre)){
                    Intent intent = new Intent(EczaneGirisActivity.this, EczaneActivity.class);
                    intent.putExtra("id",Integer.parseInt(isim));
                    startActivity(intent);
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Girdiğiniz kullanıcı adı veya şifre yanlıştır.Lütfen tekrar deneyiniz!";
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
