package inge.progetto;

public class Main {

    public static void main(String[] args) {
        ModalitaOperativa acceso = new ModalitaOperativa("Acceso", 1);
        ModalitaOperativa  spento = new ModalitaOperativa("Spento", 0);
        CategoriaAttuatore interruttore = new CategoriaAttuatore("Interruttori", "shfiquji");
        CategoriaAttuatore gianni = new CategoriaAttuatore("Gianni", "mkdniq");
        CategoriaSensore regolatore = new CategoriaSensore("Regolatore", "efbjiewbvji", null);
	    Attuatore pulsante1 = new Attuatore("p1", interruttore, "Spento");
        Attuatore pulsante2 = new Attuatore("p2", interruttore, "Acceso");
        Attuatore pulsante3 = new Attuatore("p3", gianni, "Spento");
        Artefatto cancello = new Artefatto("cancello");
        Artefatto luce = new Artefatto(("lampada"));
        Sensore s1 = new Sensore("S1", regolatore);
        Sensore s2 = new Sensore("S2", regolatore);
        Stanza cucina = new Stanza("Cucina");

        cancello.aggiungiAttuatore(pulsante1);
        cancello.aggiungiAttuatore(pulsante2);
        cancello.aggiungiAttuatore(pulsante3);
        cancello.aggiungiAttuatore(pulsante3);
        cancello.aggiungiSensore(s1);
        System.out.println(cancello.visualizzaDispositivi());

        luce.aggiungiAttuatore(pulsante2);
        luce.aggiungiAttuatore(pulsante1);
        luce.aggiungiAttuatore(pulsante3);
        luce.aggiungiSensore(s2);
        System.out.println(luce.visualizzaDispositivi());

        interruttore.aggiungiModalitaOperativa(acceso);
        interruttore.aggiungiModalitaOperativa(spento);
        interruttore.aggiungiModalitaOperativa(acceso);
        interruttore.aggiungiModalitaOperativa(acceso);
        System.out.println(interruttore.visualizzaCategoriaAttuatore());

        pulsante2.setModalitaAttuale("Acceso");

        cucina.aggiungiArtefatto(cancello);
        cucina.aggiungiArtefatto(luce);
        System.out.println(cucina.visualizzaDisposizione());

        System.out.println(s1.getNome() + " " + s1.getCategoria().visualizzaCategoriaSensore());


        }
    }
