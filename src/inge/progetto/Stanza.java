package inge.progetto;

import java.util.ArrayList;

public class Stanza {
    private String nome;
    private ArrayList<Sensore> listaSensori;
    private ArrayList<Attuatore> listaAttuatori;
    private ArrayList<Artefatto> listaArtefatti;

    public Stanza(String nome) {
        this.nome = nome;
        listaSensori = new ArrayList<>();
        listaAttuatori = new ArrayList<>();
        listaArtefatti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Sensore> getListaSensori() {
        return listaSensori;
    }

    public ArrayList<Attuatore> getListaAttuatori() {
        return listaAttuatori;
    }


    public ArrayList<Artefatto> getListaArtefatti() {
        return listaArtefatti;
    }

    //TODO: decidere su eventuale segnalazione per corretta aggiunta di un elemento
    public void aggiungiSensore(Sensore sens) {
        for (Sensore s : listaSensori) {
            if (s.getCategoria().equals(sens.getCategoria()) || s.getNome().equals(sens.getNome()))
                return;
        }
        listaSensori.add(sens);
        System.out.println("Sensore aggiunto");

    }

    //TODO: segnalazione all'utente
    //TODO: Includere classe artefatto
    public void aggiungiArtefatto(Artefatto artefatto) {

    }

    public void aggiungiAttuatore(Attuatore a) {
        for (Attuatore lista : listaAttuatori) {
            if (lista.getCategoria().equals(a.getCategoria()) || a.getNome().equals(a.getNome()))
                return;
        }
        listaAttuatori.add(a);
        System.out.println("Attuatore aggiunto");

    }

    //TODO: descrizione della stanza da visualizzare all'utente
    public String visualizzaDisposizione() {
        return "Sistema Fuori Uso";
    }
}