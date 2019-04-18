package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EczaneGirisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane_giris);

        Button eczBilGir = (Button)findViewById(R.id.eczGirisButon);
        eczBilGir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EczaneGirisActivity.this, EczaneActivity.class);
                startActivity(intent);
            }
        });
    }
}
