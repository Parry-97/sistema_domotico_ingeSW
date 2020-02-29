package inge.progetto;

import java.util.ArrayList;

/**
 * Rappresenta un attuatore ovvero un dispositivo ,tramite il quale, il sistema domotivo compiere determinate azioni
 * (accensione/spegnimento luce, regolazione temperatura, apertura/chiusura finestre) che influenzano il comportamento
 * delle sottounita da queste gestite. Ogni attuatore è definito da un {@link #nome}, una {@link #categoria} che ne
 * descrive inoltre tutte le possibili modalità operative che possono essere esibite da attuatori simili, e da uno
 * stato di attivazione che indica se è spento o acceso.
 */
public class Attuatore {
    private String nome;

    /**
     * lista di artefatto comandato dall'attuatore
     */
    private ArrayList<Artefatto> listaComandati;

    /**
     *  categoria a cui appartiene l'attuatore
     *  @see CategoriaAttuatore
     */
    private CategoriaAttuatore categoria;


    /**
     * Modalita operativa attualmente esibita dall'attuatore. Le possibili modalità operative
     * sono definite nella sua {@link #categoria}.
     */
    private String modalitaAttuale;
    private boolean statoAttivazione;

    public Attuatore(String nome, CategoriaAttuatore categoria, String modalitaAttuale) {
        this.nome = nome;
        this.categoria = categoria;
        this.modalitaAttuale = modalitaAttuale;
        this.statoAttivazione = true;
        listaComandati = new ArrayList<>();
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

    /**Permette di specificare/modificare la  a cui appartiene l'attuatore
     * @param categoria categoria di attuatore da assegnare
     */
    public void setCategoria(CategoriaAttuatore categoria) {
        this.categoria = categoria;
    }


    public ArrayList<Artefatto> getListaComandati() {
        return listaComandati;
    }

    public void aggiungiArtefatto(Artefatto art) {
        listaComandati.add(art);
    }

    public void setListaComandati(ArrayList<Artefatto> listaComandati) {
        this.listaComandati = listaComandati;
    }

    /**Fornisce il nome dell' attuale modalità operativa({@link #modalitaAttuale}) esibita dall'attuatore
     * @return nome della modalita operativa attuale
     */
    public String getModalitaAttuale() {
        return modalitaAttuale;
    }

    /** Specifica una nuova modalità operativa per l'attuatore controllando prima
     * che questa sia possibile(definita nel suo set di modalità operative).
     * Inoltre determina un cambiamento dello stato degli stati artefatti comandati
     *
     * @param nuovaModalita nome della nuova modalità operativa
     */
    public void setModalitaAttuale(String nuovaModalita) {
        if(this.modalitaAttuale.equals(nuovaModalita)) {
            System.out.println("Sei già in questa modalità");
            return;
        }
        for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
            if(mod.getNome().equals(nuovaModalita)) {
                this.modalitaAttuale = nuovaModalita;

                modificaArtefatti(mod); //conseguente cambiamento di stato degli artefatti comandati

                System.out.println("Nuova modalità");
                return;
            }
        }
        System.out.println("Questa modalità non esiste per questo attuatore");
    }


    /** Modifica la modalità operatica/stato degli artefatti comandati dall'attuatore
     * @param mod nuova modalità operativa da assegnare agli artefatti comandati dall'attuatore
     */
    private void modificaArtefatti(ModalitaOperativa mod) {
        if (listaComandati.isEmpty()) {
            System.out.println("** L'attuatore non comanda alcun artefatto **");
            return;
        }

        for (Artefatto art: listaComandati) {
            art.setStatoAttuale(mod);
        }
    }

    /**Fornisce lo stato di attivazione dell'attuatore(accesso o spento)
     * @return true se l'attuatore è acceso e false se è spento
     */
    public boolean getStatoAttivazione() {
        return statoAttivazione;
    }

    /** Permette di 'attivare' il dispositivo o specificare se è attivo o spento
     * @param statoAttivazione nuovo stato dell'attuatore(true=Acceso, false=Spento)
     */
    public void setStatoAttivazione(boolean statoAttivazione) {
        this.statoAttivazione = statoAttivazione;
    }

}
