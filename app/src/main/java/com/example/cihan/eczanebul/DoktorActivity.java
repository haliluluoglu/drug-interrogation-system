package com.example.cihan.eczanebul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DoktorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doktor);
        final Database database=Database.getInstance(this);


        Button button=(Button)findViewById(R.id.doktorIlacKontrol);
        final EditText isim=(EditText)findViewById(R.id.doktorIlac);
        final EditText mg=(EditText)findViewById(R.id.doktorMG);
        final TextView tv=(TextView)findViewById(R.id.doktorTextView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int m=Integer.parseInt("0"+mg.getText().toString());
                String i=isim.getText().toString();
                i=i.toUpperCase();
                if(m==0)
                    m--;
                if(database.doktorIlacSorgula(i,m)){
                    tv.setText("İlaç eczanelerde mevcut");
                }
                else{
                    tv.setText("İlaç eczanelerde mevcut değil");
                }
            }
        });
    }
}
