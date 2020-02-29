package inge.progetto;

/**
 * Rappresenta la modalità operativa di una determinato {@link Attuatore}e di conseguenza lo stato dell'{@link Artefatto}
 * ad esso associato. Permettendo cosi ad un attuatore, attraverso una specifica modalità, di comandare
 * il comportamento dell'artefatto, misurato o comunque monitorato eventualmente da un {@link Sensore}.
 *
 * @author Parampal Singh, Mattia Nodari
 *
 * @see Informazione
 */
public class ModalitaOperativa extends Informazione{

    /**
     * Un valore intero unico, specificato dal manutentore, che permette di  avere una rappresentazione numerica
     * della modalità operativa, usata dal sistema per acquisizione di informazioni/misure attraverso sensori.
     */
    private int valore;

    /**Costruttore della classe
     * La modalità operativa è completamente specificata dal manutentore
     * con nome e valore prefissato
     *
     * @param nome nome della modalità operativa
     * @param valore valore numerico della modalità operativa
     */
    public ModalitaOperativa(String nome, int valore) {
        super(nome); //Costruttore della classe padre (Informazione)
        this.valore = valore;
    }

    /**
     * Ci permette di ricavare il valore informativo/numerico precedentemente assegnato dal manutentore alla
     * modalità operativa (guarda costruttore).
     * Il metodo sovrascrive del omonimo metodo della classe padre(Informazione) dove il valore è generato casualmente
     * ed è limitato da un range/dominio per la misura
     *
     * @see Informazione
     */
    @Override
    public int getValore() {
        if(this.valore > super.getVALORE_MAX())
            return super.getVALORE_MAX();
        else return Math.max(this.valore, super.getVALORE_MIN());
    }

    /**Permette la modifica del valore numerico associato alla modalità operativa
     * @param valore nuovo valore da assegnare alla modalità operativa
     */
    public void setValore(int valore) {
        this.valore = valore;
    }

}
