package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.parrot.parrot.R;

import static com.android.parrot.parrot.R.id.btnAlimentacaoId;
import static com.android.parrot.parrot.R.id.btnComumId;
import static com.android.parrot.parrot.R.id.btnFavoritosId;
import static com.android.parrot.parrot.R.id.btnLocalizacaoId;
import static com.android.parrot.parrot.R.id.btnSaudeId;

public class CategoriasActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnSaude, btnAlimentacao, btnLocalizacao, btnFavoritos, btnComum;
    public static String categoriaSelecionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        btnSaude = (Button) findViewById(btnSaudeId);
        btnAlimentacao = (Button) findViewById(btnAlimentacaoId);
        btnLocalizacao = (Button) findViewById(btnLocalizacaoId);
        btnFavoritos = (Button) findViewById(btnFavoritosId);
        btnComum = (Button) findViewById(btnComumId);

        btnSaude.setOnClickListener(this);
        btnAlimentacao.setOnClickListener(this);
        btnLocalizacao.setOnClickListener(this);
        btnFavoritos.setOnClickListener(this);
        btnComum.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case btnSaudeId:
                categoriaSelecionada = "saude";
                break;
            case btnAlimentacaoId:
                categoriaSelecionada = "alimentacao";
                break;
            case btnLocalizacaoId:
                categoriaSelecionada = "localizacao";
                break;
            case btnFavoritosId:
                categoriaSelecionada = "favoritos";
                break;
            case btnComumId:
                categoriaSelecionada = "comum";
                break;

        }
        if("favoritos".equals(categoriaSelecionada)) {
            startActivity(new Intent(CategoriasActivity.this, ListaFavoritosActivity.class));
        } else {
            startActivity(new Intent(CategoriasActivity.this, ListaFrasesActivity.class));
        }

    }
}
