package inge.progetto;

public class Sensore {
    private String nome;
    private CategoriaSensore categoria;
    private Informazione rilevazione;
    private boolean statoAttivazione;


    public Sensore(String nome, CategoriaSensore categoria) {
        this.nome = nome;
        this.categoria = categoria;
        this.rilevazione = categoria.getInfoRilevabile();//l'informazione associata al sensore è inizialmente casuale
        this.statoAttivazione = true;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaSensore getCategoria() {
        return categoria;
    }

    /*public Informazione getRilevazione() {
        return rilevazione;
    }
    */

    public void setRilevazione(ModalitaOperativa rilevazione) {
        if(this.categoria.isFisico())
            System.out.println("Non è possibile alterare le rilevazioni del sensore! \n");
        else
            this.rilevazione = rilevazione;
    }

    public Informazione getRilevazione() {
        return rilevazione;
    }

    public boolean isAttivo() {
        return statoAttivazione;
    }

    public void setStatoAttivazione(boolean statoAttivazione) {
        this.statoAttivazione = statoAttivazione;
    }
}
