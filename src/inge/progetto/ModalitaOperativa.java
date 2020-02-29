package inge.progetto;

public class ModalitaOperativa extends Informazione{
    private int valore;

    public ModalitaOperativa(String nome, int valore) {
        super(nome);
        this.valore = valore;
    }

    public ModalitaOperativa(String nome) {
        super(nome);
    }


    //Per ora proviamo a fare senza parametro
    public int getValore() {
        if(this.valore > super.getVALORE_MAX())
            return super.getVALORE_MAX();
        else return Math.max(this.valore, super.getVALORE_MIN());
    }

    public void setValore(int valore) {
        this.valore = valore;
    }

}
