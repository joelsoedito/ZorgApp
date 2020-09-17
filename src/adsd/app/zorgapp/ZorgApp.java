package adsd.app.zorgapp;

import java.util.Scanner;

public class ZorgApp {

    // maakt nieuwe instance van profile
    private Profile patient;


    /* method om gegevens uit te printen zodat het niet elke keer herhaald hoeft te worden

       Later kan ik hier in 2 methods van maken om het verschil in patient en zorgverlener te doen.

       tussenvoegsoel toevoegen
     */
    public void printDetails() {
        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam: " + patient.getVoornaam().substring(0,1).toUpperCase()
                + patient.getVoornaam().substring(1).toLowerCase()
                + " "
                + patient.getAchternaam().substring(0,1).toUpperCase() + patient.getAchternaam().substring(1).toLowerCase());
        System.out.println("Leeftijd: " + patient.getLeeftijd());
        System.out.println("Lengte: " + patient.getLengte() + "m");
        System.out.println("Gewicht: " + patient.getGewicht() + "kg");
        System.out.println("Uw BMI is: " + patient.getBmi() + "\n");
    }

    // meerdere constructors maken
    public ZorgApp() {

        // patient wordt aangemaakt, en later geimporteerd

        patient = new Profile("joel", "soedito", 23, 75.6, 1.93);

    }

    public void ViewData() {
        // creeër aantal variabelen en import scanner
        Scanner in = new Scanner(System.in);
        String line;
        boolean exit = false;
        boolean exit2 = false;

        //Vraag gebruiker wie hij is


        System.out.println("Bent u een Zorgverlener [1] of een Patiënt [2]?");
        do {
            line = in.nextLine();
            switch (line) {
                case "1", "2" -> exit = true;
                default -> {
                    System.out.println("Voer Zorgverlener [1] of Patiënt [2] in.");
                }
            }
        }
        while (!exit);


        //Na gemaakte keuze print systeem gegevens patient uit

        printDetails();

        //optie om gegevens te wijzigen

        System.out.println("Wilt u de gegevens wijzigen? Ja [1] of Nee [2]");

        do {
            line = in.nextLine();
            switch (line) {
                case "1":
                    exit2 = true;
                    // Nieuwe voornaam
                    System.out.print("Voer voornaam in en druk op \"Enter\": ");
                    while (true) {
                        String name = in.nextLine();
                        if (name.length() < 2) {
                            System.out.println("Deze naam is te kort!");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Alleen letters gebruiken!");
                        } else {
                            patient.setVoornaam(name);
                            break;
                        }
                    }
                    // Nieuwe achternaam
                    System.out.print("Voer achternaam in en druk op \"Enter\": ");
                    while (true) {
                        String name = in.nextLine();
                        if (name.length() < 2) {
                            System.out.println("Deze naam is te kort!");
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Alleen letters gebruiken!");
                        } else {
                            patient.setachterNaam(name);
                            break;
                        }
                    }
                    // Nieuwe leeftijd
                    System.out.print("Voer uw leeftijd in en druk op  \"Enter\": ");
                    while (!in.hasNextInt()) {
                        System.out.println("Dit is geen geldige leeftijd.");
                        in.nextLine();
                    }
                    int leeftijd = in.nextInt();
                    patient.setleefTijd(leeftijd);


                    // Nieuw gewicht
                    System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
                    while (!in.hasNextInt()) {
                        System.out.println("Dit is geen geldig gewicht.");
                        in.nextLine();
                    }
                    int gewicht = in.nextInt();
                    patient.setGewicht(gewicht);

                    // nieuwe lengte
                    System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
                    while (!in.hasNextInt()) {
                        System.out.println("Dit is geen geldige lengte.");
                        in.nextLine();
                    }
                    int lengte = in.nextInt();
                    double meters = lengte;
                    patient.setlengte(meters / 100);

                    // als laatste print hij de gegevens uit
                    printDetails();
                    break;

                case "2":
                    exit2 = true;
                    System.out.println("Bedankt en tot ziens!");
                    break;

                default:
                    exit2 = false;
                    System.out.println("Voer Ja [1] of Nee [2] in.");
                    break;

            }
        }
        while(!exit2);


    }
}

