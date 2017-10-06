package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.parrot.parrot.R;

import src.controller.BottomNavigationViewHelper;
import src.controller.FraseAdapter;
import src.dao.DaoFrase;

public class ListaFavoritosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FraseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_favoritos);
        configurarRecycler();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = getIntent();
                String activity = intent.getStringExtra("from");

                switch(item.getItemId()) {
                    case R.id.action_add:
                        if(!"Add".equals(activity)) startActivity(new Intent(getApplication(), AdicionarFraseActivity.class).putExtra("from", "Fav"));
                        else finish();
                        break;
                    case R.id.favoritos:
                        //startActivity(new Intent(getApplication(), ListaFavoritosActivity.class));
                        break;
                    case R.id.exit:
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.listaFavoritosId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        DaoFrase dao = new DaoFrase(this);
        adapter = new FraseAdapter(dao.getFavoritos());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
