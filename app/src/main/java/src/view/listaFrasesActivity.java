package src.view;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.parrot.parrot.R;

import java.util.ArrayList;

public class listaFrasesActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private ListView listaFrases;
    private Cursor cursor;
    private ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frases);
        buscarDados();
        criarListagem();

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
}
