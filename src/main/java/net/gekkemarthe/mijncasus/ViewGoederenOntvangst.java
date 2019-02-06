package net.gekkemarthe.mijncasus;

import java.util.ArrayList;

public class ViewGoederenOntvangst {

    private GoederenOntvangstFactory goederenOntvangstFactory;
    private ArrayList<GoederenOntvangst> gekozenGoederenBijBestelling;
    private String kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4, kolomNaam5, kolomNaam6, kolomNaam7;
    private ArrayList<Integer> allGoederenBestelNummers;


    ViewGoederenOntvangst ()
    {
        goederenOntvangstFactory = new GoederenOntvangstFactory();
        goederenOntvangstFactory.loadGoederenOntvangst();
        allGoederenBestelNummers = goederenOntvangstFactory.getAllArtikelCodes();

        GoederenOntvangst kolomNaam = goederenOntvangstFactory.getGoederen().get(0);
        kolomNaam1 = kolomNaam.getBestelNummer();
        kolomNaam2 = kolomNaam.getArtikelCode();
        kolomNaam3 = kolomNaam.getOntvangstDatum();
        kolomNaam4 = kolomNaam.getOntvangenAantal();
        kolomNaam5 = kolomNaam.getStatus();
        kolomNaam6 = kolomNaam.getBoekStuk();
        kolomNaam7 = kolomNaam.getVolgNummer();
    }

    public void toonGoederenOntvangst(int keuze)
    {
        gekozenGoederenBijBestelling = goederenOntvangstFactory.getGoederenOntvangstVanBestelling(keuze);

        System.out.println(" ********************* Ontvangen goederen overzicht ********************* \n");
        System.out.printf("%-10s %-10s %-12s %-12s %-8s %-8s %-8s\n", kolomNaam1, kolomNaam2, kolomNaam3, kolomNaam4, kolomNaam5, kolomNaam6, kolomNaam7);
        System.out.printf("----------------------------------------------------------------------------- \n");

        for (int i = 0; i < gekozenGoederenBijBestelling.size(); i++) {
            GoederenOntvangst goederenOntvangst = gekozenGoederenBijBestelling.get(i);
            System.out.printf("%-10s %-10s %-12s %-12s %-10s %-10s %-10s\n", goederenOntvangst.getBestelNummer(), goederenOntvangst.getArtikelCode(), goederenOntvangst.getOntvangstDatum(), goederenOntvangst.getOntvangenAantal(), goederenOntvangst.getStatus(), goederenOntvangst.getBoekStuk(), goederenOntvangst.getVolgNummer());
        }
        System.out.printf("----------------------------------------------------------------------------- \n");
    }

    public void pasAanGoederenOntvangst(int keuze)
    {

    }

    public boolean isLeeg(int keuze)
    {
        if(allGoederenBestelNummers.size() == 0){
            return true;
        }
        else
            return false;
    }
}
