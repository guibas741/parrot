package src.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.android.parrot.parrot.R;

public class AdicionarFraseActivity extends AppCompatActivity {

    private Button btnAddFrase;
    private EditText txtFraseOriginal, txtFraseTraduzida, txtCategoria, txtFavorito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_frase);

        btnAddFrase = (Button) findViewById(R.id.btnAddFrasesId);

        txtFraseOriginal = (EditText) findViewById(R.id.txtFraseOriginalId);
        txtFraseTraduzida = (EditText) findViewById(R.id.txtFraseTraduzidaId);
        txtCategoria = (EditText) findViewById(R.id.txtCategoriaId);
        txtFavorito = (EditText) findViewById(R.id.txtFavId);
    }


}
