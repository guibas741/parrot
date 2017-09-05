package src.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.parrot.parrot.R;

public class MainController extends AppCompatActivity {

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

    }
}
