package inge.progetto;

public class Attuatore {
    private String nome;
    private CategoriaAttuatore categoria;
    private ModalitaOperativa modalitaAttuale;
    private boolean stato;

    public Attuatore(String nome, CategoriaAttuatore categoria, ModalitaOperativa modalitaAttuale) {
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

    public ModalitaOperativa getModalitaAttuale() {
        return modalitaAttuale;
    }
/*
    public void setModalitaAttuale(String nuovaModalita, int valore) { //effettuare controlli riguardo al valore che rientri nei limiti del dato, dalla versione 2 in poi
        if(this.modalitaAttuale.getNome().equals(nuovaModalita)) {
            System.out.print("Sei già in questa modalità, ");
            if(!(this.modalitaAttuale.getParamentro() == valore)) {
                System.out.println("ma valore modificato correttamente");
                this.modalitaAttuale.setParamentro(valore);
            } else
                System.out.println(" ed è stato impostato lo stesso valore già esistente");
            return;
        }
        for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
            if(mod.getNome().equals(nuovaModalita)) {
                this.modalitaAttuale.setNome(nuovaModalita);
                if(!(this.modalitaAttuale.getParamentro() == valore))
                    this.modalitaAttuale.setParamentro(valore);
                else
                    System.out.println("è stato impostato lo stesso valore già esistente");
                System.out.println("Nuova modalità");
                return;
            }
        }
        System.out.println("Questa modalità non esiste per questo attuatore");
    }
*/

    public void setModalitaAttuale(String nuovaModalita) {
        if(this.modalitaAttuale.getNome().equals(nuovaModalita)) {
            System.out.print("Sei già in questa modalità");
            return;
        }
        for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
            if(mod.getNome().equals(nuovaModalita)) {
                this.modalitaAttuale = mod;
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
