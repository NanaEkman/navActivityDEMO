package com.example.navactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TresActivity extends AppCompatActivity {
    // Atributos:
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tres);

        btnOK = findViewById(R.id.btnOK);
        btnOK.setOnClickListener( new EscutadorBotaoOK() );
    }

    // Classe escutadora do botão OK:
    class EscutadorBotaoOK implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // PARA DEVOLVER DADOS PARA A ACTIVITY ANTERIOR,
            // PRECISAMOS CRIAR UM INTENT:
            Intent i = new Intent();

            // ARMAZENANDO NO INTENT O RESULTADO DESTA ACTIVITY:
            setResult( RESULT_OK, i );

            // FECHANDO ESTA ACTIVITY, VOLTANDO PARA A MAIN ACTIVITY:
            finish();
        }
    }
}