package net.gekkemarthe.mijncasus;

import java.io.IOException;
import java.util.ArrayList;

public class Factory {

    private ArrayList<Object> totalList;
    private ArrayList<String> input;

    public void loadObjects () {
        totalList = new ArrayList<Object>();
        input = new ArrayList<String>();

        try {
            ReadInFile readInFile = new ReadInFile();
            input = readInFile.getInputFile("bestellingen");
            System.out.println("TADAAAAAAAA" + input);

        } catch (IOException e) {
            System.out.println("Leveranciers could not be loaded.");
            e.printStackTrace();
        }
    }
}
//
//
//
//    private ArrayList<Leverancier> leveranciers;
//    private ArrayList<String> input;
//
//    public void loadLeveranciers() {
//
//        leveranciers = new ArrayList<Leverancier>();
//        input = new ArrayList<String>();
//
//        try {
//            ReadInFile readInFile = new ReadInFile();
//            input = readInFile.getLeveranciers();
//            for (int i = 0; i < input.size() ; i++) {
//                String temp = input.get(i);
//                temp = temp.replaceAll("\"", "");
//                String[] parts = temp.split(";");
//                Leverancier leverancier = new Leverancier(parts[0], parts[1], parts[2], parts[3]);
//                leveranciers.add(leverancier);
//            }
//        } catch (IOException e){
//            System.out.println("Leveranciers could not be loaded.");
//            e.printStackTrace();
//        }
//    }
//
//    public ArrayList<Leverancier> getLeveranciers() {
//        return leveranciers;
//    }
//}
