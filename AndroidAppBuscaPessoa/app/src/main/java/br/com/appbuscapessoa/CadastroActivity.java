package br.com.appbuscapessoa;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.appbuscapessoa.entities.Usuario;
import br.com.appbuscapessoa.servicos.ServiceControllerHTTP;
import br.com.appbuscapessoa.servicos.URLConstantsHTTP;
import br.com.appbuscapessoa.util.XmlConversor;

public class CadastroActivity extends AppCompatActivity {


    private TextView txtNome,txtCpf,txtEmail,txtSenha;
    private Button btnCadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cadastro);

        this.txtNome = findViewById (R.id.txtNome);
        this.txtCpf = findViewById (R.id.txtCpf);
        this.txtEmail = findViewById (R.id.txtEmail);
        this.txtSenha = findViewById (R.id.txtSenha);
        this.btnCadastrar = findViewById (R.id.btnCadastrar);

        btnCadastrar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Usuario usuario = null;
                String nome = txtNome.getText ().toString ();
                String cpf = txtCpf.getText ().toString ();
                String email = txtEmail.getText ().toString ();
                String senha = txtSenha.getText ().toString ();
                if(nome.equalsIgnoreCase ("") |
                        cpf.equalsIgnoreCase ("")|
                email.equalsIgnoreCase ("")|
                senha.equalsIgnoreCase ("")){
                    exibirMensagemDadosInvalidos ();
                }else{
                    usuario= new Usuario (0,nome,cpf,email,senha);
                }
                String usuarioXml = new XmlConversor ().toXML (usuario);
                try {
                  String resposta = new ServiceControllerHTTP ()
                          .doInBackground (URLConstantsHTTP.URL_CADASTRAR_USUARIO,usuarioXml);
                 if(resposta.equalsIgnoreCase ("true")){
                     exibirMensagemConfirmacao (usuario);
                 }else{
                     exibirMensagemDadosInvalidos ();
                 }
                }catch (Exception exc){
                    exc.printStackTrace ();
                }
            }
        });

    }
    public void exibirMensagemDadosInvalidos(){
        final AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setMessage ("Verifique os campos e tente novamente!");
        builder.setPositiveButton ("Ok", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        AlertDialog alert = builder.create ();
        alert.setTitle ("Dados inválidos!");
        alert.show ();
    }
    public void exibirMensagemConfirmacao(Usuario usuario){
        final Intent intent = new Intent (this,LoginActivity.class);
        String mensagem = "Faça seu login";
        AlertDialog.Builder builder = new AlertDialog.Builder (this);
        builder.setMessage (mensagem);
        builder.setPositiveButton ("ok", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity (intent);
            }
        });
        AlertDialog alert = builder.create ();
        alert.setTitle ("Cadastro realizado!");
        alert.show ();
    }

}
