package inge.progetto;

public class ModalitaOperativa {
    private String nome;
    private int paramentro;

    public ModalitaOperativa(String nome, int paramentro) {
        this.nome = nome;
        this.paramentro = paramentro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getParamentro() {
        return paramentro;
    }

    public void setParamentro(int paramentro) {
        this.paramentro = paramentro;
    }
}
