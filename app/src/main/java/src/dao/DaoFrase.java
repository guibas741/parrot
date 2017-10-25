package src.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import src.model.Frase;

import static src.view.FragmentConfiguracao.idiomaOriginal;
import static src.view.FragmentConfiguracao.idiomaTraducao;

/**
 * Created by Windows on 09/09/2017.
 */

public class DaoFrase extends SQLiteOpenHelper {

    private static final String NOME_DB = "parrotDb";
    private static final int VERSAO_DB = 1;
    private static final String TABELA = "Frase";
    private static final String PATH_DB = "/data/user/0/src/database/parrotDb";
    private Context mContext;
    private SQLiteDatabase db;

    public DaoFrase(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
        this.mContext = context;
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         //createTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public boolean createTable() {
        openDB();
        String createTable = "CREATE TABLE IF NOT EXISTS " + TABELA + " (" +
                "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "original TEXT NOT NULL, " +
                "traducao TEXT NOT NULL, " +
                "categoria TEXT NOT NULL, " +
                "favorito TEXT, " +
                "idiomaOriginal TEXT NOT NULL," +
                "idiomaTraducao TEXT NOT NULL)";
        try {
            db.execSQL(createTable);
            openDB();
            try {
                insertLoad();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                db.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }

    }

    public void insertLoad() {
        FirstLoad fl = new FirstLoad();
        ArrayList<ContentValues> frases = fl.firstInsert();
        for(int i = 0; i < frases.size(); i ++) {
            db.insert(TABELA, null, frases.get(i));
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
            cv.put("idiomaOriginal", f.getIdiomaOriginal());
            cv.put("idiomaTraducao", f.getIdiomaTraducao());
            db.insert(TABELA, null, cv);
            return true;
        } catch (Exception e) {
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
            cv.put("idiomaOriginal", f.getIdiomaOriginal());
            cv.put("idiomaTraducao", f.getIdiomaTraducao());
            db.update(TABELA, cv, where, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }

    public void favoritar(Frase f) {
        openDB();

        try {
            ContentValues cv = new ContentValues();
            String where = "id = " + f.getId();

            String favoritou = f.isFavorito() == false ? "true" : "false";
            cv.put("favorito", favoritou);

            db.update(TABELA, cv, where, null);

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            db.close();
        }

    }

    public ArrayList<Frase> getFavoritos() {
        openDB();
        ArrayList<Frase> fArray = new ArrayList<>();
        String getFrases = "SELECT * FROM " + TABELA + " WHERE favorito = 'true' " +
                " AND idiomaOriginal = '" + idiomaOriginal + "' " +
                " AND idiomaTraducao = '" + idiomaTraducao +"'";

        try {
            Cursor c = db.rawQuery(getFrases, null);

            if (c.moveToFirst()) {
                do {
                    Frase f = new Frase();
                    f.setId(c.getInt(0));
                    f.setFraseOriginal(c.getString(1));
                    f.setFraseTraduzida(c.getString(2));
                    f.setCategoria(c.getString(3));
                    f.setFavorito(Boolean.parseBoolean(c.getString(4)));
                    f.setIdiomaOriginal(c.getString(5));
                    f.setIdiomaTraducao(c.getString(6));
                    fArray.add(f);
                } while (c.moveToNext());
                c.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            db.close();
        }

        return fArray;
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
                    f.setId(c.getInt(0));
                    f.setFraseOriginal(c.getString(1));
                    f.setFraseTraduzida(c.getString(2));
                    f.setCategoria(c.getString(3));
                    f.setFavorito(Boolean.parseBoolean(c.getString(4)));
                    f.setIdiomaOriginal(c.getString(5));
                    f.setIdiomaTraducao(c.getString(6));
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

    public ArrayList<Frase> getFrasesCategoria(String categoria) {
        openDB();
        ArrayList<Frase> fArray = new ArrayList<>();
        String getFrases =
                "SELECT * FROM " + TABELA + " " +
                "WHERE categoria = '" + categoria + "'" +
                " AND idiomaOriginal = '" + idiomaOriginal +
                "' AND idiomaTraducao = '" + idiomaTraducao +"'" ;

        try {
            Cursor c = db.rawQuery(getFrases, null);

            if(c.moveToFirst()) {
                do {
                    Frase f = new Frase();
                    f.setId(c.getInt(0));
                    f.setFraseOriginal(c.getString(1));
                    f.setFraseTraduzida(c.getString(2));
                    f.setCategoria(c.getString(3));
                    f.setFavorito(Boolean.parseBoolean(c.getString(4)));
                    f.setIdiomaOriginal(c.getString(5));
                    f.setIdiomaTraducao(c.getString(6));
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

    public Frase getFraseById(int id) {
        openDB();
        Frase f = new Frase();
        String getFrase = "SELECT * FROM " + TABELA + " where id = " + id;

        try {
            Cursor c = db.rawQuery(getFrase, null);

            if(c.moveToFirst()) {
                do {
                    f.setId(c.getInt(0));
                    f.setFraseOriginal(c.getString(1));
                    f.setFraseTraduzida(c.getString(2));
                    f.setCategoria(c.getString(3));
                    f.setFavorito(Boolean.parseBoolean(c.getString(4)));
                    f.setIdiomaOriginal(c.getString(5));
                    f.setIdiomaTraducao(c.getString(6));
                } while(c.moveToNext());
                c.close();
            }

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            db.close();
        }

        return f;
    }

    public void favTest(Frase f) {
        int id = f.getId();
        String getFraseSelecionada = "SELECT * FROM " + TABELA + " WHERE id = " + id;
        try {
            Cursor c = db.rawQuery(getFraseSelecionada, null);

            if(c.moveToNext()) {
                boolean favorito = f.isFavorito() == true ? false : true;
                f.setFavorito(favorito);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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
