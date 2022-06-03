package com.example.navactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DoisActivity extends AppCompatActivity {
    // Atributos:
    private EditText txtVolta;
    private Button btnVolta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dois);

        txtVolta = findViewById(R.id.txtVolta);
        btnVolta = findViewById(R.id.btnVolta);
        btnVolta.setOnClickListener(new EscutadorBotaoVolta());
    }

    // Classe do escutador do botão volta:
    class EscutadorBotaoVolta implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // PARA DEVOLVER DADOS PARA A ACTIVITY ANTERIOR,
            // PRECISAMOS CRIAR UM INTENT:
            Intent balacobaco = new Intent();

            // PEGANDO O TEXTO QUE FOI DIGITADO NA CAIXA txtVolta:
            String texto = txtVolta.getText().toString();

            // ARMAZENANDO O TEXTO NO INTENT, CHAVE "texto":
            balacobaco.putExtra( "texto", texto );

            // ARMAZENANDO NO INTENT O RESULTADO DESTA ACTIVITY:
            setResult( RESULT_OK, balacobaco );

            // FECHANDO ESTA ACTIVITY, VOLTANDO PARA A MAIN ACTIVITY:
            finish();
        }
    }
}
