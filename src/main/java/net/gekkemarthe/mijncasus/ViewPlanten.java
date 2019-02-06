package net.gekkemarthe.mijncasus;

import java.util.ArrayList;

public class ViewPlanten {

    private PlantenFactory plantenFactory;
    private ArrayList<Plant> gekozenPlantenBijBestelRegel;
    private String kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4, kolomNaam5, kolomNaam6, kolomNaam7, kolomNaam8, kolomNaam9, kolomNaam10;

    ViewPlanten ()
    {
        plantenFactory = new PlantenFactory();
        plantenFactory.loadPlanten();

        Plant kolomNaam = plantenFactory.getPlanten().get(0);
        kolomNaam1 = kolomNaam.getArtikelCode();
        kolomNaam2 = kolomNaam.getPlantenNaam();
        kolomNaam3 = kolomNaam.getSoort();
        kolomNaam4 = kolomNaam.getKleur();
        kolomNaam5 = kolomNaam.getHoogte();
        kolomNaam6 = kolomNaam.getBloeiBegin();
        kolomNaam7 = kolomNaam.getBloeiEind();
        kolomNaam8 = kolomNaam.getPrijs();
        kolomNaam9 = kolomNaam.getVrr_aantal();
        kolomNaam10 = kolomNaam.getVrr_min();
    }

    public void toonPlanten (int keuze)
    {
        gekozenPlantenBijBestelRegel = plantenFactory.getPlantenBijBestelRegel(keuze);
        //artikelcode
        System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4, kolomNaam5, kolomNaam6, kolomNaam7, kolomNaam8, kolomNaam9, kolomNaam10);
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------- \n");

        for (int i = 0; i < gekozenPlantenBijBestelRegel.size(); i++) {
            Plant plant = gekozenPlantenBijBestelRegel.get(i);
            System.out.printf("%-10s %-15s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", plant.getArtikelCode(), plant.getPlantenNaam(), plant.getSoort(), plant.getKleur(), plant.getHoogte(), plant.getBloeiBegin(), plant.getBloeiEind(), plant.getPrijs(), plant.getVrr_aantal(), plant.getVrr_min());
        }
        System.out.printf("---------------------------------------------------------------------------------------------------------------------------------- \n");
    }
}
