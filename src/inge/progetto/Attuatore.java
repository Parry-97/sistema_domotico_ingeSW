package inge.progetto;

public class Attuatore {
    private String nome;
    private Artefatto monitorato;
    private CategoriaAttuatore categoria;
    private ModalitaOperativa modalitaAttuale;
    private boolean statoAttivazione;

    public Attuatore(String nome, CategoriaAttuatore categoria, ModalitaOperativa modalitaAttuale) {
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

    public ModalitaOperativa getModalitaAttuale() {
        return modalitaAttuale;
    }

        public void setModalitaAttuale(ModalitaOperativa nuovaModalita) {
            if(this.modalitaAttuale.getNome().equals(nuovaModalita.getNome())) {
                System.out.println("Sei già in questa modalità");
                return;
            }
            for (ModalitaOperativa mod : this.getCategoria().getModalita()) {
                if(mod.getNome().equals(nuovaModalita.getNome())) {
                    this.modalitaAttuale = new ModalitaOperativa(nuovaModalita.getNome(), nuovaModalita.getValore());
                    this.monitorato.setStatoAttuale(nuovaModalita);

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
