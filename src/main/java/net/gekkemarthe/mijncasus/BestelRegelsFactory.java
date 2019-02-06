package net.gekkemarthe.mijncasus;

import java.io.IOException;
import java.util.ArrayList;

public class BestelRegelsFactory {

    private ArrayList<BestelRegel> bestelRegels;
    private ArrayList<String> input;

    public void loadBestelRegels() {

        bestelRegels = new ArrayList<BestelRegel>();
        input = new ArrayList<String>();

        try {
            ReadInFile readInFile = new ReadInFile();
            input = readInFile.getBestelregels();
            System.out.println(input.get(0));
            for (int i = 0; i < input.size(); i++) {
                String temp = input.get(i);
                temp = temp.replaceAll("\"", "");
                String[] parts = temp.split(";");
                BestelRegel bestelRegel = new BestelRegel(parts[0], parts[1], parts[2], parts[3]);
                bestelRegels.add(bestelRegel);
            }
        } catch (IOException e) {
            System.out.println("Bestelregels could not be loaded.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException io){
            System.out.println("Bestellingen out of bounds.");
            io.printStackTrace();
        }
    }

    public ArrayList<BestelRegel> getBestelRegelsVanBestelling (int bestelNummer)
    {
        ArrayList<BestelRegel> result = new ArrayList<BestelRegel>();

        for (int i = 1; i < bestelRegels.size() ; i++) {
            String temp = bestelRegels.get(i).getBestelNummer();
            int convert = Integer.parseInt(temp);
            if(convert == bestelNummer){
                result.add(bestelRegels.get(i));
            }
        }
        return result;
    }

    public ArrayList<BestelRegel> getBestelRegels() {
        return bestelRegels;
    }
}
