package src.model;

/**
 * Created by Windows on 04/09/2017.
 */

public class Categoria {
    private int id;
    private String tituloBanco;
    private String titulo;

    public Categoria(int id, String titulo, String tituloBanco) {
        this.id = id;
        this.titulo = titulo;
        this.tituloBanco = tituloBanco;
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

    public String getTituloBanco() {
        return tituloBanco;
    }

    public void setTituloBanco(String tituloBanco) {
        this.tituloBanco = tituloBanco;
    }

}
