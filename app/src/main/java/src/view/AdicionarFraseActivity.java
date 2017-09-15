package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import java.util.ArrayList;

import src.dao.Create;
import src.model.Frase;

public class AdicionarFraseActivity extends AppCompatActivity {

    private Button btnAddFrase, btnListar;
    private EditText txtFraseOriginal, txtFraseTraduzida;
    private CheckBox favorito;
    private Spinner spnCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_frase);

        btnAddFrase = (Button) findViewById(R.id.btnAddFrasesId);
        btnListar = (Button) findViewById(R.id.btnListarId);

        txtFraseOriginal = (EditText) findViewById(R.id.txtFraseOriginalId);
        txtFraseTraduzida = (EditText) findViewById(R.id.txtFraseTraduzidaId);

        favorito = (CheckBox) findViewById(R.id.favoritoId);

        Create c = new Create(getApplicationContext());
        c.createTable();

        spnCategoria = (Spinner) findViewById(R.id.spnCategoriaId);

        String[] items = new String[]{"saude", "alimentacao", "localizacao", "comum", "personalizado"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spnCategoria.setAdapter(adapter);


        btnAddFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frase f = new Frase();
                f.setFraseOriginal(txtFraseOriginal.getText().toString());
                f.setFraseTraduzida(txtFraseTraduzida.getText().toString());
                f.setCategoria(spnCategoria.getSelectedItem().toString());
                f.setFavorito(favorito.isChecked());

                Create c = new Create(getApplicationContext());

                if(c.insertFrase(f)) {
                    Toast.makeText(getApplicationContext(), "Frase inserida com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Frase NAO INSERIDA", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Create r = new Create(getApplicationContext());
                ArrayList<Frase> fArray = r.getFrases();
                for (int i = 0; i < fArray.size(); i++) {
                    Frase f = fArray.get(i);
                    System.out.println("ID = " + f.getId() +
                            "\n FRASE = " + f.getFraseOriginal() +
                            "\n TRADUCAO = " + f.getFraseTraduzida() +
                            "\n CATEGORIA = " + f.getCategoria() +
                            "\n FAVORITA = " + f.isFavorito() +
                            "\n -----------------------------------");
                }

                startActivity(new Intent(getApplicationContext(), ListaFrasesActivity.class));
            }
        });
    }


}
