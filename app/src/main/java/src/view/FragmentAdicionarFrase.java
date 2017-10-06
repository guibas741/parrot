package src.view;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.parrot.parrot.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import src.dao.DaoFrase;
import src.model.Frase;
import src.util.Util;

/**
 * Created by Windows on 02/10/2017.
 */

public class FragmentAdicionarFrase extends Fragment {
    private static final String TAG = "FragmentAdicionar";

    private Button btnAddFrase, btnCategorias, btnTraduzir;
    private EditText txtFraseOriginal, txtFraseTraduzida;
    private CheckBox favorito;
    private Spinner spnCategoria;
    private Util util;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adicionar_frase, container, false);

        util = new Util();
        btnAddFrase = (Button) view.findViewById(R.id.btnAddFrasesId);
        btnCategorias = (Button) view.findViewById(R.id.btnCategoriaId);
        btnTraduzir = (Button) view.findViewById(R.id.btnTraduzirId);

        txtFraseOriginal = (EditText) view.findViewById(R.id.txtFraseOriginalId);
        txtFraseTraduzida = (EditText) view.findViewById(R.id.txtFraseTraduzidaId);

        favorito = (CheckBox) view.findViewById(R.id.favoritoId);

        DaoFrase c = new DaoFrase(view.getContext());
        c.createTable();

        spnCategoria = (Spinner) view.findViewById(R.id.spnCategoriaId);

        String[] items = new String[]{"saude", "alimentacao", "localizacao", "comum", "personalizado"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);

        spnCategoria.setAdapter(adapter);


        btnAddFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean campoTexto = util.fieldIsNull(txtFraseOriginal, v.getContext(), "Frase Original");
                boolean campoTraducao = util.fieldIsNull(txtFraseTraduzida, v.getContext(), "Tradução");
                if(campoTexto && campoTraducao) {
                    Frase f = new Frase();
                    f.setFraseOriginal(txtFraseOriginal.getText().toString());
                    f.setFraseTraduzida(txtFraseTraduzida.getText().toString());
                    f.setCategoria(spnCategoria.getSelectedItem().toString());
                    f.setFavorito(favorito.isChecked());

                    DaoFrase c = new DaoFrase(v.getContext());

                    if (c.insertFrase(f)) {
                        util.makeToast("Frase inserida com sucesso", v.getContext(), Toast.LENGTH_LONG);
                    } else {
                        util.makeToast("Frase não inserida", v.getContext(), Toast.LENGTH_LONG);
                    }
                }
            }
        });

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        btnTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean campoTexto = util.fieldIsNull(txtFraseOriginal, v.getContext(), "Frase Original");
                if(campoTexto) {

                    boolean connected = util.isConnected(v.getContext());

                    if (connected) {
                        String fraseString = txtFraseOriginal.getText().toString();
                        String yandexUrl = util.urlBuilder(util.KEY, fraseString);
                        new JSONTask().execute(yandexUrl);
                    } else {
                        util.makeToast("É necessário estar conectado na internet para utilizar a funcionalidade de tradução", v.getContext(), Toast.LENGTH_SHORT);
                    }
                }
            }
        });

        return view;
    }

    public class JSONTask extends AsyncTask<String, String, String> {
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(getActivity());
            pd.setMessage("Traduzindo");
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";
                while((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                //PARSIN JSON WITHOUT KEY
                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray aa = parentObject.getJSONArray("text");
                String traducao = aa.getString(0);

                return traducao;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) connection.disconnect();
                try {
                    if (reader != null) reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (pd != null) pd.dismiss();
            txtFraseTraduzida.setText(result.toString());
        }
    }
}
