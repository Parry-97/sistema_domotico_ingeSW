package inge.progetto;

public class Informazione {
    //rappresenta il range/dominio dell'informazione
    private String nome;
    private int  VALORE_MAX = Integer.MAX_VALUE;
    private int VALORE_MIN = 0;

    public Informazione(String nome) {
        this.nome = nome;
    }

    public void setVALORE_MAX(int VALORE_MAX) {
        this.VALORE_MAX = VALORE_MAX;
    }

    public void setVALORE_MIN(int VALORE_MIN) {
        this.VALORE_MIN = VALORE_MIN;
    }

    public int getValore() {
        return (int) (Math.random() * (this.VALORE_MAX - this.VALORE_MIN) + this.VALORE_MIN);
    }

    public int getVALORE_MAX() {
        return VALORE_MAX;
    }

    public int getVALORE_MIN() {
        return VALORE_MIN;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
