package net.gekkemarthe.mijncasus;

import java.io.IOException;
import java.util.ArrayList;

public class PlantenFactory
{
    ArrayList<Plant> planten;
    private ArrayList<String> input;

    public void loadPlanten ()
    {
        planten = new ArrayList<Plant>();
        input = new ArrayList<String>();

        try {
            ReadInFile readInFile = new ReadInFile();
            input = readInFile.getPlanten();
            for (int i = 0; i < input.size() ; i++) {
                String temp = input.get(i);
                temp = temp.replaceAll("\"", "");
                String[] parts = temp.split(";");
                Plant plant = new Plant(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9]);
                planten.add(plant);
            }
        } catch (IOException e){
            System.out.println("Planten could not be loaded.");
            e.printStackTrace();
        }
    }

    public ArrayList<Plant> getPlantenBijBestelRegel (int artikelCode)
    {
        ArrayList<Plant> result = new ArrayList<Plant>();

        for (int i = 1; i < planten.size() ; i++) {
            String temp = planten.get(i).getArtikelCode();
            int convert = Integer.parseInt(temp);
            if(convert == artikelCode){
                result.add(planten.get(i));
            }
        }
        return result;
    }

    public ArrayList<Plant> getPlanten() {
        return planten;
    }
}
