package br.com.appbuscapessoa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.appbuscapessoa.entities.Usuario;
import br.com.appbuscapessoa.servicos.ServiceControllerHTTP;
import br.com.appbuscapessoa.servicos.URLConstantsHTTP;
import br.com.appbuscapessoa.util.XmlConversor;

public class LoginActivity extends AppCompatActivity {

    EditText txtUsuario,txtSenha;
    Button btnEntrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
            this.txtUsuario = findViewById (R.id.txtUsuario);
            this.txtSenha = findViewById (R.id.txtSenha);
            this.btnEntrar = findViewById (R.id.btnEntrar);
            btnEntrar.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Usuario usuario = new Usuario ();
                    String email = txtUsuario.getText ().toString ();
                    String senha = txtSenha.getText ().toString ();
                    if (email.equalsIgnoreCase ("") && senha.equalsIgnoreCase ("")) {
                        exibirMensagemUsuarioInvalido ();
                    } else {
                        usuario = new Usuario (0, "", "", email, senha);
                    }
                    String usuarioXML = new XmlConversor ().toXML (usuario);
                    try {
                        String resposta =
                                new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_VALIDAR_USUARIO, usuarioXML);
                        System.out.println (resposta);
                        if (resposta.contains (email) && resposta.contains (senha)) {
                            Intent intent = new Intent (LoginActivity.this, OpcaoActivity.class);
                            startActivity (intent);
                        } else {
                            exibirMensagemUsuarioInvalido ();
                        }
                    } catch (Exception e) {
                        e.printStackTrace ();
                    }

                }
            });

        }

    public void exibirMensagemUsuarioInvalido(){
        final AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setMessage ("Verifique a senha e o usuário!");
        builder.setPositiveButton ("Ok", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog alert = builder.create ();
        alert.setTitle ("Usuário inválido!");
        alert.show ();
    }

    public void cadastrarUsuario(View view){
        Intent intent = new Intent (this, CadastroActivity.class);
        startActivity (intent);

    }
}
