package net.gekkemarthe.mijncasus;

import java.io.IOException;
import java.util.ArrayList;

public class BestellingenFactory {

    private static ArrayList<Bestelling> bestellingen;
    private ArrayList<String> input;

    public void loadBestellingen ()
    {
        bestellingen = new ArrayList<Bestelling>();
        input = new ArrayList<String>();

        try {
            ReadInFile readInFile = new ReadInFile();
            input = readInFile.getBestellingen();
            for (int i = 0; i < input.size() ; i++) {
                String temp = input.get(i);
                temp = temp.replaceAll("\"", "");
                String[] parts = temp.split(";");
                Bestelling bestelling = new Bestelling(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                bestellingen.add(bestelling);
            }
        } catch (IOException e){
            System.out.println("Bestellingen could not be loaded.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException io){
            System.out.println("Bestellingen out of bounds.");
            io.printStackTrace();
        }
    }

    public ArrayList<Bestelling> getBestellingenVanLeverancier(int leverancierCode)
    {
        ArrayList<Bestelling> result = new ArrayList<Bestelling>();

        for (int i = 1; i < bestellingen.size() ; i++) {
            String temp = bestellingen.get(i).getLeverancierCode();
            int convert = Integer.parseInt(temp);
            if(convert == leverancierCode){
                result.add(bestellingen.get(i));
            }
        }
        return result;
    }

    public ArrayList<Bestelling> getBestellingen ()
    {
        return bestellingen;
    }

    public ArrayList<Integer> getAllBestelNummers () {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < bestellingen.size(); i++) {
            Bestelling bes = bestellingen.get(i);
            int temp = Integer.parseInt(bes.getBestelNummer());
            result.add(temp);
        }
        return result;
    }
}
