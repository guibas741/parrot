package parrot.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parrot.parrot.parrot.R;

import java.util.ArrayList;
import java.util.Locale;

import parrot.adapter.FraseAdapter;
import parrot.dao.DaoFrase;
import parrot.model.Frase;
import parrot.util.ItemClickSupport;
import parrot.util.Util;

/**
 * Created by Windows on 04/10/2017.
 */

public class FragmentListaFavoritos extends Fragment {
    private static final String TAG = "FragmentFavoritos";

    private RecyclerView recyclerView;
    private TextView traducaoSelecionada;
    private ImageView btnAudio, btnFav;
    private TextToSpeech tts;
    private Util util;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_favoritos, container, false);
        configurarRecycler();
        util = new Util();

        traducaoSelecionada = (TextView) view.findViewById(R.id.traducaoSelecionadaId);
        btnAudio = (ImageView) view.findViewById(R.id.btnAudioId);
        btnFav = (ImageView) view.findViewById(R.id.favId);


        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Frase frase = new Frase();
                ArrayList<Frase> frases = new ArrayList<Frase>();
                DaoFrase dao = new DaoFrase(getActivity());
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


        tts = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.ENGLISH);
                }
            }
        });

        return view;
    }

    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.listaFrasesId);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        DaoFrase dao = new DaoFrase(getContext());
        FraseAdapter adapter = new FraseAdapter(dao.getFavoritos());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    public void showStar(Frase f) {
        if(f.isFavorito()) btnFav.setVisibility(View.VISIBLE);
        else btnFav.setVisibility(View.INVISIBLE);
    }
}
