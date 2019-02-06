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
    ViewGoederenOntvangst viewGoederenOntvangst;

    UI() {
        bedrijfsNaam = "Plantenlust";
        viewLeveranciers = new ViewLeveranciers();
        viewBestellingen = new ViewBestellingen();
        viewBestelRegels = new ViewBestelRegels();
        viewPlanten = new ViewPlanten();
        viewGoederenOntvangst = new ViewGoederenOntvangst();
        keuzes = new int[4];
    }

    public void start() {
        System.out.printf("\n");
        System.out.printf("****************** Welkom bij tuincentrum %s ****************** \n", bedrijfsNaam);

        UI ui = new UI();

        Boolean runProgram = true;
        toonHoofdMenu();

        while (runProgram) {
            int invoer = invoerKeuze();

            switch (invoer) {
                case 1:
                    leverancierMenu();
                    bestellingenMenu();
                    bestelRegelsMenu();
                    plantenMenu();
                    eindBericht();

                    break;
                case 2:
                    leverancierMenu();
                    bestellingenMenu();
                    goederenOnvangstMenu();

                    eindBericht();

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

    public void eindBericht ()
    {
        System.out.printf("\n");
        System.out.println(" ********************************************** ");
        System.out.println(" *** Meer opties zijn er niet               *** ");
        System.out.println(" *** Terug naar het hoofdmenu? Typ 0        *** ");
        System.out.println(" *** Of typ 9 om af te sluiten              *** ");
        System.out.println(" ********************************************** ");
    }

    public void toonHoofdMenu() {
        System.out.printf("\n");
        System.out.printf("****************************** Hoofd Menu ****************************** \n");
        System.out.printf("\n");
        System.out.printf("Kies de actie die u wilt ondernemen: \n");
        System.out.printf("\n");
        System.out.printf("%10s", "");
        System.out.printf("1. Tonen van bestellingen, bestelregels en planten \n");
        System.out.printf("%10s", "");
        System.out.printf("2. Aanpassen van goederen ontvangst van bestellingen \n");
        System.out.printf("%10s", "");
        System.out.printf("9. Kies 9 om af te sluiten \n");
        System.out.printf("\n");
        System.out.printf("Uw keuze: ");
    }

    public void leverancierMenu() {
        System.out.printf("\n");
        System.out.printf("\n");
        viewLeveranciers.toonLeveranciers();
    }

    public void bestellingenMenu() {
        System.out.println(" Van welke leverancier wilt u de bestellingen zien? ");
        System.out.printf(" Typ de juiste leveranciercode in: ");

        int welkeLeverancierCode = invoerKeuze();
        if(viewBestellingen.isLeeg(welkeLeverancierCode)){
            System.out.println("De gekozen leverancier heeft geen bestellingen");
            System.out.println("Probeer het nogmaals.");
        }
        else if (viewLeveranciers.magGekozen(welkeLeverancierCode)) {
            System.out.printf("\n");
            System.out.printf("\n");
            viewBestellingen.toonBestellingen(welkeLeverancierCode);
            keuzes[0] = welkeLeverancierCode;
            System.out.println("Leveranciercode = " + keuzes[0]);
            System.out.printf("\n");
        } else {
            ongeldigeInvoer();
            bestellingenMenu();
        }
    }

    public void bestelRegelsMenu() {
        System.out.println(" Van welke bestelling wilt u de bestelregels zien? ");
        System.out.printf(" Typ het juiste bestelnummer in: ");

        int welkBestelNummer = invoerKeuze();
        if(viewBestelRegels.isLeeg(welkBestelNummer)){
            System.out.println("De gekozen bestelling heeft geen bestelregels");
            System.out.println("Probeer het nogmaals.");
        }
        else if (viewBestellingen.magGekozen(welkBestelNummer)) {
            System.out.printf("\n");
            System.out.printf("\n");
            viewBestelRegels.toonBestelRegels(welkBestelNummer);
            keuzes[1] = welkBestelNummer;
            System.out.println("Leveranciercode = " + keuzes[0] + ", " + "Bestelnummer = " + keuzes[1]);
            System.out.printf("\n");
        } else {
            ongeldigeInvoer();
            bestelRegelsMenu();
        }
    }

    public void goederenOnvangstMenu ()
    {
        System.out.println(" Van welke bestelling wilt u de ontvangen goederen zien? ");
        System.out.printf(" Typ het juiste bestelnummer in: ");

        int welkBestelNummer = invoerKeuze();
        if(viewGoederenOntvangst.isLeeg(welkBestelNummer)){
            System.out.println("De gekozen bestelling heeft geen ontvangen goederen");
            System.out.println("Probeer het nogmaals.");
        }
        else if (viewBestellingen.magGekozen(welkBestelNummer)) {
            System.out.printf("\n");
            System.out.printf("\n");
            viewGoederenOntvangst.toonGoederenOntvangst(welkBestelNummer);
            keuzes[1] = welkBestelNummer;
            System.out.println("Leveranciercode = " + keuzes[0] + ", " + "Bestelnummer = " + keuzes[1]);
            System.out.printf("\n");
        } else {
            ongeldigeInvoer();
            goederenOnvangstMenu();
        }
    }

    public void plantenMenu() {
        System.out.println(" Van welke Bestelregel wilt u de planten uit de bestelling zien? ");
        System.out.printf(" Typ de juiste artikelcode in: ");

        int welkeArtikelCode = invoerKeuze();
        if (viewBestelRegels.magGekozen(welkeArtikelCode)) {
            System.out.printf("\n");
            System.out.printf("\n");
            viewPlanten.toonPlanten(welkeArtikelCode);
            keuzes[2] = welkeArtikelCode;
            System.out.println("Leveranciercode = " + keuzes[0] + ", " + "Bestelnummer = " + keuzes[1] + ", " + "Artikelcode = " + keuzes[2]);
            System.out.printf("\n");
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
