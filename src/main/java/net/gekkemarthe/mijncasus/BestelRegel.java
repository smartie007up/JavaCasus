package net.gekkemarthe.mijncasus;

public class BestelRegel
{
    private String bestelNummer, artikelCode, aantal, bestelPrijs;

    BestelRegel(String bestelNummer, String artikelCode, String aantal, String bestelPrijs) {
        this.bestelNummer = bestelNummer;
        this.artikelCode = artikelCode;
        this.aantal = aantal;
        this.bestelPrijs = bestelPrijs;
    }

    public StringBuilder getBestelRegel ()
    {
        StringBuilder result = new StringBuilder();

        result.append(bestelNummer).append(" ");
        result.append(artikelCode).append(" ");
        result.append(aantal).append(" ");
        result.append(bestelPrijs).append(" ");

        return result;
    }

    public String getBestelNummer() {
        return bestelNummer;
    }

    public String getArtikelCode() {
        return artikelCode;
    }

    public String getAantal() {
        return aantal;
    }

    public String getBestelPrijs() {
        return bestelPrijs;
    }
}
