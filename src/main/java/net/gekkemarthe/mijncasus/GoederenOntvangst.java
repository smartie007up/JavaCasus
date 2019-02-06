package net.gekkemarthe.mijncasus;

public class GoederenOntvangst {

    private String bestelNummer, artikelCode, ontvangstDatum, ontvangenAantal, status, boekStuk, volgNummer;


    GoederenOntvangst(String bestelNummer, String artikelCode, String ontvangstDatum, String ontvangenAantal, String status, String boekStuk, String volgNummer)
    {
        this.bestelNummer = bestelNummer;
        this.artikelCode = artikelCode;
        this.ontvangstDatum = ontvangstDatum;
        this.ontvangenAantal = ontvangenAantal;
        this.status = status;
        this.boekStuk = boekStuk;
        this.volgNummer = volgNummer;
    }

    public String getBestelNummer ()
    {
        return bestelNummer;
    }

    public String getArtikelCode ()
    {
        return artikelCode;
    }

    public String getOntvangstDatum ()
    {
        return ontvangstDatum;
    }

    public String getOntvangenAantal ()
    {
        return ontvangenAantal;
    }

    public String getStatus ()
    {
        return status;
    }

    public String getBoekStuk ()
    {
        return boekStuk;
    }

    public String getVolgNummer ()
    {
        return volgNummer;
    }
}
