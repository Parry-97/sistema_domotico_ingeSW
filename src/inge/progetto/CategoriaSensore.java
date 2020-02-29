package inge.progetto;

public class CategoriaSensore {
    private String nome;
    private boolean fisico;
    private String testolibero;
    private Informazione infoRilevabile;

    public CategoriaSensore(String nome, String testolibero, boolean fisico) {
        this.nome = nome;
        this.testolibero = testolibero;
        this.fisico = fisico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTestolibero() {
        return testolibero;
    }

    public void setTestolibero(String testolibero) {
        this.testolibero = testolibero;
    }

    //Aggiungila a te(Mattia) non ho ben capito cosa fa
    public String visualizzaCategoriaSensore() {
        String visualizza = "Nome Categoria: " + this.getNome() + ", testo libero: " + this.getTestolibero() + ", RILEVAZIONIIIIII\n";
/*
        for (ModalitaOperativa lista: modalita) {
            visualizza +=  lista.getNome() + "\n";
        }
*/
        return visualizza;
    }

    public Informazione getInfoRilevabile() {
        return infoRilevabile;
    }

    public void setInfoRilevabile(Informazione info) {
        this.infoRilevabile = info;
    }

    public boolean isFisico() {
        return fisico;
    }

    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }
}
