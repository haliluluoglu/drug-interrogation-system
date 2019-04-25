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
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Girdiğiniz T.C kimlik numarası veya şifre yanlıştır.Lütfen tekrar deneyiniz!";
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