package com.example.cihan.eczanebul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoktorLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doktor_login);

        Button dokBilGir = (Button)findViewById(R.id.doktorBilgiGirisi);
        dokBilGir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoktorLoginActivity.this, DoktorActivity.class);
                startActivity(intent);
            }
        });
    }
}
