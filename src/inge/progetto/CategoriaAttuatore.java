package inge.progetto;

import java.util.ArrayList;

public class CategoriaAttuatore {
    private String nome;
    private String testoLibero;
    private ArrayList<ModalitaOperativa> modalita;

    public CategoriaAttuatore(String nome, String testoLibero) {
        this.nome = nome;
        this.testoLibero = testoLibero;
        this.modalita = new ArrayList<ModalitaOperativa>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTestoLibero() {
        return testoLibero;
    }

    public void setTestoLibero(String testoLibero) {
        this.testoLibero = testoLibero;
    }

    public ArrayList<ModalitaOperativa> getModalita() {
        return modalita;
    }

    public void setModalita(ArrayList<ModalitaOperativa> modalita) {
        this.modalita = modalita;
    }

    public void aggiungiModalitaOperativa(ModalitaOperativa mod) {
        if(!modalita.isEmpty()) {
            if(modalita.contains(mod))
                return;
            for (ModalitaOperativa m : modalita) {
                if(m.getNome().equals(mod.getNome())) {
                    return;
                }
            }
        }

        modalita.add(mod);
        System.out.println("Modalità aggiunta");
    }

    public String visualizzaCategoriaAttuatore() {
        String visualizza = "Nome Categoria: " + this.getNome() + ", testo libero: " + this.getTestoLibero() + ", lista modalità operative:\n";

        for (ModalitaOperativa lista: modalita) {
            visualizza +=  lista.getNome() + "\n";
        }

        return visualizza;
    }
}
