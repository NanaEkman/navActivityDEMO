package com.example.navactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UmActivity extends AppCompatActivity {

    // Atributos:
    private TextView lblExibe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um);

        lblExibe = findViewById(R.id.lblExibe);

        // RECUPERANDO O OBJETO INTENT
        // QUE FOI USADO PRA INICIAR ESTA ACTIVITY:
        Intent telecoteco = getIntent();

        // RECUPERANDO O TEXTO QUE FOI ARMAZENADO
        // DENTRO DO INTENT, NA CHAVE "texto":
        String txt = telecoteco.getStringExtra( "texto" );

        // COLOCANDO O TEXTO RECUPERADO NO TEXTVIEW lblExibe:
        lblExibe.setText(txt);
    }
}