package inge.progetto;

import java.util.ArrayList;

public class Stanza {

     //TODO: listaAttuatori e listaArtefatti

    private String nome;
    private ArrayList<Sensore> listaSensori;
    private ArrayList<Object> listaAttuatori;
    private ArrayList<Object> listaArtefatti;

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

    public ArrayList<Object> getListaAttuatori() {
        return listaAttuatori;
    }


    public ArrayList<Object> getListaArtefatti() {
        return listaArtefatti;
    }

    //TODO: decidere su eventuale segnalazione per corretta aggiunta di un elemento
    public void aggiungiSensore(Sensore sens) {
        for (Sensore s : listaSensori) {
            if (s.getCategoria().equals(sens.getCategoria()) || s.getNome().equals(sens.getNome()))
                return;
        }

        listaSensori.add(sens);
    }

    //TODO: segnalazione all'utente
    //TODO: Includere classe artefatto
    public void aggiungiArtefatto(Object artefatto) {

    }

    //TODO:  segnalazione utente
    //TODO: Inclusione classe attuatore
    public void aggiungiAttuatore(Object attuatore) {

    }

    //TODO: descrizione della stanza da visualizzare all'utente
    public String visualizzaDisposizione() {
        return "Sistema Fuori Uso";
    }
}