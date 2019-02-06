package net.gekkemarthe.mijncasus;

public class Plant {

    private String artikelCode, plantenNaam, soort, kleur, hoogte, bloeiBegin, bloeiEind, prijs, vrr_aantal, vrr_min;

    Plant(String artikelCode, String plantenNaam, String soort, String kleur, String hoogte, String bloeiBegin, String bloeiEind, String prijs,
          String vrr_aantal, String vrr_min)
    {
        this.artikelCode = artikelCode;
        this.plantenNaam = plantenNaam;
        this.soort = soort;
        this.kleur = kleur;
        this.hoogte = hoogte;
        this.bloeiBegin = bloeiBegin;
        this.bloeiEind = bloeiEind;
        this.prijs = prijs;
        this.vrr_aantal = vrr_aantal;
        this.vrr_min = vrr_min;
    }

    public StringBuilder getPlant ()
    {
        StringBuilder result = new StringBuilder();

        result.append(artikelCode).append(" ");
        result.append(plantenNaam).append(" ");
        result.append(soort).append(" ");
        result.append(kleur).append(" ");
        result.append(hoogte).append(" ");
        result.append(bloeiBegin).append(" ");
        result.append(bloeiEind).append(" ");
        result.append(prijs).append(" ");
        result.append(vrr_aantal).append(" ");
        result.append(vrr_min).append(" ");

        return result;
    }

    public String getArtikelCode() {
        return artikelCode;
    }

    public String getPlantenNaam() {
        return plantenNaam;
    }

    public String getSoort() {
        return soort;
    }

    public String getKleur () {
        return kleur;
    }

    public String getBloeiBegin() {
        return bloeiBegin;
    }

    public String getBloeiEind() {
        return bloeiEind;
    }

    public String getHoogte() {
        return hoogte;
    }

    public String getPrijs() {
        return prijs;
    }

    public String getVrr_aantal() {
        return vrr_aantal;
    }

    public String getVrr_min() {
        return vrr_min;
    }
}
