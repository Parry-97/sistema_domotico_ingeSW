package inge.progetto;

/**
 * Ogni {@link Sensore} è descritto da una categoria. Essa è caratterizzata da un {@link #nome}, da un {@link #testolibero} di lunghezza
 * massima predefinita (per esprimere ad esempio la sigla, il costruttore ecc.) e dall'insieme(eventualmente singoletto) delle informazioni
 * rilevabili da ogni sensore di quella categoria. Inoltre viene anche specificata la natura del sensore ({@link #fisico}) ovvero se
 * quest'ultimo può essere utilizzato per la misura di grandezze fisiche(temperatura, pressione) o per il monitoraggio di artefatti
 * presenti all'interno dell'unità immobiliare
 *
 * @see Informazione
 * @see Artefatto
 * @author Parampal Singh, Mattia Nodari
 */
public class CategoriaSensore {
    /**
     * nome della categoria di sensori
     */
    private String nome;

    /**
     * scopo/natura o impiego del sensore
     */
    private boolean fisico;

    /**
     * testo libero descrittivo della categoria
     */
    private String testolibero;

    /**
     * l'informazione rilevabile da sensori di questa categoria
     */
    private Informazione infoRilevabile;

    /**Costruttore per la specifica di un oggetto di tipo CategoriaSensore
     * @param nome nome della categoria
     * @param testolibero testo libero descrittivo
     * @param fisico scopo della categoria di sensore
     */
    public CategoriaSensore(String nome, String testolibero, boolean fisico) {
        this.nome = nome;
        this.testolibero = testolibero;
        this.fisico = fisico;
    }

    /**Permette di ottenere il nome della categoria di sensore
     * @return nome della categoria di sensore
     */
    public String getNome() {
        return nome;
    }


    /**Specifica il nome della categoria di sensore
     * @param nome nuovo nome da assegnare alla categoria di sensore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**Fornisce il testo libero associato alla categoria di sensore
     * @return testo libero relativo alla categoria di sensore
     */
    public String getTestolibero() {
        return testolibero;
    }

    public void setTestolibero(String testolibero) {
        this.testolibero = testolibero;
    }

    public String visualizzaCategoriaSensore() {
        String visualizza = "Nome Categoria: " + this.getNome() + ", testo libero: " + this.getTestolibero() + ", RILEVAZIONIIIIII\n";
/*
        for (ModalitaOperativa lista: modalita) {
            visualizza +=  lista.getNome() + "\n";
        }
*/
        return visualizza;
    }

    /**Fornisce l'informazione rilevabile da sensori di questa categoria
     * @return l'informazione rilevabile da sensori della stessa categoria
     */
    public Informazione getInfoRilevabile() {
        return infoRilevabile;
    }

    /**Permette di specificare il tipo di informazione rilevabile da sensori della stessa categoria
     * @param info
     */
    public void setInfoRilevabile(Informazione info) {
        this.infoRilevabile = info;
    }

    /**Permette di conoscere lo scopo/natura dei sensori di una categoria.
     * Tutti i sensori di una stessa categoria possono quindi essere 'fisici', misurano grandezze fisiche, o 'non-fisici', monitorano
     * quindi artefatti.
     * @return tipo di categoria di sensore
     */
    public boolean isFisico() {
        return fisico;
    }

    /**Permette di specificare la natura della categoria di sensori
     * @param fisico
     */
    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }
}
