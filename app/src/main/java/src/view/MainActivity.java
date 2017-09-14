package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.parrot.parrot.R;

public class MainActivity extends AppCompatActivity {

    private Button btnCategorias, btnAddFrases, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controller);

        btnCategorias = (Button) findViewById(R.id.btnCategoriasId);
        btnAddFrases = (Button) findViewById(R.id.btnAddFrasesId);
        btnSair = (Button) findViewById(R.id.btnSairId);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnAddFrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdicionarFraseActivity.class));
            }
        });

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CategoriasActivity.class));
            }
        });
    }
}
