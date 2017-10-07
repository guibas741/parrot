package src.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.android.parrot.parrot.R;

import static com.android.parrot.parrot.R.id.btnAlimentacaoId;
import static com.android.parrot.parrot.R.id.btnComumId;
import static com.android.parrot.parrot.R.id.btnLocalizacaoId;
import static com.android.parrot.parrot.R.id.btnSaudeId;

/**
 * Created by Windows on 02/10/2017.
 */

public class FragmentCategorias extends Fragment implements View.OnClickListener{
    private static final String TAG = "FragmentCategorias";

    private ImageButton btnSaude, btnAlimentacao, btnLocalizacao, btnComum;
    public static String categoriaSelecionada;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorias, container, false);

        btnSaude = (ImageButton) view.findViewById(btnSaudeId);
        btnAlimentacao = (ImageButton) view.findViewById(btnAlimentacaoId);
        btnLocalizacao = (ImageButton) view.findViewById(btnLocalizacaoId);;
        btnComum = (ImageButton) view.findViewById(btnComumId);

        btnSaude.setOnClickListener(this);
        btnAlimentacao.setOnClickListener(this);
        btnLocalizacao.setOnClickListener(this);
        btnComum.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case btnSaudeId:
                categoriaSelecionada = "saude";
                break;
            case btnAlimentacaoId:
                categoriaSelecionada = "alimentacao";
                break;
            case btnLocalizacaoId:
                categoriaSelecionada = "localizacao";
                break;
           /* case btnFavoritosId:
                categoriaSelecionada = "favoritos";
                break;*/
            case btnComumId:
                categoriaSelecionada = "comum";
                break;

        }
        if("favoritos".equals(categoriaSelecionada)) {
            startActivity(new Intent(getActivity(), ListaFavoritosActivity.class));
        } else {
            startActivity(new Intent(getActivity(), ListaFrasesActivity.class));
        }

    }


}
