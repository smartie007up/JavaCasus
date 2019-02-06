package net.gekkemarthe.mijncasus;

import java.io.IOException;
import java.util.ArrayList;

public class LeveranciersFactory {

    private ArrayList<Leverancier> leveranciers;
    private ArrayList<String> input;

    public void loadLeveranciers() {

        leveranciers = new ArrayList<Leverancier>();
        input = new ArrayList<String>();

        try {
            ReadInFile readInFile = new ReadInFile();
            input = readInFile.getLeveranciers();
            for (int i = 0; i < input.size() ; i++) {
                String temp = input.get(i);
                temp = temp.replaceAll("\"", "");
                String[] parts = temp.split(";");
                Leverancier leverancier = new Leverancier(parts[0], parts[1], parts[2], parts[3]);
                leveranciers.add(leverancier);
            }
        } catch (IOException e){
            System.out.println("Leveranciers could not be loaded.");
            e.printStackTrace();
        }
    }

    public ArrayList<Leverancier> getLeveranciers() {
        return leveranciers;
    }

    public ArrayList<Integer> getAllLeverancierCodes () {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < leveranciers.size(); i++) {
            Leverancier lev = leveranciers.get(i);
            int temp = Integer.parseInt(lev.getLeverancierCode());
                result.add(temp);
        }
        return result;
    }
}
