package src.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import src.model.Frase;

/**
 * Created by Windows on 09/09/2017.
 */

public class Read extends SQLiteOpenHelper{
    private static final String NOME_DB = "parrotDb";
    private static final int VERSAO_DB = 1;
    private static final String TABELA = "Frase";
    private static final String PATH_DB = "/data/user/0/src/database/parrotDb";
    private Context mContext;
    private SQLiteDatabase db;

    public Read(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Frase> getFrases() {
        openDB();
        ArrayList<Frase> fArray = new ArrayList<>();
        String getFrases = "SELECT * FROM " + TABELA;

        try {
            Cursor c = db.rawQuery(getFrases, null);

            if(c.moveToFirst()) {
                do {
                    Frase f = new Frase();
                    f.setFraseOriginal(c.getString(0));
                    f.setFraseTraduzida(c.getString(1));
                    f.setCategoria(c.getString(3));
                    f.setFavorito(Boolean.parseBoolean(c.getString(4)));
                    fArray.add(f);
                } while(c.moveToNext());
                c.close();
            }

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            db.close();
        }

        return fArray;
    }


    public void openDB() {
        if(!db.isOpen()) {
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }
}
