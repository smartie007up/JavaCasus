package net.gekkemarthe.mijncasus;

public class Bestelling {

    private String bestelNummer, leverancierCode, bestelDatum, leverDatum, bedrag, status;

    Bestelling(String bestelNummer, String leverancierCode, String bestelDatum, String leverDatum, String bedrag, String status)
    {
        this.bestelNummer = bestelNummer;
        this.leverancierCode = leverancierCode;
        this.bestelDatum = bestelDatum;
        this.leverDatum = leverDatum;
        this.bedrag = bedrag;
        this.status = status;
    }

    public StringBuilder getBestelling ()
    {
        StringBuilder result = new StringBuilder();

        result.append(bestelNummer).append(" ");
        result.append(leverancierCode).append(" ");
        result.append(bestelDatum).append(" ");
        result.append(leverDatum).append(" ");
        result.append(bedrag).append(" ");
        result.append(status);

        return result;
    }

    public String getBestelNummer () {
        return bestelNummer;
    }

    public String getLeverancierCode ()
    {
        return  leverancierCode;
    }

    public String getBestelDatum() {
        return bestelDatum;
    }

    public String getLeverDatum() {
        return leverDatum;
    }

    public String getBedrag() {
        return bedrag;
    }

    public String getStatus() {
        return status;
    }
}
