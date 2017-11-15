package parrot.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.parrot.parrot.parrot.R;

import static com.parrot.parrot.parrot.R.id.txtYandexId;

/**
 * Created by Windows on 02/10/2017.
 */

public class FragmentMain extends Fragment {
    private static final String TAG = "FragmentMain";

    private Button btnCategorias, btnConfig, btnSair;
    private TextView txtYandex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        txtYandex =(TextView) view.findViewById(txtYandexId);
        txtYandex.setClickable(true);
        txtYandex.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://translate.yandex.com/'> Powered by Yandex.Translate </a>";
        txtYandex.setText(Html.fromHtml(text));

        btnCategorias = (Button) view.findViewById(R.id.btnCategoriaId);
        btnConfig = (Button) view.findViewById(R.id.btnConfigId);
        btnSair = (Button) view.findViewById(R.id.btnSairId);
        Log.d(TAG, "onCreateView started");

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}
