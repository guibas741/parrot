package parrot.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.parrot.parrot.parrot.R;

import java.util.ArrayList;
import java.util.Locale;

import parrot.adapter.BottomNavigationViewHelper;
import parrot.adapter.FraseAdapter;
import parrot.dao.DaoFrase;
import parrot.model.Frase;
import parrot.util.ItemClickSupport;
import parrot.util.Util;

import static parrot.view.FragmentConfiguracao.idiomaTraducao;

public class ListaFrasesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView traducaoSelecionada;
    private ImageView btnAudio, btnFav;
    private TextToSpeech tts;
    private Util util;
    private Toolbar mActionBarToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frases);
        configurarRecycler();
        util = new Util();

        traducaoSelecionada = (TextView) findViewById(R.id.traducaoSelecionadaId);
        btnAudio = (ImageView) findViewById(R.id.btnAudioId);
        btnFav = (ImageView) findViewById(R.id.favId);

        String title = "  " + FragmentCategorias.categoriaSelecionada.toString().toUpperCase();
        mActionBarToolbar = (Toolbar) findViewById(R.id.toolCategoriasId);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle(title);
        mActionBarToolbar.setTitleTextColor(Color.WHITE);
        mActionBarToolbar.setLogo(R.mipmap.ic_launcher);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent = getIntent();
                String activity = intent.getStringExtra("from");
                switch(item.getItemId()) {
                    case R.id.action_add:
                        if(!"Add".equals(activity))startActivity(new Intent(getApplication(), AdicionarFraseActivity.class));
                        else finish();
                        break;
                    case R.id.favoritos:
                        if(!"Fav".equals(activity))startActivity(new Intent(getApplication(), ListaFavoritosActivity.class));
                        else finish();
                        break;
                    case R.id.exit:
                        finish();
                        break;
                }
                return false;
            }
        });



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
                    if("ingles".equals(idiomaTraducao)) {
                        tts.setLanguage(Locale.ENGLISH);
                    } else if("alemao".equals(idiomaTraducao)) {
                        tts.setLanguage(Locale.GERMAN);
                    }
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
}
