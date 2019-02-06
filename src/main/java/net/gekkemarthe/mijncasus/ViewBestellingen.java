package net.gekkemarthe.mijncasus;

import java.util.ArrayList;

public class ViewBestellingen {

    private BestellingenFactory bestellingenFactory;
    private ArrayList<Bestelling> gekozenBestellingenBijLeverancier;
    private String kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4, kolomNaam5, kolomNaam6;

    private ArrayList<Integer> allLeverancierCodes;

    ViewBestellingen ()
    {
        bestellingenFactory = new BestellingenFactory();
        bestellingenFactory.loadBestellingen();

        LeveranciersFactory leveranciersFactory = new LeveranciersFactory();
        leveranciersFactory.loadLeveranciers();
        allLeverancierCodes = leveranciersFactory.getAllLeverancierCodes();

        Bestelling kolomNaam = bestellingenFactory.getBestellingen().get(0);
        kolomNaam1 = kolomNaam.getBestelNummer();
        kolomNaam2 = kolomNaam.getLeverancierCode();
        kolomNaam3 = kolomNaam.getBestelDatum();
        kolomNaam4 = kolomNaam.getLeverDatum();
        kolomNaam5 = kolomNaam.getBedrag();
        kolomNaam6 = kolomNaam.getStatus();
    }

    public void toonBestellingen(int keuze) {
        if (allLeverancierCodes.contains(keuze)) {
            gekozenBestellingenBijLeverancier = bestellingenFactory.getBestellingenVanLeverancier(keuze);

            System.out.printf("%-10s %-10s %-12s %-12s %-8s %-8s\n", kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4, kolomNaam5, kolomNaam6);
            System.out.printf("-------------------------------------------------------------------- \n");

            for (int i = 0; i < gekozenBestellingenBijLeverancier.size(); i++) {
                Bestelling bes = gekozenBestellingenBijLeverancier.get(i);
                System.out.printf("%-10s %-10s %-12s %-12s %-8s %-8s\n", bes.getBestelNummer(), bes.getLeverancierCode(), bes.getBestelDatum(), bes.getLeverDatum(), bes.getBedrag(), bes.getStatus());
            }
            System.out.printf("-------------------------------------------------------------------- \n");
        } else
            System.out.println("Ongeldige invoer");
    }
}
