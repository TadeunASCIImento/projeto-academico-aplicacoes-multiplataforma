package br.com.appbuscapessoa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.appbuscapessoa.adapters.CustomAdapter;
import br.com.appbuscapessoa.entities.Endereco;
import br.com.appbuscapessoa.entities.Identificacao;
import br.com.appbuscapessoa.entities.Identificacoes;
import br.com.appbuscapessoa.entities.Instituicao;
import br.com.appbuscapessoa.entities.Registro;
import br.com.appbuscapessoa.servicos.ServiceControllerHTTP;
import br.com.appbuscapessoa.servicos.URLConstantsHTTP;
import br.com.appbuscapessoa.util.ConversoraImagem;
import br.com.appbuscapessoa.util.XmlConversor;

public class IdentificacaoActivity extends AppCompatActivity {

    private EditText txtDocumento;
    private EditText txtNome;
    private EditText txtNomePai;
    private EditText txtNomeMae;
    private Button btnLocalizar;
    private ListView lsvRegistros;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_identificacao);
        this.txtDocumento = findViewById (R.id.txtDocumento);
        this.txtNome = findViewById (R.id.txtNome);
        this.txtNomePai = findViewById (R.id.txtNomePai);
        this.txtNomeMae = findViewById (R.id.txtNomeMae);
        this.btnLocalizar = findViewById (R.id.btnLocalizar);

        btnLocalizar.setOnClickListener (new View.OnClickListener () {

            @Override
            public void onClick(View v) {
                String documento = txtDocumento.getText ().toString ();
                String nome = txtNome.getText ().toString ();
                String nomePai = txtNomePai.getText ().toString ();
                String nomeMae = txtNomeMae.getText ().toString ();

                Identificacao identificacao = new Identificacao (null, documento, nome, nomePai, nomeMae, "", null, null, null);
                String xml = new XmlConversor ().toXML (identificacao);

                List<Identificacao> lstIdentificacoes = new ArrayList<> ();
                List<Instituicao> listaInstituicoes = new ArrayList<> ();
                List<Endereco> listaEnderecos = new ArrayList<> ();

                try {
                    String resposta = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_BUSCAR_IDENTIFICACAO, xml);
                    Identificacoes identificacoes = new XmlConversor ().fromXML (Identificacoes.class, resposta);
                    for (Identificacao iden : identificacoes.getIdentificacoes ()) {
                        identificacao = new Identificacao ();
                        identificacao.setIdIdentificacao (iden.getIdIdentificacao ());
                        identificacao.setIdInstituicaofk (iden.getIdInstituicaofk ());
                        xml = new XmlConversor ().toXML (identificacao);
                        resposta = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_FOTO_IDENTIFICACAO, xml);
                        iden.setFotoBase64 (resposta);
                        lstIdentificacoes.add (iden);
                    }
                } catch (Exception e) {
                    e.printStackTrace ();
                }
                for(Identificacao identificacao1:lstIdentificacoes){
                    Instituicao instituicao = new Instituicao ();
                    instituicao.setIdInstituicao (identificacao.getIdInstituicaofk ());
                    xml = new XmlConversor ().toXML (instituicao);
                    String resposta = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_BUSCAR_INSTITUICAO,xml);
                    instituicao = new XmlConversor ().fromXML (Instituicao.class,resposta);
                    listaInstituicoes.add (instituicao);
                }
                for(Instituicao instituicao:listaInstituicoes){
                    Endereco endereco = new Endereco ();
                    endereco.setIdEndereco (instituicao.getIdEnderecofk ());
                    xml = new XmlConversor ().toXML (endereco);
                    String resposta = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_BUSCAR_ENDERECO,xml);
                    endereco = new XmlConversor ().fromXML (Endereco.class,resposta);
                    listaEnderecos.add (endereco);
                }

                byte[] imageBytes;
                List<Registro> lstRegistros = new ArrayList<> ();

                for (Identificacao iden : lstIdentificacoes) {
                    Registro registro = new Registro ();
                    registro.setRegistro(iden.getIdIdentificacao ());
                    registro.setData (iden.getDataRegistro ());
                    registro.setDocumento(iden.getDocumento ());
                    registro.setNome (iden.getNome ());
                    registro.setFiliacaoPai (iden.getNomePai ());
                    registro.setFiliacaoMAe (iden.getNomeMae ());
                    imageBytes = new ConversoraImagem().convertBase64StringToByteArray (iden.getFotoBase64 ());
                    registro.setFoto (imageBytes);
                    registro.setObservacao (iden.getObservacao ());
                    for (Instituicao instituicao : listaInstituicoes) {
                        registro.setInstituicao (instituicao.getNomeInstituicao ());
                        registro.setTelefone (instituicao.getTelefone ());
                        for (Endereco endereco : listaEnderecos) {
                            registro.setEndereco (endereco.getLogradouro ());
                            registro.setBairro (endereco.getBairro ());
                            registro.setCep (endereco.getCep ());
                            registro.setCidade (endereco.getCidade ());
                        }
                    }
                    lstRegistros.add (registro);
                }
                Intent intent = new Intent (IdentificacaoActivity.this,ResultActivity.class);
                intent.putExtra ("registros",(Serializable) lstRegistros);
                startActivity (intent);
            }


        });

    }




}

