package br.com.appbuscapessoa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import br.com.appbuscapessoa.adapters.CustomAdapter;
import br.com.appbuscapessoa.entities.Registro;

public class ResultActivity extends AppCompatActivity {

    private List<Registro> lstRegistros;
    private ListView lsvRegistros;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_result);
        this.lsvRegistros = findViewById (R.id.lsvRegistros);

        Bundle bundle = getIntent ().getExtras ();
        lstRegistros = (List<Registro>) bundle.getSerializable ("registros");

        if (lstRegistros.size () <= 0) {
            setContentView (R.layout.no_results);
        } else {
            adapter = new CustomAdapter (this, lstRegistros);
            lsvRegistros.setAdapter (adapter);
        }


    }

}



