package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Database database = Database.getInstance(MainActivity.this);

        database.hastaBilgiGir("etkin", "kızıldağ", "1234", 2);
            database.hastaGecmisGir(2,"Parol", 500);
            database.hastaGecmisGir(2,"Cabral", 400);
            database.hastaGecmisGir(2,"Ongliza", 5);
        database.hastaBilgiGir("yusuf", "kızıldağ", "5678", 3);
            database.hastaGecmisGir(3,"Atacant", 8);
            database.hastaGecmisGir(3,"Sipragut", 5);
            database.hastaGecmisGir(3,"Vazoxen", 5 );
        database.hastaBilgiGir("cihan", "ünal", "91011", 4);
            database.hastaGecmisGir(4,"Hipersar", 10);
            database.hastaGecmisGir(4,"Diamicron", 60);
            database.hastaGecmisGir(4,"Silverdin", 40000);
        database.hastaBilgiGir("ömer", "demir", "121314", 5);
            database.hastaGecmisGir(5,"Arveles",25);
            database.hastaGecmisGir(5,"Codiovan",12);
            database.hastaGecmisGir(5,"Bengay",50000);
        database.hastaBilgiGir("halil", "uluoğlu", "151617", 6);
            database.hastaGecmisGir(6,"Galvusmet ",850);
            database.hastaGecmisGir(6,"Madecasol ",40000);
            database.hastaGecmisGir(6,"Refresh ",15);

        Button doktor = (Button)findViewById(R.id.doktorButon);
        Button hasta = (Button)findViewById(R.id.hastaButon);
        Button eczane = (Button)findViewById(R.id.eczaneButon);


        doktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DoktorGirisActivity.class);
                startActivity(intent);
            }
        });

        hasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HastaGirisActivity.class);
                startActivity(intent);
            }
        });

        eczane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EczaneGirisActivity.class);
                startActivity(intent);
            }
        });
    }
}
