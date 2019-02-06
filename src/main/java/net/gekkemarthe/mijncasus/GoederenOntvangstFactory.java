package net.gekkemarthe.mijncasus;

import java.io.IOException;
import java.util.ArrayList;

public class GoederenOntvangstFactory {

    private ArrayList<GoederenOntvangst> goederen;
    private ArrayList<String> input;

    public void loadGoederenOntvangst ()
    {
        goederen = new ArrayList<GoederenOntvangst>();
        input = new ArrayList<String>();

        try {
            ReadInFile readInFile = new ReadInFile();
            input = readInFile.getGoed_ontvangst();
            for (int i = 0; i < input.size() ; i++) {
                String temp = input.get(i);
                temp = temp.replaceAll("\"", "");
                String[] parts = temp.split(";");
                GoederenOntvangst goederenOntvangst = new GoederenOntvangst(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
                goederen.add(goederenOntvangst);
            }
        } catch (IOException e){
            System.out.println("Goederen ontvangst could not be loaded.");
            e.printStackTrace();
        }
    }

    public ArrayList<GoederenOntvangst> getGoederen() {
        return goederen;
    }

    public ArrayList<GoederenOntvangst> getGoederenOntvangstVanBestelling (int bestelNummer)
    {
        ArrayList<GoederenOntvangst> result = new ArrayList<GoederenOntvangst>();

        for (int i = 1; i < goederen.size() ; i++) {
            String temp = goederen.get(i).getBestelNummer();
            int convert = Integer.parseInt(temp);
            if(convert == bestelNummer){
                result.add(goederen.get(i));
            }
        }
        return result;
    }

    public ArrayList<Integer> getAllArtikelCodes () {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < goederen.size(); i++) {
            GoederenOntvangst g = goederen.get(i);
            int temp = Integer.parseInt(g.getArtikelCode());
            result.add(temp);
        }
        return result;
    }
}
