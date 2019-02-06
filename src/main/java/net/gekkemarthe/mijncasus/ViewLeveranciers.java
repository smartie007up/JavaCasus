package net.gekkemarthe.mijncasus;

import javax.swing.text.View;
import java.util.ArrayList;

public class ViewLeveranciers {

    private LeveranciersFactory leveranciersFactory;
    private ArrayList<Leverancier> leveranciersList;
    private String kolumNaam1, kolumNaam2, kolumNaam3, kolumNaam4;

    ViewLeveranciers ()
    {
        leveranciersFactory = new LeveranciersFactory();
        leveranciersFactory.loadLeveranciers();

        leveranciersList = leveranciersFactory.getLeveranciers();

        kolumNaam1 = leveranciersList.get(0).getLeverancierCode();
        kolumNaam2 = leveranciersList.get(0).getLeverancierNaam();
        kolumNaam3 = leveranciersList.get(0).getAdres();
        kolumNaam4 = leveranciersList.get(0).getWoonplaats();
    }

    public void toonLeveranciers(){
        System.out.printf("%-10s %-18s %-25s %-10s \n", kolumNaam1, kolumNaam2, kolumNaam3, kolumNaam4);
        System.out.printf("-------------------------------------------------------------------- \n");

        for (int i = 1; i < leveranciersList.size(); i++) {
            Leverancier lev = leveranciersList.get(i);
            System.out.printf("%-10s %-18s %-25s %-10s \n", lev.getLeverancierCode(), lev.getLeverancierNaam(), lev.getAdres(), lev.getWoonplaats());
        }
        System.out.printf("-------------------------------------------------------------------- \n");
    }

    public ArrayList<Leverancier> getLeveranciersList() {
        return leveranciersList;
    }
}
