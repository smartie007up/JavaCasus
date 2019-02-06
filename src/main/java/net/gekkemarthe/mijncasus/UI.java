package net.gekkemarthe.mijncasus;

import javax.swing.text.View;
import java.util.Scanner;

public class UI {

    String bedrijfsNaam;
    String invoer;
    Scanner sc;

    ViewLeveranciers viewLeveranciers;
    ViewBestelRegels viewBestelRegels;
    ViewBestellingen viewBestellingen;
    ViewPlanten viewPlanten;

    UI ui;

    UI ()
    {
        bedrijfsNaam = "Plantenlust";
        viewLeveranciers = new ViewLeveranciers();
        viewBestellingen = new ViewBestellingen();
        viewBestelRegels = new ViewBestelRegels();
        viewPlanten = new ViewPlanten();
        ui = new UI();
    }

    public void start () {
        System.out.printf("\n");
        System.out.printf("******* Welkom bij tuincentrum %s ******* \n", bedrijfsNaam);

        ui.sc = new Scanner(System.in);

        Boolean runProgram = true;

        ui.toonHoofdMenu();

        while(runProgram)
        {
            ui.invoer = ui.sc.nextLine();
            int keuze = Integer.parseInt(ui.invoer);

            switch (keuze){
                case 1:
                    leverancierMenu();

                    bestellingMenu();

                    viewBestellingen.toonBestellingen(keuze);
                    String gekozenLeverancierCode = "Leveranciercode = " + keuze;
                    System.out.println(gekozenLeverancierCode);
                    System.out.println(" Van welke Bestelling wilt u de bestelregels zien? ");
                    System.out.printf(" Typ het juiste bestelnummer in: \n");
                    ui.invoer = ui.sc.nextLine();
                    keuze = Integer.parseInt(ui.invoer);

                    viewBestelRegels.toonBestelRegels(keuze);
                    String gekozenBestelNummer = "Bestelnummer = " + keuze;
                    System.out.println(gekozenLeverancierCode + ", " + gekozenBestelNummer);
                    System.out.println(" Van welke Bestelregel wilt u de planten uit de bestelling zien? ");
                    System.out.printf(" Typ de juiste artikelcode in: \n");
                    ui.invoer = ui.sc.nextLine();
                    keuze = Integer.parseInt(ui.invoer);

                    viewPlanten.toonPlanten(keuze);
                    String gekozenArtikelCode = "Artikelcode = " + keuze;
                    System.out.println(gekozenLeverancierCode + ", " + gekozenBestelNummer + ", " + gekozenArtikelCode);
                    System.out.println(" *** Meer opties zijn er niet *** ");
                    System.out.println(" *** Terug naar het hoofdmenu? Typ 9 ***");

                    break;
                case 2:
                    ViewAankopen.toonAankopen();
                    break;
                case 9:
                    runProgram = false;
                    System.out.println("Einde programma");
                    break;
                default:
                    System.out.println("Ongeldige keuze");
                    break;
            }
        }
        ui.sc.close();
    }

    public void toonHoofdMenu()
    {
        System.out.printf("\n");
        System.out.printf("******************* Hoofd Menu ******************* \n");
        System.out.printf("\n");
        System.out.printf("Kies de actie die u wilt ondernemen: \n");
        System.out.printf("\n");
        System.out.printf("%10s", "");
        System.out.printf("1. Tonen \n");
        System.out.printf("%10s", "");
        System.out.printf("2. Aanpassen \n");
        System.out.printf("%10s", "");
        System.out.printf("9. Kies 9 om af te sluiten \n");
        System.out.printf("\n");
        System.out.printf("Uw keuze: ");
    }

    public void leverancierMenu ()
    {
        viewLeveranciers.toonLeveranciers();
    }

    public void bestellingMenu ()
    {
        ui.invoer = ui.sc.nextLine();
        System.out.println(" Van welke Leverancier wilt u de bestellingen zien? ");
        System.out.printf(" Typ de juiste leveranciercode in: \n");
        int keuze = Integer.parseInt(ui.invoer);
    }

    public void bestelRegelMenu ()
    {
        ui.invoer = ui.sc.nextLine();
        int keuze = Integer.parseInt(ui.invoer);
    }
}
