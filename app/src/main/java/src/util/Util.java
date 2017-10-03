package src.util;

import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import src.model.Frase;

/**
 * Created by Windows on 19/09/2017.
 */

public class Util {

    public static String KEY = "trnsl.1.1.20170916T163659Z.3c511aee14a614cd.2b9d38510d2b13f7f7efd9b2c6de74690eeec26f";

    public boolean isConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        //CHECAR COMO DAR UM PING
    }

    /*public Boolean isOnline() {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal==0);
            return reachable;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }*/

    public String urlBuilder(String key, String frase, String idiomas) {
        String fraseFinal = frase.replace(" ", "%20");
        return "https://translate.yandex.net/api/v1.5/tr.json/translate?key=" + key +
                "&text=" + fraseFinal + "&lang=" + idiomas;
    }

    public void makeToast(String text, Context context, int length) { // 0 para short e 1 para long
        Toast.makeText(context, text, length).show();
    }

    public boolean fieldIsNull(EditText text, Context context, String campoNome) {
        if(text == null || text.getText().toString().isEmpty()) {
            text.requestFocus();
            makeToast("O campo " + campoNome + " não pode ser vazio!", context, Toast.LENGTH_SHORT);
            return false;
        } else {
            return true;
        }
    }

    public void setFont(Button text, Context context) {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "Somatic-Rounded.ttf");
        text.setTypeface(font);
    }

    public void showButton(ImageView btn, Frase f) {
        if(f.isFavorito()) btn.setVisibility(View.VISIBLE);
        else btn.setVisibility(View.INVISIBLE);
    }

}
