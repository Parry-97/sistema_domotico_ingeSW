package inge.progetto;

public class Informazione {
    private String nome;
    private int valore;

    public Informazione(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return nome;
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

    public int getValore() {
        return valore;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
