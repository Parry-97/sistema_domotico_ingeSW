package inge.progetto;

import java.util.ArrayList;

public class UnitaImmobiliare {
    private ArrayList<Stanza> listaStanze;
    private ArrayList<Artefatto> listaArtefatti;
    private String tipo;

    public UnitaImmobiliare(String tipo) {
        this.listaArtefatti = new ArrayList<>();
        this.listaStanze = new ArrayList<>();
        this.tipo = tipo;
    }

    public UnitaImmobiliare() {
        this.tipo = "";
    }

    public ArrayList<Stanza> getListaStanze() {
        return listaStanze;
    }

    public void setListaStanze(ArrayList<Stanza> listaStanze) {
        this.listaStanze = listaStanze;
    }

    public ArrayList<Artefatto> getListaArtefatti() {
        return listaArtefatti;
    }

    public void setListaArtefatti(ArrayList<Artefatto> listaArtefatti) {
        this.listaArtefatti = listaArtefatti;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void aggiungiStanza(Stanza s) {
        for (Stanza stanza : listaStanze) {
            if (stanza.getNome().equals(s.getNome())) {
                System.out.println("Stanza già presente");
                return;
            }
        }
        listaStanze.add(s);
        System.out.println("Stanza aggiunta");
    }

    public void aggiungiArtefatto(Artefatto a) { //questi Artefatti sono esterni alle stanze, ad esempio cancelli, lampade da esterni ecc..
        for (Artefatto artefatto : listaArtefatti) {
            if (artefatto.getNome().equals(a.getNome())) {
                System.out.println("Artefatto già presente");
                return;
            }
        }
        listaArtefatti.add(a);
        System.out.println("Artefatto aggiunto");

    }

    public String visualizzaDescrizione() {
        String visualizza = "Tipo unità immobiliare: " + this.getTipo() + ", è costituita dalle seguenti stanze:\n";

        for (Stanza stanza : listaStanze) {
            visualizza += stanza.visualizzaDisposizione();
        }

        visualizza += "\nArtefatti esterni all'unità immobiliare:\n";
        for(Stanza stanza : listaStanze) {
            for (Artefatto artefatto : listaArtefatti) {
                if(!stanza.getListaArtefatti().contains(artefatto))
                    visualizza += artefatto.visualizzaDispositivi();
            }
        }
        return visualizza;
    }

}
