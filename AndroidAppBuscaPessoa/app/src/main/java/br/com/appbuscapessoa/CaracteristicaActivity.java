package br.com.appbuscapessoa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import br.com.appbuscapessoa.entities.Caracteristica;
import br.com.appbuscapessoa.entities.Caracteristicas;
import br.com.appbuscapessoa.entities.Endereco;
import br.com.appbuscapessoa.entities.Instituicao;
import br.com.appbuscapessoa.entities.Registro;
import br.com.appbuscapessoa.servicos.ServiceControllerHTTP;
import br.com.appbuscapessoa.servicos.URLConstantsHTTP;
import br.com.appbuscapessoa.util.ConversoraImagem;
import br.com.appbuscapessoa.util.XmlConversor;

public class CaracteristicaActivity extends AppCompatActivity {

    private Spinner sexo;
    private Spinner pele;
    private Spinner tipoCabelo;
    private Spinner barba;
    private Spinner deficiencia;
    private Spinner altura;
    private Spinner olhos;
    private Spinner corCabelo;
    private Spinner porteFisico;
    private Spinner tatuagens;
    private Spinner cicatrizes;
    private Spinner idade;
    private Button btnLocalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_caracteristica);
        this.btnLocalizar = findViewById (R.id.btnLocalizar);

        sexo = (Spinner) findViewById (R.id.spinner_genero);
        ArrayAdapter<CharSequence> adapterSexo = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_genero, android.R.layout.simple_spinner_item);
        adapterSexo.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        sexo.setAdapter (adapterSexo);

        pele = (Spinner) findViewById (R.id.spinner_pele);
        ArrayAdapter<CharSequence> adapterPele = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_pele, android.R.layout.simple_spinner_item);
        adapterPele.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        pele.setAdapter (adapterPele);

        tipoCabelo = (Spinner) findViewById (R.id.spinner_tipo_cabelo);
        ArrayAdapter<CharSequence> adapterTipoCabelo = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_tipo_cabelo, android.R.layout.simple_spinner_item);
        adapterTipoCabelo.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        tipoCabelo.setAdapter (adapterTipoCabelo);

        barba = (Spinner) findViewById (R.id.spinner_barba);
        ArrayAdapter<CharSequence> adapterBarba = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_barba, android.R.layout.simple_spinner_item);
        adapterBarba.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        barba.setAdapter (adapterBarba);

        deficiencia = (Spinner) findViewById (R.id.spinner_deficiencia);
        ArrayAdapter<CharSequence> adapterDeficiencia = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_deficiencia, android.R.layout.simple_spinner_item);
        adapterDeficiencia.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        deficiencia.setAdapter (adapterDeficiencia);

        altura = (Spinner) findViewById (R.id.spinner_altura);
        ArrayAdapter<CharSequence> adapterAltura = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_altura, android.R.layout.simple_spinner_item);
        adapterAltura.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        altura.setAdapter (adapterAltura);

        olhos = (Spinner) findViewById (R.id.spinner_olhos);
        ArrayAdapter<CharSequence> adapterOlhos = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_olhos, android.R.layout.simple_spinner_item);
        adapterOlhos.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        olhos.setAdapter (adapterOlhos);

        corCabelo = (Spinner) findViewById (R.id.spinner_cor_cabelo);
        ArrayAdapter<CharSequence> adapterCorCabelo = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_cor_cabelo, android.R.layout.simple_spinner_item);
        adapterCorCabelo.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        corCabelo.setAdapter (adapterCorCabelo);

        porteFisico = (Spinner) findViewById (R.id.spinner_fisico);
        ArrayAdapter<CharSequence> adapterFisico = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_fisico, android.R.layout.simple_spinner_item);
        adapterFisico.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        porteFisico.setAdapter (adapterFisico);

        tatuagens = (Spinner) findViewById (R.id.spinner_tatuagens);
        ArrayAdapter<CharSequence> adapterTatuagens = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_tatuagens, android.R.layout.simple_spinner_item);
        adapterTatuagens.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        tatuagens.setAdapter (adapterTatuagens);

        cicatrizes = (Spinner) findViewById (R.id.spinner_cicatrizes);
        ArrayAdapter<CharSequence> adapterCicatrizes = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_cicatrizes, android.R.layout.simple_spinner_item);
        adapterCicatrizes.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        cicatrizes.setAdapter (adapterCicatrizes);

        idade = (Spinner) findViewById (R.id.spinnerIdade);
        ArrayAdapter<CharSequence> adapterIdade = ArrayAdapter.createFromResource (CaracteristicaActivity.this,
                R.array.lista_idade, android.R.layout.simple_spinner_item);
        adapterIdade.setDropDownViewResource (android.R.layout.simple_spinner_dropdown_item);
        idade.setAdapter (adapterIdade);

        btnLocalizar.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Caracteristica crt = new Caracteristica ();
                crt.setSexo ((String) sexo.getSelectedItem ());
                Double alt = Double.valueOf (String.valueOf (altura.getSelectedItem ()));
                crt.setAltura (alt);
                crt.setBarba ((String) barba.getSelectedItem ());
                crt.setCicatrizes ((String) cicatrizes.getSelectedItem ());
                crt.setCorCabelo ((String) corCabelo.getSelectedItem ());
                crt.setDeficiencia ((String) deficiencia.getSelectedItem ());
                crt.setFisico ((String) porteFisico.getSelectedItem ());
                Integer idd = Integer.valueOf (String.valueOf (idade.getSelectedItem ()));
                crt.setIdade (idd);
                crt.setOlhos ((String) olhos.getSelectedItem ());
                crt.setPele ((String) pele.getSelectedItem ());
                crt.setTipoCabelo ((String) tipoCabelo.getSelectedItem ());
                crt.setTatuagens ((String) tatuagens.getSelectedItem ());

                String xml = new XmlConversor ().toXML (crt);

                List<Caracteristica> lstCaracteristicas = new ArrayList<> ();
                List<Instituicao> lstInstituicoes = new ArrayList<> ();
                List<Endereco> lstEnderecos = new ArrayList<> ();

                try {
                    String resp = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_BUSCAR_CARACTERISTICAS, xml);
                    Caracteristicas caracteristicas = new XmlConversor ().fromXML (Caracteristicas.class, resp);
                    for (Caracteristica crt2 : caracteristicas.getCaracteristicas ()) {
                        Caracteristica caracteristica = new Caracteristica ();
                        caracteristica.setIdCaracteristica (crt2.getIdCaracteristica ());
                        caracteristica.setIdInstituicaofk (crt2.getIdInstituicaofk ());
                        xml = new XmlConversor ().toXML (caracteristica);
                        resp = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_FOTO_CARACTERISTICA, xml);
                        crt2.setFotoBase64 (resp);
                        lstCaracteristicas.add (crt2);
                    }
                } catch (Exception e) {
                    e.printStackTrace ();
                }
                for (Caracteristica crt3 : lstCaracteristicas) {
                    Instituicao instituicao = new Instituicao ();
                    instituicao.setIdInstituicao (crt3.getIdInstituicaofk ());
                    xml = new XmlConversor ().toXML (instituicao);
                    String resp = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_BUSCAR_INSTITUICAO, xml);
                    instituicao = new XmlConversor ().fromXML (Instituicao.class, resp);
                    lstInstituicoes.add (instituicao);
                }
                for (Instituicao inst : lstInstituicoes) {
                    Endereco endereco = new Endereco ();
                    endereco.setIdEndereco (inst.getIdEnderecofk ());
                    xml = new XmlConversor ().toXML (endereco);
                    String resposta = new ServiceControllerHTTP ().doInBackground (URLConstantsHTTP.URL_BUSCAR_ENDERECO, xml);
                    endereco = new XmlConversor ().fromXML (Endereco.class, resposta);
                    lstEnderecos.add (endereco);
                }
                byte[] imageBytes;
                List<Registro> lstRegistros = new ArrayList<> ();
                for (Caracteristica caract : lstCaracteristicas) {
                    Registro registro = new Registro ();
                    registro.setRegistro (caract.getIdCaracteristica ());
                    registro.setData (caract.getDataRegistro ());
                    registro.setDocumento ("desconhecido");
                    registro.setNome ("desconhecido");
                    registro.setFiliacaoPai ("desconhecido");
                    registro.setFiliacaoMAe ("desconhecido");
                    imageBytes = new ConversoraImagem ().convertBase64StringToByteArray (caract.getFotoBase64 ());
                    registro.setFoto (imageBytes);
                    registro.setObservacao (caract.getObservacao ());
                    for (Instituicao instituicao : lstInstituicoes) {
                        registro.setInstituicao (instituicao.getNomeInstituicao ());
                        registro.setTelefone (instituicao.getTelefone ());
                        for (Endereco endereco : lstEnderecos) {
                            registro.setEndereco (endereco.getLogradouro ());
                            registro.setBairro (endereco.getBairro ());
                            registro.setCep (endereco.getCep ());
                            registro.setCidade (endereco.getCidade ());
                        }
                    }
                    lstRegistros.add (registro);

                }
                returnList (lstRegistros);
            }

        });
    }
    public void returnList(List<Registro>registros){
        Intent intent  = new Intent (this,ResultActivity.class);
        intent.putExtra ("registros",(Serializable) registros);
        startActivity (intent);
    }
}
