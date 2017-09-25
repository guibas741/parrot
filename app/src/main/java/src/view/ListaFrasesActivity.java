package src.view;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import java.util.ArrayList;
import java.util.Locale;

import src.controller.FraseAdapter;
import src.dao.Create;
import src.model.Frase;
import src.util.ItemClickSupport;

public class ListaFrasesActivity extends AppCompatActivity {

    private SQLiteDatabase db;
    private ListView listaFrases;
    private Cursor cursor;
    private ArrayAdapter<String> ad;
    private RecyclerView recyclerView;
    private FraseAdapter adapter;
    private ItemFraseActivity holder;
    private TextView traducaoSelecionada;
    private ImageView btnAudio, btnFav;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frases);
        buscarDados();
        configurarRecycler();

        traducaoSelecionada = (TextView) findViewById(R.id.traducaoSelecionadaId);
        btnAudio = (ImageView) findViewById(R.id.btnAudioId);
        btnFav = (ImageView) findViewById(R.id.favId);


        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Frase f = new Frase();
                ArrayList<Frase> frases = new ArrayList<Frase>();
                Create dao = new Create(getApplicationContext());
                frases = dao.getFrasesCategoria(CategoriasActivity.categoriaSelecionada);
                f = frases.get(position);
                traducaoSelecionada.setText(f.getFraseTraduzida());
                showStar(f);
            }
        });

        ItemClickSupport.addTo(recyclerView).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {


            @Override
            public boolean onItemLongClicked(final RecyclerView recyclerView, int position, View v) {
                final View view = v;
                Frase frase = new Frase();
                ArrayList<Frase> frases = new ArrayList<Frase>();
                Create dao1 = new Create(v.getContext());
                frases = dao1.getFrasesCategoria(CategoriasActivity.categoriaSelecionada);
                frase = frases.get(position);
                final Frase fraseSelecionada = frase;
                String pergunta = frase.isFavorito() == true ? " remover dos favoritos " : " favoritar ";
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja" + pergunta + " esta frase?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Create dao = new Create(view.getContext());
                                dao.favoritar(fraseSelecionada);
                                showStar(fraseSelecionada);
                                recyclerView.invalidate();
                            }
                        }).setNegativeButton("Cancelar", null).create() .show();

                return false;
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(traducaoSelecionada.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(v.getContext(), "APERTO", Toast.LENGTH_SHORT).show();
            }
        });


        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
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
        adapter = new FraseAdapter(dao.getFrasesCategoria(CategoriasActivity.categoriaSelecionada));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public void showStar(Frase f) {
        if(f.isFavorito()) btnFav.setVisibility(View.VISIBLE);
        else btnFav.setVisibility(View.INVISIBLE);
    }
}
