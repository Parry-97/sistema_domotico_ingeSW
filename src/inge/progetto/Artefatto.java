package inge.progetto;

import java.util.ArrayList;

public class Artefatto {
    private String nome;
    /**
     * Rappresenta lo 'stato attuale' dell'artefatto, monitorato da sensori({@link #listaSensori} e comandato
     * da attuatori({@link #listaAttuatori}) ad esso associati
     * @see ModalitaOperativa
     */
    private ModalitaOperativa statoAttuale;

    /**
     * lista dei sensori associati all'artefatto e che monitorano il suo {@link #statoAttuale}
     */
    private ArrayList<Sensore> listaSensori;

    /**
     * lista degli attuatori che comandano il comportamento({@link #statoAttuale}) dell'artefatto
     */
    private ArrayList<Attuatore> listaAttuatori;


    /**Costruttore per la specifica di un artefatto
     * @param nome nome dell'artefatto
     * @param statoAttuale stato/modalità di default per l'artefatto
     */
    public Artefatto(String nome, ModalitaOperativa statoAttuale) {
        this.statoAttuale = statoAttuale;
        this.nome = nome;
        this.listaSensori = new ArrayList<Sensore>();
        this.listaAttuatori = new ArrayList<Attuatore>();
    }

    /**Fornisce lo stato attuale dell'artefatto
     * @return lo stato attuale/modalità di funzionamento esibita nel presente
     */
    public ModalitaOperativa getStatoAttuale() {
        return statoAttuale;
    }

    /**Modifica lo stato attuale dell'artefatto e aggiorna i sensori ad esso associati
     * @param statoAttuale
     */
    public void setStatoAttuale(ModalitaOperativa statoAttuale) {
        this.statoAttuale = statoAttuale;
        for (Sensore s: listaSensori) {
            s.setRilevazione(statoAttuale);
        }
    }

    /**Fornisce il nome dell'artefatto
     * @return nome dell'artefatto
     */
    public String getNome() {
        return nome;
    }

    /**Permette di specificare un nome per l'artefatto
     * @param nome nuovo nome da assegnare all'artefatto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**Permette di ottenere la lista di sensori associati all'artefatto
     * @return la lista di sensori associati all'artefatto
     */
    public ArrayList<Sensore> getListaSensori() {
        return listaSensori;
    }

    /**Permette di specificare la lista di sensori collegati all'artefatto
     * @param listaSensori nuova lista di sensori da collegare all'artefatto
     */
    public void setListaSensori(ArrayList<Sensore> listaSensori) {
        this.listaSensori = listaSensori;
    }

    /**
     * Fornisce la lista di attuatori associati all'artefatto
     * @return la lista di attuatori associati all'artefatto
     */
    public ArrayList<Attuatore> getListaAttuatori() {
        return listaAttuatori;
    }

    public void setListaAttuatori(ArrayList<Attuatore> listaAttuatori) {
        this.listaAttuatori = listaAttuatori;
    }

    /**Permette di associare un sensore all'artefatto cossiche questi possa inoltre cominiciare a monitorare il suo comportamento,
     * aggiungendolo alla lista dei
     * @param s nuovo sensore da associare all'artefatto
     */
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

    /**Associa un nuovo attuatore all'artefatto e aggiungere alla sua lista di attuatori
     * @param a nuovo attuatore da associare all'artefatto
     */
    public void aggiungiAttuatore(Attuatore a) {
        if(!listaAttuatori.isEmpty()) {
            for (Attuatore attuatore : listaAttuatori) {
                if (attuatore.getNome().equals(a.getNome()) || attuatore.getCategoria().getNome().equals(a.getCategoria().getNome())) {
                    return;
                }
            }
        }

        listaAttuatori.add(a);
        a.aggiungiArtefatto(this);
        System.out.println("Attuatore aggiunto");
    }

    /**Fornisce una descrizione di tutti i dispositivi collegati all'artefatto
     * @return descrizione di sensori/attuatori collegati all'artefatto
     */
    public String visualizzaDispositivi() {
        String visualizza = "Nome Artefatto: " + this.getNome() + ", lista attuatori che lo comandano:\n";

        for (Attuatore a: listaAttuatori) {
            visualizza +=  a.getNome() + ", categoria: " + a.getCategoria().getNome() + ", modalità attuale: " + a.getModalitaAttuale() + "\n";
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
