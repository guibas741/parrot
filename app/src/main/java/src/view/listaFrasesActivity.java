package src.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import java.util.ArrayList;

import src.controller.FraseAdapter;
import src.dao.Create;
import src.model.Frase;
import src.util.ItemClickSupport;

public class listaFrasesActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private ListView listaFrases;
    private Cursor cursor;
    private ArrayAdapter<String> ad;
    private RecyclerView recyclerView;
    private FraseAdapter adapter;
    private ItemFraseActivity holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frases);
        buscarDados();
        configurarRecycler();



        ItemClickSupport.addTo(recyclerView).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
                Frase f = new Frase();
                ArrayList<Frase> frases = new ArrayList<Frase>();
                Create dao = new Create(getApplicationContext());
                frases = dao.getFrases();
                f = frases.get(position);
                //holder.frase.setText(f.getFraseTraduzida());
                Toast.makeText(v.getContext(), "TRADUÇÃO =  " + f.getFraseTraduzida(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void buscarDados() {
        try {
            db = openOrCreateDatabase("parrotDb", Context.MODE_PRIVATE, null);
            cursor = db.rawQuery("SELECT * FROM Frase", null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void criarListagem() {
        listaFrases = (ListView) findViewById(R.id.listaFrasesId);
        int indiceColunaId = cursor.getColumnIndex("id");
        int indiceColunaOriginal = cursor.getColumnIndex("original");
        int indiceColunaTraducao = cursor.getColumnIndex("traducao");
        int indiceColunaCategoria = cursor.getColumnIndex("categoria");
        int indiceColunaFavorito = cursor.getColumnIndex("favorito");
        try {
            ArrayList<String> frases = new ArrayList<String>();
            ArrayList<String> traducoes = new ArrayList<String>();
            ad = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    frases
            );

            listaFrases.setAdapter(ad);

            //LISTAR TAREFAS
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - ", "Tarefa " + cursor.getString(indiceColunaOriginal));
                frases.add(cursor.getString(indiceColunaOriginal));
                traducoes.add(cursor.getString(indiceColunaTraducao));
                //ADICIONAR O RESTO DEPOIS NAO ESQUECE
                //add(Integer.parseInt(cursor.getString(indiceColunaId)));
                cursor.moveToNext();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.listaFrasesId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        Create dao = new Create(this);
        adapter = new FraseAdapter(dao.getFrases());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
