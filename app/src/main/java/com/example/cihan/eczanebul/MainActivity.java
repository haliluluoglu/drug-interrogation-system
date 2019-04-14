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

        Button doktor = (Button)findViewById(R.id.doktorButon);
        Button hasta = (Button)findViewById(R.id.hastaButon);
        Button eczaci = (Button)findViewById(R.id.eczaciButon);


        doktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DoktorLoginActivity.class);
                startActivity(intent);
            }
        });

        eczaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EczaneLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
