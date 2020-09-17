package adsd.app.zorgapp;

public class Profile {

    // creërt de variabelen van profiel
    private String voornaam;
    private String achternaam;
    private int leeftijd;
    private double gewicht;
    private double lengte;

    // Constructor   MAAK DIE ANDERE OOK NOG

    public Profile(String voornaam, String achternaam, int leeftijd, double gewicht,double lengte) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.leeftijd = leeftijd;
        this.gewicht = gewicht;
        this.lengte = lengte;

    }

    // Dit is om de variabelen te schrijven en op te halen
    public void setVoornaam(String voorNaam) {
        this.voornaam = voorNaam;
    }
    public void setachterNaam(String achterNaam) {
        this.achternaam = achterNaam;
    }
    public void setleefTijd(int leefTijd){
        this.leeftijd = leefTijd;
    }
    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
    public void setlengte(double lengte) {
        this.lengte = lengte;
    }
    public String getVoornaam() {
        return this.voornaam;
    }
    public String getAchternaam() {
        return this.achternaam;
    }
    public int getLeeftijd() {
        return this.leeftijd;
    }
    public double getGewicht(){
        return this.gewicht;
    }
    public double getLengte(){
        return this.lengte;
    }
    public String getBmi(){
        return String.valueOf(gewicht / (lengte * lengte));
    }

}

