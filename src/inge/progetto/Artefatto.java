package inge.progetto;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    private ModalitaOperativa statoAttuale;
    private ArrayList<Sensore> listaSensori;
    private ArrayList<Attuatore> listaAttuatori;

    //L'aggiunta di stato attuale permette di definirne una sorta di stato/modalità operativa di Default
    public Artefatto(String nome, ModalitaOperativa statoAttuale) {
        this.statoAttuale = statoAttuale;
        this.nome = nome;
        this.listaSensori = new ArrayList<Sensore>();
        this.listaAttuatori = new ArrayList<Attuatore>();
    }

    public ModalitaOperativa getStatoAttuale() {
        return statoAttuale;
    }

    public void setStatoAttuale(ModalitaOperativa statoAttuale) {
        this.statoAttuale = statoAttuale;
        for (Sensore s: listaSensori) {
            s.setRilevazione(statoAttuale);
        }
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

    public void setListaSensori(ArrayList<Sensore> listaSensori) {
        this.listaSensori = listaSensori;
    }

    public ArrayList<Attuatore> getListaAttuatori() {
        return listaAttuatori;
    }

    public void setListaAttuatori(ArrayList<Attuatore> listaAttuatori) {
        this.listaAttuatori = listaAttuatori;
    }

    public void aggiungiSensore(Sensore s) {

        if (s.getCategoria().isFisico()) {
            System.out.println("\n !!! Non è possibile collegare tale sensore all'artefatto scelto !!!");
            return;
        }

        if(!listaSensori.isEmpty()) {
            for (Sensore sensore : listaSensori) {
                if (sensore.getNome().equals(s.getNome()) || sensore.getCategoria().getNome().equals(s.getCategoria().getNome())) {
                    return;
                }
            }
        }
        s.setRilevazione(this.statoAttuale);
        listaSensori.add(s);
        System.out.println("Sensore aggiunto");
    }

    public void aggiungiAttuatore(Attuatore a) {
        if(!listaAttuatori.isEmpty()) {
            for (Attuatore attuatore : listaAttuatori) {
                if (attuatore.getNome().equals(a.getNome()) || attuatore.getCategoria().getNome().equals(a.getCategoria().getNome())) {
                    return;
                }
            }
        }

        listaAttuatori.add(a);
        a.setMonitorato(this);
        System.out.println("Attuatore aggiunto");
    }

    public String visualizzaDispositivi() {
        String visualizza = "Nome Artefatto: " + this.getNome() + ", lista attuatori che lo comandano:\n";

        for (Attuatore a: listaAttuatori) {
            visualizza +=  a.getNome() + ", categoria: " + a.getCategoria().getNome() + ", modalità attuale: " + a.getModalitaAttuale().getNome() + "\n";
        }

        visualizza += "E dispone dei seguenti sensori:\n";
        for (Sensore s: listaSensori) {
            visualizza +=  s.getNome() + ", categoria: " + s.getCategoria().getNome();
            if (s.getCategoria().isFisico())
                 visualizza += "Misura: " +  s.getRilevazione().getValore() + "\n";
            else
                visualizza += "Stato: " + s.getRilevazione().getNome() + "\n";
        }

        return visualizza;
    }
}
