package inge.progetto;

import java.util.ArrayList;

/**
 * Rappresenta un attuatore ovvero un dispositivo ,tramite il quale, il sistema domotivo compiere determinate azioni
 * (accensione/spegnimento luce, regolazione temperatura, apertura/chiusura finestre) che influenzano il comportamento
 * delle sottounita da queste gestite. Ogni attuatore &egrave; definito da un {@link #nome}, una {@link #categoria} che ne
 * descrive inoltre tutte le possibili modalit&agrave; operative che possono essere esibite da attuatori simili, e da uno
 * stato di attivazione che indica se &egrave; spento o acceso.
 *
 * @author Parampal Singh, Mattia Nodari
 */
public class Attuatore {

    /**
     * nome dell'attuatore
     */
    private String nome;

    /**
     * Carattestica di associazione ad artefatto
     */
    private boolean singolo;
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
     * Modalit&agrave; operativa attualmente esibita dall'attuatore. Le possibili modalit&agrave; operative
     * sono definite nella sua {@link #categoria}.
     */
    private String modalitaAttuale;
    /**
     * Lo stato(spento o acceso) dell'attuatore
     */
    private boolean statoAttivazione;

    public Attuatore(String nome, CategoriaAttuatore categoria, String modalitaAttuale, boolean singolo) {
        this.nome = nome + "_" + categoria.getNome();
        this.categoria = categoria;
        this.modalitaAttuale = modalitaAttuale;
        this.statoAttivazione = true;
        this.singolo = singolo;
        listaComandati = new ArrayList<>();
    }

    /**Fornisce il nome dell'attuatpre
     * @return  nome dell'attuatore
     */
    public String getNome() {
        return nome;
    }

    /**Permette di modificare il nome dell'attuatore
     * @param nome nuovo nome da assegnare all'attuatore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**Permette di ottenere la categoria a cui appartiene l'attuatore
     * @return la categoria a cui appartiene l'attuatore
     */
    public CategoriaAttuatore getCategoria() {
        return categoria;
    }

    /**Permette di specificare/modificare la  a cui appartiene l'attuatore
     * @param categoria categoria di attuatore da assegnare
     */
    public void setCategoria(CategoriaAttuatore categoria) {
        this.categoria = categoria;
    }

    /**Aggiunge l'artefatto alla lista degli artefatti comandati dall'attuatore
     * @param art nuovo artefatto che si desidera comandare attraverso l'attuatore
     */
    public void aggiungiArtefatto(Artefatto art) {
        listaComandati.add(art);
        for (ModalitaOperativa m: this.categoria.getModalita()) {
            if (m.getNome().equals(modalitaAttuale)) {
                art.setStatoAttuale(m);
                break;
            }
        }
    }

    /**Fornisce il nome dell' attuale modalit&agrave; operativa({@link #modalitaAttuale}) esibita dall'attuatore
     * @return nome della modalita operativa attuale
     */
    public String getModalitaAttuale() {
        return modalitaAttuale;
    }

    /** Specifica una nuova modalit&agrave; operativa per l'attuatore controllando prima
     * che questa sia possibile(definita nel suo set di modalit&agrave; operative).
     * Inoltre determina un cambiamento dello stato degli stati artefatti comandati
     *
     * @param nuovaModalita nome della nuova modalit&agrave; operativa
     */
    public void setModalitaAttuale(String nuovaModalita) {
        if(this.modalitaAttuale.equals(nuovaModalita)) {
            System.out.println("Sei già in questa modalità");
            return;
        }
        for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
            if(mod.getNome().equals(nuovaModalita)) {
                this.modalitaAttuale = nuovaModalita;

                modificaArtefatti(mod);
                System.out.println("Nuova modalità");
                return;
            }
        }
        System.out.println("Questa modalità non esiste per questo attuatore");
    }


    /** Modifica la modalit&agrave; operatica/stato degli artefatti comandati dall'attuatore
     * @param mod nuova modalit&agrave; operativa da assegnare agli artefatti comandati dall'attuatore
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

    /**Permette di conoscere caratteristica di associazione dell'attuatore ovvero se questo può essere associato a uno o più artefatti
     * @return true se ha associazione singol, false altrimenti
     */
    public boolean isSingolo() {
        return singolo;
    }
}
