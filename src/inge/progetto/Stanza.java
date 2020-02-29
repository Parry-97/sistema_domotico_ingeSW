package inge.progetto;

import java.util.ArrayList;

public class Stanza {
    private String nome;
    private ArrayList<Sensore> listaSensori;
    private ArrayList<Artefatto> listaArtefatti;

    public Stanza(String nome) {
        this.nome = nome;
        listaSensori = new ArrayList<>();
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


    public ArrayList<Artefatto> getListaArtefatti() {
        return listaArtefatti;
    }

    /**Associa un dispostivo alla stanza aggiungendolo alla sua lista di sensori({@link #listaSensori}).
     * Il sensore dev'essere di un certo tipo/categoria ovvero 'fisico' in quanto altrimenti non può essere aggiunto.
     * @param sens sensore da aggiungere
     */
    //TODO: decidere su eventuale segnalazione per corretta aggiunta di un elemento
    public void aggiungiSensore(Sensore sens) {
        if (!sens.getCategoria().isFisico()) {
            System.out.println("\n!!! Non è possibile associare tale categoria di dispositivo alla stanza specificata !!!\n");
            return;
        }

        for (Sensore s : listaSensori) {
            if (s.getCategoria().equals(sens.getCategoria()) || s.getNome().equals(sens.getNome()))
                return;
        }
        listaSensori.add(sens);
        System.out.println("Sensore aggiunto");

    }

    public void aggiungiArtefatto(Artefatto a) {
        for (Artefatto artefatto : listaArtefatti) {
            if (artefatto.getNome().equals(a.getNome()))
                return;
        }
        listaArtefatti.add(a);
        System.out.println("Artefatto aggiunto");

    }

    public String visualizzaDisposizione() {
        String visualizza = "Nome Stanza: " + this.getNome() + ", essa possiede:\n";

        for (Artefatto a: listaArtefatti) {
            visualizza +=  a.visualizzaDispositivi();
        }

        for (Sensore s : listaSensori) {
            visualizza += "Nome Sensore: "+ s.getNome() + " | " + "Categoria: " + s.getCategoria().getNome() + " | " + "Rilevazione: " + s.getRilevazione().getValore()+"\n";
        }
        return visualizza;

    }
}