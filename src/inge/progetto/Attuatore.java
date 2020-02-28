package inge.progetto;

public class Attuatore {
    private String nome;
    private Artefatto monitorato;
    private CategoriaAttuatore categoria;
    private String modalitaAttuale;
    private boolean statoAttivazione;

    public Attuatore(String nome, CategoriaAttuatore categoria, String modalitaAttuale) {
        this.nome = nome;
        this.categoria = categoria;
        this.modalitaAttuale = modalitaAttuale;
        this.statoAttivazione = true;
    }


    public Artefatto getMonitorato() {
        return monitorato;
    }

    public void setMonitorato(Artefatto monitorato) {
        this.monitorato = monitorato;
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

    public void setCategoria(CategoriaAttuatore categoria) {
        this.categoria = categoria;
    }

    public String getModalitaAttuale() {
        return modalitaAttuale;
    }

    public void setModalitaAttuale(String nuovaModalita) {
        if(this.modalitaAttuale.equals(nuovaModalita)) {
            System.out.println("Sei già in questa modalità");
            return;
        }
        for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
            if(mod.getNome().equals(nuovaModalita)) {
                this.modalitaAttuale = nuovaModalita;
                this.monitorato.setStatoAttuale(mod);

                System.out.println("Nuova modalità");
                return;
            }
        }
        System.out.println("Questa modalità non esiste per questo attuatore");
    }

    public boolean getStatoAttivazione() {
        return statoAttivazione;
    }

    public void setStatoAttivazione(boolean statoAttivazione) {
        this.statoAttivazione = statoAttivazione;
    }

}
