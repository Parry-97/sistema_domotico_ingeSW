package inge.progetto;

public class CategoriaSensore {
    private String nome;
    private String testolibero;
    private String[] infoRilevabili;

    public CategoriaSensore(String nome, String testolibero, String[] infoRilevabili) {
        this.nome = nome;
        this.testolibero = testolibero;
        this.infoRilevabili = infoRilevabili;
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

    public String visualizzaCategoriaSensore() {
        String visualizza = "Nome Categoria: " + this.getNome() + ", testo libero: " + this.getTestolibero() + ", RILEVAZIONIIIIII\n";
/*
        for (ModalitaOperativa lista: modalita) {
            visualizza +=  lista.getNome() + "\n";
        }
*/
        return visualizza;
    }
}
