package src.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import src.util.Util;

/**
 * Created by Windows on 05/10/2017.
 */

public class FragmentConfiguracao extends Fragment {

    private Spinner spnOriginal, spnTraducao;
    private Button btnSalvarConfigId;
    public static String idiomaOriginal = "portugues", idiomaTraducao = "ingles", codOriginal = "pt", codTraducao = "en";
    private Util util;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracao, container, false);


        spnOriginal = (Spinner) view.findViewById(R.id.spnOriginalId);
        spnTraducao = (Spinner) view.findViewById(R.id.spnTraducaoId);
        btnSalvarConfigId = (Button) view.findViewById(R.id.btnSalvarConfigId);

        String[] idiomasOriginal = new String[]{"Portugues"};
        String[] idiomasTraducao = new String[]{"Ingles", "Alemao"};

        ArrayAdapter<String> adapterOriginal = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, idiomasOriginal);
        ArrayAdapter<String> adapterTraducao = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, idiomasTraducao);

        spnOriginal.setAdapter(adapterOriginal);
        spnTraducao.setAdapter(adapterTraducao);

        btnSalvarConfigId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if("Ingles".equals(spnTraducao.getSelectedItem().toString())) {
                    idiomaTraducao = "ingles";
                    codTraducao = "en";


                } else if ("Alemao".equals(spnTraducao.getSelectedItem().toString())) {
                    idiomaTraducao = "alemao";
                    codTraducao = "de";
                }

                if("Portugues".equals(spnOriginal.getSelectedItem().toString())) {
                    idiomaOriginal = "portugues";
                    codOriginal = "pt";
                }

               Toast.makeText(getActivity(), "Idiomas salvos", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
