package inge.progetto;

import java.util.ArrayList;

/**
 * Un unit&agrave; immobiliare &egrave; la struttura che 'raggruppa'/'contiene' le stanze, gli artefatti e ,in modo indiretto, anche i
 * sensori, attuatori ad essi associati. Le unit&agrave; immobiliari possono avere diverse destinazioni d'uso({@link #tipo}): residenziale,
 * commerciale, produttiva ecc. Un'unit&agrave; immbobiliare &egrave; articolata in un insieme di stanze e/o in un insieme di artefatti.
 * Globalmente l'unit&agrave; deve consistere in un almeno una {@link Stanza} o in almeno un {@link Artefatto}.
 *
 * @author Parampal, Mattia Nodari
 */
public class UnitaImmobiliare {
    /**
     * insieme di stanze contenute nell'unit&agrave; immobiliare
     */
    private ArrayList<Stanza> listaStanze;

    /**
     * insieme di artefatti nell'unit&agrave; immobiliare e che non sono collocati entro le stanze
     * Ex: Un cancello non e collocato in una stanza, bens&igrave; all'esterno
     */
    private ArrayList<Artefatto> listaArtefatti;

    /**
     * tipo/destinazione d'uso dell'unit&agrave; immobiliare
     */
    private String tipo;

    /**Costruttore per specifica di un oggetto UnitaImmboliare
     * @param tipo destinazione d'uso dell'unit&agrave; immobiliare
     */
    public UnitaImmobiliare(String tipo) {
        this.listaArtefatti = new ArrayList<>();
        this.listaStanze = new ArrayList<>();
        this.tipo = tipo;
    }


    public UnitaImmobiliare() {
        this.tipo = "";
    }

    /**Permette di ottenere lista/insieme di stanze nell'unit&agrave; immobiliare
     * @return lista di stanze presenti nell'unit&agrave; immobiliare
     */

    public ArrayList<Stanza> getListaStanze() {
        return listaStanze;
    }

    /**Permette di ottenere la lista degli artefatti presenti nell'unit&agrave; immobiliare e non collocati in stanze.
     * @return lista di artefatti nell'unit&agrave; immobiliare
     */
    public ArrayList<Artefatto> getListaArtefatti() {
        return listaArtefatti;
    }

    /**Permette di ottenere il tipo/destinazione d'uso dell'unit&agrave; immmobiliare
     * @return destinazione di'uso dell'unit&agrave; immobiliare
     */
    public String getTipo() {
        return tipo;
    }

    /**Permette di specificare il tipo/destinazione d'uso dell'unit&agrave; immobiliare
     * @param tipo tipo/destinazione d'uso dell'unita immobiliare
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**Permette di specificare una nuova stanza da aggiungere all'unit&agrave; immobiliare
     * @param s nuova stanza da aggiungere all'unit&agrave; immobiliare
     */
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

    /**Permette di aggiungere artefatti, esterni a stanze, nell'unit&agrave; immobiliare
     * @param a nuovo artefatto da aggiungere
     */
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

    /**Fornisce una rappresentazione testuale che descrive complessivamente l'unit&agrave; immobiliare, le stanze e gli artefatti in essa contenuti.
     * @return stringa descrittiva dell'intera unit&agrave; immobiliare
     */
    public String visualizzaDescrizione() {
        StringBuilder visualizza = new StringBuilder("Tipo unità immobiliare: " + this.getTipo() + ", è costituita dalle seguenti stanze:\n");
        if(!listaStanze.isEmpty()) {
            for (Stanza stanza : listaStanze) {
                visualizza.append(stanza.visualizzaDisposizione());
            }
        } else
            visualizza.append("!!! Non sono presenti stanze per questa unità immobiliare !!!\n");

        visualizza.append("\nArtefatti esterni all'unità immobiliare:\n");
        if(!listaArtefatti.isEmpty()) {
            for (Artefatto artefatto : listaArtefatti) {
                boolean trovato = false;
                for(Stanza stanza : listaStanze) {
                    if(stanza.getListaArtefatti().contains(artefatto)) {
                        trovato = true;
                        break;
                    }
                }
                if(!trovato)
                    visualizza.append(artefatto.visualizzaDispositivi()).append("\n");
            }
        } else
            visualizza.append("!!! Non sono presenti artefatti esterni all'unità immobiliare !!!\n");

        return visualizza.toString();
    }

}
