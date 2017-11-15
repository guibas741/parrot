package parrot.model;

/**
 * Created by Windows on 04/09/2017.
 */

public class Frase {
    private int id;
    private String fraseOriginal;
    private String fraseTraduzida;
    private boolean favorito;
    private String categoria;
    private String idiomaOriginal;
    private String idiomaTraducao;

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public String getIdiomaTraducao() {
        return idiomaTraducao;
    }

    public void setIdiomaTraducao(String idiomaTraducao) {
        this.idiomaTraducao = idiomaTraducao;
    }

    public Frase(int id, String fraseOriginal, String fraseTraduzida, boolean favorito, String categoria, String idiomaOriginal, String idiomaTraducao) {
        this.id = id;
        this.fraseOriginal = fraseOriginal;
        this.fraseTraduzida = fraseTraduzida;
        this.favorito = favorito;
        this.categoria = categoria;
        this.idiomaOriginal = idiomaOriginal;
        this.idiomaTraducao = idiomaTraducao;
    }

    public Frase() {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
