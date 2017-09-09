package src.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import src.model.Frase;

/**
 * Created by Windows on 09/09/2017.
 */

public class Create extends SQLiteOpenHelper {

    private static final String NOME_DB = "parrotDb";
    private static final int VERSAO_DB = 1;
    private static final String TABELA = "Frase";
    private static final String PATH_DB = "/data/user/0/src/database/parrotDb";
    private Context mContext;
    private SQLiteDatabase db;

    public Create(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean createTable() {
        openDB();
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABELA + " (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "original TEXT NOT NULL, " +
                "traducao TEXT NOT NULL, " +
                "categoria TEXT NOT NULL, " +
                "favorito TEXT)";
        try {
            db.execSQL(createTable);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }

    }

    public boolean updateFrase(Frase f) {
        openDB();
        try {
            String where = "id = " + f.getId();
            ContentValues cv = new ContentValues();
            cv.put("original", f.getFraseOriginal());
            cv.put("traducao", f.getFraseTraduzida());
            cv.put("categoria", f.getCategoria());
            cv.put("favorito", String.valueOf(f.isFavorito()));
            db.update(TABELA, cv, where, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }

    public boolean insertFrase(Frase f) {
        openDB();
        try {
            ContentValues cv = new ContentValues();
            cv.put("original", f.getFraseOriginal());
            cv.put("traducao", f.getFraseTraduzida());
            cv.put("categoria", f.getCategoria());
            cv.put("favorito", String.valueOf(f.isFavorito()));
            db.insert(TABELA, null, cv);
            return true;
        } catch (Exception e) {
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
