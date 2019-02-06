package net.gekkemarthe.mijncasus;

import java.io.*;
import java.util.ArrayList;

public class ReadInFile
{
    private ArrayList<String> bestellingen, bestelregels, goed_ontvangst, klanten, leveranciers, planten;

    public ArrayList<String> readInFile (String pathName) throws IOException {
        ArrayList<String> input = new ArrayList<String>();
        File file = new File(pathName);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                input.add(st);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException et) {
            et.printStackTrace();
        } finally {
            br.close();
        }
        return input;
    }

    public ArrayList<String> getLeveranciers () throws IOException {
        leveranciers = readInFile("src/main/resources/leveranciers.csv");
        return leveranciers;
    }

    public ArrayList<String> getBestellingen () throws IOException {
        bestellingen = readInFile("src/main/resources/bestellingen.csv");
        return bestellingen;
    }

    public ArrayList<String> getBestelregels () throws IOException {
        bestelregels = readInFile("src/main/resources/bestelregels.csv");
        return bestelregels;
    }

    public ArrayList<String> getGoed_ontvangst () throws IOException {
        goed_ontvangst = readInFile("src/main/resources/goed_ontvangst.csv");
        return goed_ontvangst;
    }

    public ArrayList<String> getPlanten () throws IOException {
        planten = readInFile("src/main/resources/planten.csv");
        return planten;
    }

    public ArrayList<String> getKlanten () throws IOException {
        klanten = readInFile("src/main/resources/klanten.csv");
        return klanten;
    }
}
