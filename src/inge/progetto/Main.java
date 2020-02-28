package inge.progetto;

import java.lang.reflect.MalformedParameterizedTypeException;

public class Main {

    public static void main(String[] args) {
        ModalitaOperativa acceso = new ModalitaOperativa("Acceso", 1);
        ModalitaOperativa  spento = new ModalitaOperativa("Spento", 0);
        CategoriaAttuatore interruttore = new CategoriaAttuatore("Interruttori", "shfiquji");
        CategoriaAttuatore gianni = new CategoriaAttuatore("Gianni", "mkdniq");
        CategoriaSensore regolatore = new CategoriaSensore("Regolatore", "efbjiewbvji", null);
	    Attuatore pulsante1 = new Attuatore("p1", interruttore, acceso);
        Attuatore pulsante2 = new Attuatore("p2", interruttore, acceso);
        Attuatore pulsante3 = new Attuatore("p3", gianni, spento);
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

        pulsante2.setModalitaAttuale("Spento");

        cucina.aggiungiArtefatto(luce);
        System.out.println(cucina.visualizzaDisposizione());

        System.out.println(s1.getNome() + " " + s1.getCategoria().visualizzaCategoriaSensore());

        UnitaImmobiliare casa = new UnitaImmobiliare("Residenziale");
        casa.aggiungiArtefatto(cancello);
        casa.aggiungiStanza(cucina);
        System.out.println(casa.visualizzaDescrizione());

        System.out.println("__________________________________");
/*
        CategoriaSensore sensoreTemperatura = new CategoriaSensore("Temperatura", "ibpwqiuf", null);
        CategoriaAttuatore attuatoreTemperura = new CategoriaAttuatore("Temperatura", "uiwqiu");
        ModalitaOperativa attivo = new ModalitaOperativa("Attivo", 22);
        Attuatore t1 = new Attuatore("Temperatura", attuatoreTemperura, attivo);
        Informazione temperatura = new Informazione("Temperatura", 20);
        Sensore s3 = new Sensore("S3", sensoreTemperatura, temperatura);
        System.out.println(s3.leggiValoreSensore());
        System.out.println(s3.leggiValoreAttuatore(t1));
        t1.setModalitaAttuale("Attivo", 25);
        System.out.println(s3.leggiValoreAttuatore(t1));
        System.out.println(s3.leggiValoreSensore());
*/
        }
    }
