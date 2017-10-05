package src.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import java.util.ArrayList;
import java.util.Locale;

import src.controller.BottomNavigationViewHelper;
import src.controller.FraseAdapter;
import src.dao.DaoFrase;
import src.model.Frase;
import src.util.ItemClickSupport;
import src.util.Util;

public class ListaFrasesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView traducaoSelecionada;
    private ImageView btnAudio, btnFav;
    private TextToSpeech tts;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frases);
        configurarRecycler();
        util = new Util();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.action_add:
                        startActivity(new Intent(getApplication(), AdicionarFraseActivity.class));
                        break;
                    case R.id.favoritos:
                        startActivity(new Intent(getApplication(), ListaFavoritosActivity.class));
                        break;
                    case R.id.exit:
                        Toast.makeText(getApplication(),"fechou", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });



        traducaoSelecionada = (TextView) findViewById(R.id.traducaoSelecionadaId);
        btnAudio = (ImageView) findViewById(R.id.btnAudioId);
        btnFav = (ImageView) findViewById(R.id.favId);


        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Frase frase = new Frase();
                ArrayList<Frase> frases = new ArrayList<Frase>();
                DaoFrase dao = new DaoFrase(getApplicationContext());
                frases = dao.getFrasesCategoria(FragmentCategorias.categoriaSelecionada);
                frase = frases.get(position);
                traducaoSelecionada.setText(frase.getFraseTraduzida());
                util.showButton(btnFav, frase);
            }
        });

        ItemClickSupport.addTo(recyclerView).setOnItemLongClickListener(new ItemClickSupport.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(final RecyclerView recyclerView, int position, View v) {
                final View view = v;
                Frase fraseSelecionada = new Frase();
                ArrayList<Frase> frases = new ArrayList<Frase>();
                DaoFrase daoFrase = new DaoFrase(v.getContext());
                frases = daoFrase.getFrasesCategoria(FragmentCategorias.categoriaSelecionada);
                fraseSelecionada = frases.get(position);
                final Frase fraseFinal = fraseSelecionada;

                String pergunta = fraseSelecionada.isFavorito() == true ? " remover dos favoritos " : " favoritar ";

                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Confirmação")
                        .setMessage("Tem certeza que deseja" + pergunta + " esta frase?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DaoFrase dao = new DaoFrase(view.getContext());
                                dao.favoritar(fraseFinal);
                                util.showButton(btnFav, fraseFinal);
                            }
                        }).setNegativeButton("Cancelar", null).create() .show();

                return false;
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tts.speak(traducaoSelecionada.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
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

    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.listaFrasesId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        DaoFrase dao = new DaoFrase(this);
        FraseAdapter adapter = new FraseAdapter(dao.getFrasesCategoria(FragmentCategorias.categoriaSelecionada));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public void showStar(Frase f) {
        if(f.isFavorito()) btnFav.setVisibility(View.VISIBLE);
        else btnFav.setVisibility(View.INVISIBLE);
    }
}
