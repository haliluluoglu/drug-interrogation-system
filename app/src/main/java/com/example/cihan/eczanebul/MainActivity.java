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

        //DATABASE'DE VAR OLAN HASTA VERİLERİ

        database.hastaBilgiGir("Etkin", "Kızıldağ", "h002", 2);

        database.hastaBilgiGir("Cihan", "Ünal", "h003", 3);

        database.hastaBilgiGir("Ömer", "Demir", "h004", 4);

        database.hastaBilgiGir("Halil", "Uluoğlu", "h005", 5);

        database.hastaBilgiGir("Aziz", "Sancar","h006", 6);

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

        //DATABASE'DE VAR OLAN ECZANE ADLI VERİLERİ

        database.eczaneGir(1,"e001", "Türkiye Eczanesi", "Beşiktaş", "0534 100 10 00", 50.36, 70.34);
        database.eczaneGir(2,"e002", "Yıldız Eczanesi", "Esenler", "0534 100 10 01", 10, 20);
        database.eczaneGir(3,"e003", "Fatih Eczanesi", "Fatih", "0534 100 10 02", 32.1, 34.34);
        database.eczaneGir(4,"e004", "Işıl Eczanesi", "Kadıköy", "0534 100 10 03", 25, 75);
        database.eczaneGir(5,"e005", "Nilgün Eczanesi", "Pendik", "0534 100 10 04", 67.89, 78.09);
        database.eczaneGir(6,"e006", "Bağcılar Merkez Eczanesi", "Bağcılar", "0534 100 10 05", 37.45, 34.76);
        database.eczaneGir(7,"e007", "Doğan Eczanesi", "Bağcılar", "0534 100 10 06", 80, 45.7);
        database.eczaneGir(8,"e008", "Çelikel Eczanesi", "Gaziosmanpaşa", "0534 100 10 07", 90, 43.35);
        database.eczaneGir(9,"e009", "Arya Eczanesi", "Yeditepe", "0534 100 10 08", 16.67, 12);
        database.eczaneGir(10,"e010", "Tülin Eczanesi", "Şişli", "0534 100 10 09", 59, 65);
        database.eczaneGir(11,"e011", "Yeni Eylül Eczanesi", "Mecidiyeköy", "0534 100 10 10", 65, 70);
        database.eczaneGir(12,"e012", "Başar Eczanesi", "Tuzla", "0534 100 10 11", 19, 25.90);
        database.eczaneGir(13,"e013", "Referans Eczanesi", "Beşiktaş", "0534 100 10 12", 05.06, 70.34);
        database.eczaneGir(14,"e014", "Avis Eczanesi", "Zincirlikuyu", "0534 100 10 13", 13.67, 55.5);
        database.eczaneGir(15,"e015", "Seyhun Eczanesi", "Zeytinburnu", "0534 100 10 14", 61.21, 45.3);




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
                Intent intent = new Intent(MainActivity.this, HastaActivity.class);
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
