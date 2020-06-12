package br.com.appbuscapessoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import br.com.appbuscapessoa.R;

public class OpcaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_opcao);

    }
        public void abrirFormularioIdentificacao (View view){
            Intent intent = new Intent (this, IdentificacaoActivity.class);
            startActivity (intent);
        }

        public void abrirFormularioBuscaCaracteristicas (View view){
            Intent intent = new Intent (this, CaracteristicaActivity.class);
            startActivity (intent);
        }
    }
