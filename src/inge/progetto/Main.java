package inge.progetto;

public class Main {

    public static void main(String[] args) {
        //Modalità operative da aggiungere a attuatori
        /*ModalitaOperativa acceso = new ModalitaOperativa("Acceso", 1);
        ModalitaOperativa  spento = new ModalitaOperativa("Spento", 0);
        ModalitaOperativa chiuso = new ModalitaOperativa("chiuso", 0);

        //Categorie di attuatori possibili
        CategoriaAttuatore interruttore = new CategoriaAttuatore("Interruttori", "shfiquji");
        CategoriaAttuatore gianni = new CategoriaAttuatore("Gianni", "mkdniq");

        //Descrizione delle possibili modalità operative per le categorie di attuatori
        interruttore.aggiungiModalitaOperativa(acceso);
        interruttore.aggiungiModalitaOperativa(spento);
        interruttore.aggiungiModalitaOperativa(acceso);
        interruttore.aggiungiModalitaOperativa(acceso);

        //Categorie di sensori che possono essere quindi fisici o monitor(monitorano artefatto)
        CategoriaSensore regolatore = new CategoriaSensore("Regolatore", "efbjiewbvji", false);


        CategoriaSensore termometro = new CategoriaSensore("termometro", "efbjiewbvji", true);

        //Definiamo all'interno della categoria il tipo di info rilevabile da sensori di una detta categoria
        Informazione info = new Informazione("temperatura");
        info.setVALORE_MAX(100);
        info.setVALORE_MIN(0);
        termometro.setInfoRilevabile(info);

        regolatore.setInfoRilevabile(new Informazione("misura_boh"));



        //Nuovi attuatori definiti a partire dalle categorie precedentemente predefinite
        Attuatore interrutore1 = new Attuatore("p1", interruttore, "Spento");
        Attuatore interrutore2 = new Attuatore("p2", interruttore, "Acceso");
        Attuatore interrutore3 = new Attuatore("p3", gianni, "Spento");

        //Test di misura iniziale casuale per s1(regolatore) in quanto non connesso ad un artefatto
        Sensore s1 = new Sensore("S1",regolatore);
        System.out.println("\n\n Misura boh s1: " + s1.getRilevazione().getValore() + "\n\n");

        Sensore s2 = new Sensore("S2",termometro);

        Sensore s3 = new Sensore("monitorCancello",regolatore);
        System.out.println("\n\n Misura boh s3: " + s3.getRilevazione().getValore() + "\n\n");

        Stanza cucina = new Stanza("Cucina");

        Artefatto cancello = new Artefatto("cancello", chiuso);
        Artefatto luce = new Artefatto("lampada",spento);

        cancello.aggiungiAttuatore(interrutore1);
        cancello.aggiungiAttuatore(interrutore2);
        cancello.aggiungiAttuatore(interrutore3);
        cancello.aggiungiAttuatore(interrutore3);


        cancello.aggiungiSensore(s3);
        System.out.println(cancello.visualizzaDispositivi());

        luce.aggiungiAttuatore(interrutore2);
        luce.aggiungiAttuatore(interrutore1);
        luce.aggiungiAttuatore(interrutore3);
        luce.aggiungiSensore(s1); //da un avviso all'utente
        System.out.println(luce.visualizzaDispositivi());


        System.out.println(interruttore.visualizzaCategoriaAttuatore());

        //interrutore2.setModalitaAttuale("Acceso");

        cucina.aggiungiArtefatto(cancello);
        cucina.aggiungiArtefatto(luce);
        System.out.println(cucina.visualizzaDisposizione());

        System.out.println(s1.getNome() + " " + s1.getCategoria().visualizzaCategoriaSensore());


        for (int i = 0; i < 5; i++) {
            System.out.println("Misura del termometro s2: " + s2.getRilevazione().getValore());
            System.out.println("Misura del regolatore s1: " + s1.getRilevazione().getValore());
        }

        interrutore1.setModalitaAttuale("Acceso");
        System.out.println("*** TEST 2 ***");
        for (int i = 0; i < 5; i++) {
            System.out.println("Misura del termometro s2: " + s2.getRilevazione().getValore());
            System.out.println("Misura del regolatore s3: " + s3.getRilevazione().getValore());
        }

        System.out.println("*** TEST 3 ***");
        for (int i = 0; i < 5; i++) {
            System.out.println("Misura del termometro s2: " + s2.getRilevazione().getValore());
            System.out.println("Misura del regolatore s3: " + s3.getRilevazione().getValore());
        }

         */
        ModalitaOperativa spento = new ModalitaOperativa("Spento", 0);
        ModalitaOperativa acceso = new ModalitaOperativa("Acceso", 1);

        Artefatto lampada = new Artefatto("Lampada",spento);
        Stanza cucina = new Stanza("Cucina");

        CategoriaAttuatore catAtt = new CategoriaAttuatore("Interrutore", "sdadafaf");
        catAtt.aggiungiModalitaOperativa(spento);
        catAtt.aggiungiModalitaOperativa(acceso);

        Attuatore interrutore1 = new Attuatore("interrutore", catAtt,"Spento");

        CategoriaSensore cat1 = new CategoriaSensore("sensore di temperatura","adasdasda", true);
        Informazione info1 = new Informazione("temperatura");
        info1.setVALORE_MAX(50);
        info1.setVALORE_MIN(-50);
        cat1.setInfoRilevabile(info1);
        CategoriaSensore cat2 = new CategoriaSensore("sensore di luce", "sdasdasd", false);
        cat2.setInfoRilevabile(new Informazione("luce"));
        Sensore t1 = new Sensore("termometro", cat1);
        Sensore sensLampada = new Sensore("sensoreLampada", cat2);
        cucina.aggiungiSensore(t1);
        lampada.aggiungiSensore(sensLampada);
        lampada.aggiungiAttuatore(interrutore1);
        cucina.aggiungiArtefatto(lampada);

        System.out.println("\n" + lampada.visualizzaDispositivi());

        for (int i = 0; i < 6; i++) {
            if(i == 3)
                interrutore1.setModalitaAttuale("Acceso");

            System.out.println(i+") Misura della temperatura da t1 :" + t1.getRilevazione().getValore());
            System.out.println("Misura della luce da sensLampada: " + sensLampada.getRilevazione().getValore());
        }

        System.out.println("\n" +lampada.visualizzaDispositivi());
        System.out.println("\n" +cucina.visualizzaDisposizione());
        cucina.aggiungiSensore(sensLampada);
    }
}
