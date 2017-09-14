package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.parrot.parrot.R;

public class CategoriasActivity extends AppCompatActivity {

    private Button btnSaude, btnAlimentacao, btnLocalizacao, btnPersonalizados, btnComum;
    public static String categoriaSelecionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        btnSaude = (Button) findViewById(R.id.btnSaudeId);
        btnAlimentacao = (Button) findViewById(R.id.btnAlimentacaoId);
        btnLocalizacao = (Button) findViewById(R.id.btnLocalizacaoId);
        btnPersonalizados = (Button) findViewById(R.id.btnPersonalizadosId);
        btnComum = (Button) findViewById(R.id.btnComumId);

        btnSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new Intent(CategoriasActivity.this,listaFrasesActivity.class)));
                categoriaSelecionada = "saude";
            }
        });

        btnAlimentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new Intent(CategoriasActivity.this,listaFrasesActivity.class)));
                categoriaSelecionada = "alimentacao";
            }
        });
    }
}
