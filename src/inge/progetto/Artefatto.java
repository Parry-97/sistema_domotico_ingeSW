package inge.progetto;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    private ArrayList<Sensore> listaSensori;
    private ArrayList<Attuatore> listaAttuatori;

    public Artefatto() {}

    public Artefatto(String nome) {
        this.nome = nome;
        this.listaSensori = new ArrayList<Sensore>();
        this.listaAttuatori = new ArrayList<Attuatore>();
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
        if(!listaSensori.isEmpty()) {
            for (Sensore lista : listaSensori) {
                if (lista.getNome().equals(s.getNome()) || lista.getCategoria().getNome().equals(s.getCategoria().getNome())) {
                    return;
                }
            }
        }

        listaSensori.add(s);
        System.out.println("Sensore aggiunto");
    }

    public void aggiungiAttuatore(Attuatore a) {
        if(!listaAttuatori.isEmpty()) {
            for (Attuatore lista : listaAttuatori) {
                if (lista.getNome().equals(a.getNome()) || lista.getCategoria().getNome().equals(a.getCategoria().getNome())) {
                    return;
                }
            }
        }

        listaAttuatori.add(a);
        System.out.println("Attuatore aggiunto");
    }

    public String visualizzaDispositivi() {
        String visualizza = "Nome Artefatto: " + this.getNome() + ", lista attuatori che lo comandano:\n";

        for (Attuatore a: listaAttuatori) {
            visualizza +=  a.getNome() + ", categoria: " + a.getCategoria().getNome() + ", modalità attuale: " + a.getModalitaAttuale() + "\n";
        }

        visualizza += "E dispone dei seguenti sensori:\n";
        for (Sensore s: listaSensori) {
            visualizza +=  s.getNome() + ", categoria: " + s.getCategoria().getNome() + ", RILEVAZIONIIIIIIIII\n";
        }

        return visualizza;
    }
}
