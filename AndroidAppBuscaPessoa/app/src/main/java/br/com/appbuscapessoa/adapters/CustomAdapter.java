package br.com.appbuscapessoa.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.appbuscapessoa.R;
import br.com.appbuscapessoa.entities.Registro;
import br.com.appbuscapessoa.util.ConversoraImagem;

public class CustomAdapter extends BaseAdapter {

    private Context context;

    private List<Registro> lstRegistros;

    public CustomAdapter(Context context, List<Registro> registros) {
        this.context = context;
        this.lstRegistros = registros;
    }

    @Override
    public int getCount() {
        return lstRegistros.size ();
    }

    @Override
    public Object getItem(int position) {
        return lstRegistros.get (position);
    }

    @Override
    public long getItemId(int position) {
        return lstRegistros.get (position).getRegistro ();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(this.context).inflate (R.layout.registro_item,parent,false);

        Registro registro = lstRegistros.get (position);
        TextView idRegistro = view.findViewById (R.id.txtRegistro);
        TextView data = view.findViewById (R.id.txtData);
        TextView documento = view.findViewById (R.id.txtDocumento);
        TextView filiacaoPai = view.findViewById (R.id.txtFiliacaoPai);
        TextView filiacaoMae = view.findViewById (R.id.txtFiliacaoMae);
        TextView nome = view.findViewById (R.id.txtNome);
        TextView instituicao = view.findViewById (R.id.txtInstituicao);
        TextView endereco = view.findViewById (R.id.txtEndereco);
        TextView cep = view.findViewById (R.id.txtCep);
        TextView bairro = view.findViewById (R.id.txtBairro);
        TextView cidade = view.findViewById (R.id.txtCidade);
        TextView telefone = view.findViewById (R.id.txtTelefone);
        TextView observacao = view.findViewById (R.id.txtObservacao);
        ImageView foto = view.findViewById (R.id.imvFoto);

        idRegistro.setText (Integer.toString (registro.getRegistro ()));
        data.setText (registro.getData ().substring (0,10));
        documento.setText (registro.getDocumento ());
        filiacaoPai.setText (registro.getFiliacaoPai ());
        filiacaoMae.setText (registro.getFiliacaoMAe ());
        nome.setText (registro.getNome ());
        instituicao.setText (registro.getInstituicao ());
        endereco.setText (registro.getEndereco ());
        cep.setText (registro.getCep ());
        bairro.setText (registro.getBairro ());
        cidade.setText (registro.getCidade ());
        telefone.setText (registro.getTelefone ());
        observacao.setText (registro.getObservacao ());
        foto.setImageBitmap (new ConversoraImagem ().toBitmap (registro.getFoto ()));

        return view;

    }
}
