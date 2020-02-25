package inge.progetto;

public class Sensore {
    private String nome;
    private CategoriaSensore categoria;
    private Informazione rilevazione;
    private boolean stato;


    public Sensore(String nome, CategoriaSensore categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.stato = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaSensore getCategoria() {
        return categoria;
    }

    public Informazione getRilevazione() {
        return rilevazione;
    }

    public void setRilevazione(Informazione rilevazione) {
        this.rilevazione = rilevazione;
    }

    public boolean isAttivo() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }
}
