package inge.progetto;

/**
 * Permette di modellizare un sensore gestibile da un sistema domotico. Il sensore e identificato da un {@link #nome},
 * {@link #categoria} e dalla misura che questo rileva({@link #rilevazione}), la quale può essere lo 'stato' di un
 * {@link Artefatto} da questi monitorato o la misura di una grandezza fisica associata ad una {@link Stanza} (es. temperatura o pressione).
 * Si definiscono quindi, attraverso la sua {@link #categoria}, sensori di tipo 'fisici' e 'sensori di stato' che monitorano
 * rispettivamente una stanza o un artefatto.
 *
 * @author Parampal Singh, Mattia Nodari
 * @version 1
 */
public class Sensore {
    /** nome del sensore*/
    private String nome;

    /** categoria a cui il sensore appartiene (guarda {@link CategoriaSensore})*/
    private CategoriaSensore categoria;

    /** informazione o misura che il sensore rileva (guarda {@link Informazione})*/
    private Informazione rilevazione;

    /** stato del sensore ovvero se questi è abilitato o meno, attivo o spento*/
    private boolean statoAttivazione;


    /**
     * Costruttore della classe Sensore.
     * l'informazione inizialmente associata è di natura casuale(default)
     * @param nome nome da attribuire al sensore
     * @param categoria categoria di sensore a cui questo 'appartiene'
     * @see CategoriaSensore
     * @see Informazione
     */
    public Sensore(String nome, CategoriaSensore categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.rilevazione = categoria.getInfoRilevabile();
        this.statoAttivazione = true;
    }

    /**Fornisce il nome del sensore
     * @return nome del sensore
     */
    public String getNome() {
        return nome;
    }

    /** Permette di modificare il nome del sensore
     * @param nome nuovo nome da attribuire al sensore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Fornisce la categoria a cui 'appartiene' il sensore
     * @return categoria del sensore
     */
    public CategoriaSensore getCategoria() {
        return categoria;
    }

    public Informazione getRilevazione() {
        return rilevazione;
    }

    /** Permette di specificare esplicitamente l'informazione rilevabile dal sensore. Utilizzata principalmente per sensori
     *  che monitorano artefatti, in quanto devono 'essere associati' a quest'ultimi per tener traccia del loro comportamento.
     *  Mentre invece sensori di natura 'fisica' non sono associati a particolari artefatti e misurano autonomamente una grandezza
     *  come temperatura o pressione ed è quindi vietato alterarne il contenuto informativo. Il tipo di sensore e le informazioni
     *  da questo rilevabili sono definite nella sua categoria (vedi {@link CategoriaSensore})
     *
     * @param rilevazione nuova informazione che il sensore rileva
     * @see Informazione
     */
    public void setRilevazione(Informazione rilevazione) {
        if(this.categoria.isFisico())
            System.out.println("Non è possibile alterare le rilevazioni del sensore! \n");
        else
            this.rilevazione = rilevazione;
    }

    /**Permette di conoscere lo stato di attivazione del sensore ovvero se è accesso o spento
     * @return vero se il sensore è accesso/attivo falso altrimenti
     */
    public boolean isAttivo() {
        return statoAttivazione;
    }

    /**Permette di impostare lo stato di attivazione del sensore
     * @param statoAttivazione lo stato del sensore (acceso=True, spento=False)
     */
    public void setStatoAttivazione(boolean statoAttivazione) {
        this.statoAttivazione = statoAttivazione;
    }
}
