package src.model;

import java.util.ArrayList;

/**
 * Created by Windows on 04/09/2017.
 */

public class Categoria {
    private int id;
    private String titulo;
    private ArrayList<Frase> frases;

    public Categoria(int id, String titulo, ArrayList<Frase> frases) {
        this.id = id;
        this.titulo = titulo;
        this.frases = frases;
    }

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Frase> getFrases() {
        return frases;
    }

    public void setFrases(ArrayList<Frase> frases) {
        this.frases = frases;
    }
}
