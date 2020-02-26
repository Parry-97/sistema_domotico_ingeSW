package inge.progetto;

public class Attuatore {
    private String nome;
    private CategoriaAttuatore categoria;
    private String modalitaAttuale;
    private boolean stato;

    public Attuatore(String nome, CategoriaAttuatore categoria, String modalitaAttuale) {
        this.nome = nome;
        this.categoria = categoria;
        this.modalitaAttuale = modalitaAttuale;
        this.stato = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaAttuatore getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaAttuatore categoria) {
        this.categoria = categoria;
    }

    public String getModalitaAttuale() {
        return modalitaAttuale;
    }

    public void setModalitaAttuale(String nuovaModalita) {
        if(this.modalitaAttuale.equals(nuovaModalita)) {
            System.out.println("Sei già in questa modalità");
            return;
        }
        for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
            if(mod.getNome().equals(nuovaModalita)) {
                this.modalitaAttuale = nuovaModalita;
                System.out.println("Nuova modalità");
                return;
            }
        }
        System.out.println("Questa modalità non esiste per questo attuatore");
    }

    public boolean getStato() {
        return stato;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

}
