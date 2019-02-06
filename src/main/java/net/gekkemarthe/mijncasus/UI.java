package net.gekkemarthe.mijncasus;

import java.util.Scanner;

public class UI {

    String bedrijfsNaam;
    Scanner sc;

    int[] keuzes;

    ViewLeveranciers viewLeveranciers;
    ViewBestelRegels viewBestelRegels;
    ViewBestellingen viewBestellingen;
    ViewPlanten viewPlanten;

    UI() {
        bedrijfsNaam = "Plantenlust";
        viewLeveranciers = new ViewLeveranciers();
        viewBestellingen = new ViewBestellingen();
        viewBestelRegels = new ViewBestelRegels();
        viewPlanten = new ViewPlanten();
        keuzes = new int[4];
    }

    public void start() {
        System.out.printf("\n");
        System.out.printf("******* Welkom bij tuincentrum %s ******* \n", bedrijfsNaam);

        UI ui = new UI();

        Boolean runProgram = true;
        toonHoofdMenu();

        while (runProgram) {
            int invoer = invoerKeuze();

            switch (invoer) {
                case 1:
                    leverancierMenu();

                    bestellingenMenu();
                    System.out.println("Leveranciercode = " + keuzes[0]);

                    bestelRegelsMenu();
                    System.out.println("Leveranciercode = " + keuzes[0] + ", " + "Bestelnummer = " + keuzes[1]);

                    plantenMenu();
                    System.out.println("Leveranciercode = " + keuzes[0] + ", " + "Bestelnummer = " + keuzes[1] + ", " + "Artikelcode = " + keuzes[2]);

                    System.out.println(" *** Meer opties zijn er niet *** ");
                    System.out.println(" *** Terug naar het hoofdmenu? Typ 0 ***");
                    System.out.println(" *** Of typ 9 om af te sluiten ***");

                    break;
                case 2:
                    ViewAankopen.toonAankopen();
                    break;
                case 0:
                    toonHoofdMenu();
                    break;
                case 9:
                    runProgram = false;
                    System.out.println("Einde programma");
                    break;
                default:
                    ongeldigeInvoer();
                    break;
            }
        }
        ui.sc.close();
    }

    public void ongeldigeInvoer()
    {
        System.out.println("Ongeldige keuze");
        System.out.println("Probeer het nogmaals");
    }

    public void toonHoofdMenu() {
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

    public void leverancierMenu() {
        viewLeveranciers.toonLeveranciers();
    }

    public void bestellingenMenu() {
        System.out.println(" Van welke leverancier wilt u de bestellingen zien? ");
        System.out.printf(" Typ de juiste leveranciercode in: \n");

        int welkeLeverancierCode = invoerKeuze();
        if(viewBestellingen.isLeeg(welkeLeverancierCode)){
            System.out.println("De gekozen leverancier heeft geen bestellingen");
            System.out.println("Probeer het nogmaals.");
        }
        else if (viewLeveranciers.magGekozen(welkeLeverancierCode)) {
            viewBestellingen.toonBestellingen(welkeLeverancierCode);
            keuzes[0] = welkeLeverancierCode;
        } else {
            ongeldigeInvoer();
            bestellingenMenu();
        }
    }

    public void bestelRegelsMenu() {
        System.out.println(" Van welke bestelling wilt u de bestelregels zien? ");
        System.out.printf(" Typ het juiste bestelnummer in: \n");

        int welkBestelNummer = invoerKeuze();
        if(viewBestelRegels.isLeeg(welkBestelNummer)){
            System.out.println("De gekozen bestelling heeft geen bestelregels");
            System.out.println("Probeer het nogmaals.");
        }
        else if (viewBestellingen.magGekozen(welkBestelNummer)) {
            viewBestelRegels.toonBestelRegels(welkBestelNummer);
            keuzes[1] = welkBestelNummer;
        } else {
            ongeldigeInvoer();
            bestelRegelsMenu();
        }
    }

    public void plantenMenu() {
        System.out.println(" Van welke Bestelregel wilt u de planten uit de bestelling zien? ");
        System.out.printf(" Typ de juiste artikelcode in: \n");

        int welkeArtikelCode = invoerKeuze();
        if (viewBestelRegels.magGekozen(welkeArtikelCode)) {
            viewPlanten.toonPlanten(welkeArtikelCode);
            keuzes[2] = welkeArtikelCode;
        } else {
            ongeldigeInvoer();
            plantenMenu();
        }
    }

    public int invoerKeuze (){
        Scanner scanner = new Scanner(System.in);

        int result;
        do {
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is geen juiste invoer.\n Probeer het nogmaals.", input);
            }
            result = scanner.nextInt();
        } while (result < 0);

        return result;
    }
}
