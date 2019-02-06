package net.gekkemarthe.mijncasus;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReadInFile
{
    private ArrayList<String> bestellingen, bestelregels, goed_ontvangst, klanten, leveranciers, planten;

    ReadInFile () throws IOException
    {
        bestellingen = readInFile("src/main/resources/bestellingen.csv");
        bestelregels = readInFile("src/main/resources/bestelregels.csv");
        goed_ontvangst = readInFile("src/main/resources/goed_ontvangst.csv");
        klanten = readInFile("src/main/resources/klanten.csv");
        leveranciers = readInFile("src/main/resources/leveranciers.csv");
        planten = readInFile("src/main/resources/planten.csv");
    }

    public ArrayList<String> getInputFile(String pathFile) throws IOException {
        String result = "";
        String path = "src/main/resources/";
        String pathEnd = ".csv";
        result = path + pathFile + pathEnd;
        return readInFile(result);
    }


    public ArrayList<String> readInFile (String pathName) throws IOException
    {
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
            fnfe.fillInStackTrace();
        } catch (IOException et) {
            et.printStackTrace();
        } finally {
            br.close();
        }
        return input;
    }

    public ArrayList<String> getLeveranciers ()
    {
        return leveranciers;
    }

    public ArrayList<String> getBestellingen ()
    {
        return bestellingen;
    }

    public ArrayList<String> getBestelregels ()
    {
        return bestelregels;
    }

    public ArrayList<String> getGoed_ontvangst ()
    {
        return goed_ontvangst;
    }

    public ArrayList<String> getPlanten ()
    {
        return planten;
    }

    public ArrayList<String> getKlanten ()
    {
        return klanten;
    }
}
