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

        //DATABASE'DE VAR OLAN HASTA ADLI VERİLER

        database.hastaBilgiGir("Etkin", "Kızıldağ", "h002", 2);
            database.hastaGecmisGir(002,"Parol", 500);
            database.hastaGecmisGir(002,"Cabral", 400);
            database.hastaGecmisGir(002,"Ongliza", 5);
        database.hastaBilgiGir("Cihan", "Ünal", "h003", 3);
            database.hastaGecmisGir(003,"Atacant", 8);
            database.hastaGecmisGir(003,"Sipragut", 5);
            database.hastaGecmisGir(003,"Vazoxen", 5 );
        database.hastaBilgiGir("Ömer", "Demir", "h004", 4);
            database.hastaGecmisGir(004,"Hipersar", 10);
            database.hastaGecmisGir(004,"Diamicron", 60);
            database.hastaGecmisGir(004,"Silverdin", 40000);
        database.hastaBilgiGir("Halil", "Uluoğlu", "h005", 5);
            database.hastaGecmisGir(005,"Arveles",25);
            database.hastaGecmisGir(005,"Codiovan",12);
            database.hastaGecmisGir(005,"Bengay",50000);
        database.hastaBilgiGir("Aziz", "Sancar","h006", 6);
            database.hastaGecmisGir(006,"Galvusmet ",850);
            database.hastaGecmisGir(006,"Madecasol ",40000);
            database.hastaGecmisGir(006,"Refresh ",15);
        database.hastaBilgiGir("Gazi", "Yaşargil", "h007", 7);
        database.hastaBilgiGir("Orhan", "Pamuk", "h008", 8);
        database.hastaBilgiGir("Canan", "Dağdeviren", "h009", 9);
        database.hastaBilgiGir("Cahit", "Arf", "h010", 10);
        database.hastaBilgiGir("Yunus", "Emre", "h011", 11);
        database.hastaBilgiGir("Oğuz", "Atay", "h012", 12);
        database.hastaBilgiGir("Mete", "Atatüre", "h013", 13);
        database.hastaBilgiGir("Afet", "İnan", "h014", 14);
        database.hastaBilgiGir("Aziz", "Nesin", "h015", 15);
        database.hastaBilgiGir("Ali", "Nesin", "h016", 16);

        //DATABASE'DE VAR OLAN ECZANE ADLI VERİLER

        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 00", 50.36, 70.34);
        database.eczaneGir(1,"e001", "Yıldız Eczanesi", "Esenler", "0534 100 10 01", 10, 20);
        database.eczaneGir(1,"e001", "Fatih Eczanesi", "Fatih", "0534 100 10 02", 32.1, 34.34);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 03", 25, 75);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 04", 67.89, 78.09);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 05", 37.45, 34.76);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 06", 80, 45.7);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 07", 90, 43.35);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 08", 16.67, 12);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 09", 59, 65);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 10", 50.36, 70.34);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 11", 50.36, 70.34);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 12", 50.36, 70.34);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 13", 50.36, 70.34);
        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 14", 50.36, 70.34);




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
