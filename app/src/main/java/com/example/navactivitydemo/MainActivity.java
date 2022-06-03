package com.example.navactivitydemo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Atributos:
    private EditText txtVai;
    private Button btnVai;
    private TextView lblVolta;
    private Button btnDigitar;
    private Button btnAct3;

    // Atributos para os callbacks de cada volta de activity:
    ActivityResultLauncher<Intent> DoisActivityResultLauncher;
    ActivityResultLauncher<Intent> TresActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVai = findViewById(R.id.txtVai);
        btnVai = findViewById(R.id.btnVai);
        lblVolta = findViewById(R.id.lblVolta);
        btnDigitar = findViewById(R.id.btnDigitar);
        btnAct3 = findViewById(R.id.btnAct3);

        btnVai.setOnClickListener( new EscutadorVai() );
        btnDigitar.setOnClickListener( new EscutadorDigitar() );
        btnAct3.setOnClickListener( new EscutadorBotao3() );

        // Registrando a função que será executada quando voltar da DoisActivity:
        DoisActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {

                    // AQUI VAI O CÓDIGO QUE SERÁ EXECUTADO NA VOLTA.

                    // O RESULTADO ESTÁ REGISTRADO EM RESULT.GETRESULTCODE():
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        // SE FOR RESULT_OK, É PORQUE O USUÁRIO CLICOU NO OK.

                        // RECUPERAR O INTENT, QUE ESTÁ DENTRO DE RESULT:
                        Intent i = result.getData();

                        // RECUPERAR O TEXTO DE DENTRO DO INTENT,
                        // NA CHAVE "texto".
                        String txt = i.getStringExtra( "texto" );

                        // COLOCANDO O TEXTO NO TEXTVIEW lblVolta:
                        lblVolta.setText( txt );

                        // EXIBINDO TOAST INFORMATIVO:
                        String msg = "Viemos da DoisActivity.\nE o usuário clicou no VOLTA";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                    } else {

                        // SE ENTROU AQUI, É PORQUE NÃO VEIO RESULT_OK,
                        // ISTO É, USUÁRIO CLICOU NO "VOLTAR" DO CELULAR.

                        // COLOCANDO ESTA INFORMAÇÃO EM lblVolta:
                        lblVolta.setText("Usuário clicou em voltar");

                        // EXIBINDO TOAST INFORMATIVO:
                        String msg = "Viemos da DoisActivity.\nE o usuário clicou no BACK do celular";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                    }
                }
            }
        );


        // Registrando a função que será executada quando voltar da TresActivity:
        TresActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {

                @Override
                public void onActivityResult(ActivityResult result) {

                    // AQUI VAI O CÓDIGO QUE SERÁ EXECUTADO.

                    // O RESULTADO ESTÁ REGISTRADO EM RESULT.GETRESULTCODE():
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        // SE FOR RESULT_OK, É PORQUE O USUÁRIO CLICOU NO OK.

                        // EXIBINDO TOAST INFORMATIVO:
                        String msg = "Viemos da TresActivity.\nE o usuário clicou no OK";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                    } else {

                        // SE ENTROU AQUI, É PORQUE NÃO VEIO RESULT_OK,
                        // ISTO É, USUÁRIO CLICOU NO "VOLTAR" DO CELULAR.

                        // EXIBINDO TOAST INFORMATIVO:
                        String msg = "Viemos da TresActivity.\nE o usuário clicou no BACK do celular";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                    }
                }
            }
        );
    }

    // Classe do escutador do botão vai:
    class EscutadorVai implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // INTENT PARA ABRIR A "UM ACTIVITY":
            Intent i = new Intent( getApplicationContext(), UmActivity.class );

            // PEGANDO O QUE FOI DIGITADO EM txtVai:
            String texto = txtVai.getText().toString();

            // COLOCANDO O TEXTO DENTRO DO INTENT, CHAVE "texto":
            i.putExtra( "texto", texto );

            // INICIANDO A UM ACTIVITY:
            startActivity(i);
        }
    }

    // Classe do escutador do botão digitar:
    class EscutadorDigitar implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // CRIANDO O INTENT QUE VAI ABRIR A DOIS ACITIVITY:
            Intent iii = new Intent( getApplicationContext(), DoisActivity.class );

            // INICIANDO A TRES ACITIVITY:
            DoisActivityResultLauncher.launch(iii);
        }
    }

    // Classe do escutador que abre a TresActivity:
    class EscutadorBotao3 implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            // CRIANDO O INTENT QUE VAI ABRIR A TRES ACITIVITY:
            Intent i = new Intent( getApplicationContext(), TresActivity.class );

            // INICIANDO A TRES ACITIVITY:
            TresActivityResultLauncher.launch(i);
        }
    }
}


