package src.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

import src.dao.Create;
import src.model.Frase;
import src.util.Util;

public class AdicionarFraseActivity extends AppCompatActivity {

    private Button btnAddFrase, btnCategorias, btnTraduzir;
    private EditText txtFraseOriginal, txtFraseTraduzida;
    private CheckBox favorito;
    private Spinner spnCategoria;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_frase);

        util = new Util();
        btnAddFrase = (Button) findViewById(R.id.btnAddFrasesId);
        btnCategorias = (Button) findViewById(R.id.btnCategoriaId);
        btnTraduzir = (Button) findViewById(R.id.btnTraduzirId);

        txtFraseOriginal = (EditText) findViewById(R.id.txtFraseOriginalId);
        txtFraseTraduzida = (EditText) findViewById(R.id.txtFraseTraduzidaId);

        favorito = (CheckBox) findViewById(R.id.favoritoId);

        Create c = new Create(getApplicationContext());
        c.createTable();

        spnCategoria = (Spinner) findViewById(R.id.spnCategoriaId);

        String[] items = new String[]{"saude", "alimentacao", "localizacao", "comum", "personalizado"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);

        spnCategoria.setAdapter(adapter);


        btnAddFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Frase f = new Frase();
                f.setFraseOriginal(txtFraseOriginal.getText().toString());
                f.setFraseTraduzida(txtFraseTraduzida.getText().toString());
                f.setCategoria(spnCategoria.getSelectedItem().toString());
                f.setFavorito(favorito.isChecked());

                Create c = new Create(getApplicationContext());

                if(c.insertFrase(f)) {
                    Toast.makeText(getApplicationContext(), "Frase inserida com sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Frase NAO INSERIDA", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CategoriasActivity.class));
            }
        });

        btnTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean connected = util.isConnected(v.getContext());
                if(connected) {
                    String fraseString = txtFraseOriginal.getText().toString();
                    String fraseFinal = fraseString.replace(" ", "%20");
                    String idiomas = "pt-en";
                    String yandexUrl = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="+util.KEY+"&text=" + fraseFinal + "&lang=" + idiomas;
                    new JSONTask().execute(yandexUrl);
                } else {
                    Toast.makeText(v.getContext(), "É necessário estar conectado na internet para utilizar a funcionalidade " +
                            "de tradução", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public class JSONTask extends AsyncTask<String, String, String> {
        ProgressDialog pd;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(AdicionarFraseActivity.this);
            pd.setMessage("loading");
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
                String foo = aa.getString(0);

                return foo;

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
