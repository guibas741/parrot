package src.view;

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
import java.util.ArrayList;

import src.dao.Create;
import src.model.Frase;

public class AdicionarFraseActivity extends AppCompatActivity {

    private Button btnAddFrase, btnListar, btnTraduzir;
    private EditText txtFraseOriginal, txtFraseTraduzida;
    private CheckBox favorito;
    private Spinner spnCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_frase);

        btnAddFrase = (Button) findViewById(R.id.btnAddFrasesId);
        btnListar = (Button) findViewById(R.id.btnListarId);
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

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Create r = new Create(getApplicationContext());
                ArrayList<Frase> fArray = r.getFrases();
                for (int i = 0; i < fArray.size(); i++) {
                    Frase f = fArray.get(i);
                    System.out.println("ID = " + f.getId() +
                            "\n FRASE = " + f.getFraseOriginal() +
                            "\n TRADUCAO = " + f.getFraseTraduzida() +
                            "\n CATEGORIA = " + f.getCategoria() +
                            "\n FAVORITA = " + f.isFavorito() +
                            "\n -----------------------------------");
                }

                startActivity(new Intent(getApplicationContext(), ListaFrasesActivity.class));
            }
        });

        btnTraduzir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONTask().execute("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20170916T163659Z.3c511aee14a614cd.2b9d38510d2b13f7f7efd9b2c6de74690eeec26f&text="+txtFraseOriginal.getText().toString()+"&lang=pt-en");

            }
        });
    }


    public class JSONTask extends AsyncTask<String, String, String> {

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

                /*String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("movies");

                JSONObject finalObject = parentArray.getJSONObject(0);

                String movieName = finalObject.getString("movie");
                int year = finalObject.getInt("year");

                return movieName + " - " + year;*/

                //PARSIN JSON WITHOUT KEY
                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray aa = parentObject.getJSONArray("text");
                String foo = aa.getString(0);
                //int aa = itemArray.length();
                //String foo = itemArray.getString(0);

                System.out.println("JSON = ");


                return foo;//buffer.toString();

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
            txtFraseTraduzida.setText(result.toString());
        }
    }


}
