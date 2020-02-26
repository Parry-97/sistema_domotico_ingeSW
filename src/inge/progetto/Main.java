package inge.progetto;

public class Main {

    public static void main(String[] args) {
        ModalitaOperativa acceso = new ModalitaOperativa("Acceso", 1);
        ModalitaOperativa  spento = new ModalitaOperativa("Spento", 0);
        CategoriaAttuatore interruttore = new CategoriaAttuatore("Interruttori", "shfiquji");
        CategoriaAttuatore gianni = new CategoriaAttuatore("Gianni", "mkdniq");
	    Attuatore pulsante1 = new Attuatore("p1", interruttore, "Spento");
        Attuatore pulsante2 = new Attuatore("p2", interruttore, "Acceso");
        Attuatore pulsante3 = new Attuatore("p3", gianni, "Spento");
        Artefatto cancello = new Artefatto("cancello");

        cancello.aggiungiAttuatore(pulsante1);
        cancello.aggiungiAttuatore(pulsante2);
        cancello.aggiungiAttuatore(pulsante3);
        cancello.aggiungiAttuatore(pulsante3);
        System.out.println(cancello.visualizzaDispositivi());

        interruttore.aggiungiModalitaOperativa(acceso);
        interruttore.aggiungiModalitaOperativa(spento);
        interruttore.aggiungiModalitaOperativa(acceso);
        interruttore.aggiungiModalitaOperativa(acceso);
        System.out.println(interruttore.visualizzaCategoriaAttuatore());

        pulsante2.setModalitaAttuale("Acceso");

        }
    }
