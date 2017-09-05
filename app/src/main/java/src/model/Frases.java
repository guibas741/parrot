package src.model;

/**
 * Created by Windows on 04/09/2017.
 */

public class Frases {
    private int id;
    private String fraseOriginal;
    private String fraseTraduzida;
    private int favorita;
    private Categoria categoria;

    public Frases(int id, String fraseOriginal, String fraseTraduzida, int favorita, Categoria categoria) {
        this.id = id;
        this.fraseOriginal = fraseOriginal;
        this.fraseTraduzida = fraseTraduzida;
        this.favorita = favorita;
        this.categoria = categoria;
    }

    public Frases() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFraseOriginal() {
        return fraseOriginal;
    }

    public void setFraseOriginal(String fraseOriginal) {
        this.fraseOriginal = fraseOriginal;
    }

    public String getFraseTraduzida() {
        return fraseTraduzida;
    }

    public void setFraseTraduzida(String fraseTraduzida) {
        this.fraseTraduzida = fraseTraduzida;
    }

    public int getFavorita() {
        return favorita;
    }

    public void setFavorita(int favorita) {
        this.favorita = favorita;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
