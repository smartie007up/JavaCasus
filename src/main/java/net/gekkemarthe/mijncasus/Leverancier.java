package net.gekkemarthe.mijncasus;


public class Leverancier {

    private String leverancierCode, leverancierNaam, adres, woonplaats;

    Leverancier(String leverancierCode, String leverancierNaam, String adres, String woonplaats) {
        this.leverancierCode = leverancierCode;
        this.leverancierNaam = leverancierNaam;
        this.adres = adres;
        this.woonplaats = woonplaats;
    }

//    public String getLeverancier() {
//        String concat = "";
//        concat = leverancierCode.concat(" ").concat(leverancierNaam).concat(" ").concat(adres).concat(" ").concat(woonplaats);
//        return concat;
//    }

    public String getLeverancierCode()
    {
        return leverancierCode;
    }

    public String getLeverancierNaam ()
    {
        return leverancierNaam;
    }

    public String getAdres ()
    {
        return adres;
    }

    public String getWoonplaats ()
    {
        return woonplaats;
    }
}
