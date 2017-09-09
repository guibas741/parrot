package src.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import src.model.Frase;

/**
 * Created by Windows on 09/09/2017.
 */

public class Delete extends SQLiteOpenHelper{
    private static final String NOME_DB = "parrotDb";
    private static final int VERSAO_DB = 1;
    private static final String TABELA = "Frase";
    private static final String PATH_DB = "/data/user/0/src/database/parrotDb";
    private Context mContext;
    private SQLiteDatabase db;

    public Delete(Context context) {
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

    public boolean deleteFrase(Frase f) {
        openDB();

        String deleteFrase = "id = " + f.getId();

        try {
            db.delete(TABELA, deleteFrase, null);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }


    public void openDB() {
        if(!db.isOpen()) {
            db = mContext.openOrCreateDatabase(PATH_DB, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }

}
