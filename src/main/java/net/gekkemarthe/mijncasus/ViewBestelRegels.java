package net.gekkemarthe.mijncasus;

import java.util.ArrayList;

public class ViewBestelRegels {

    private BestelRegelsFactory bestelRegelsFactory;
    private ArrayList<BestelRegel> bestelRegels;
    private String kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4;

    ViewBestelRegels () {
        bestelRegelsFactory = new BestelRegelsFactory();
        bestelRegelsFactory.loadBestelRegels();

        BestelRegel kolomNaam = bestelRegelsFactory.getBestelRegels().get(0);
        kolomNaam1 = kolomNaam.getBestelNummer();
        kolomNaam2 = kolomNaam.getArtikelCode();
        kolomNaam3 = kolomNaam.getAantal();
        kolomNaam4 = kolomNaam.getBestelPrijs();
    }

    public void toonBestelRegels (int keuze)
    {
        bestelRegels = bestelRegelsFactory.getBestelRegelsVanBestelling(keuze);

        System.out.printf("%-10s %-10s %-10s %-10s \n", kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4);
        System.out.printf("------------------------------------------------ \n");

        for (int i = 0; i < bestelRegels.size(); i++) {
            BestelRegel bes = bestelRegels.get(i);
            System.out.printf("%-10s %-10s %-10s %-10s \n", bes.getBestelNummer(), bes.getArtikelCode(), bes.getAantal(), bes.getBestelPrijs());
        }
        System.out.printf("------------------------------------------------ \n");
    }
}
