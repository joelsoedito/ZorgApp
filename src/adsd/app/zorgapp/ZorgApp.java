package adsd.app.zorgapp;

import java.util.Scanner;

public class ZorgApp {

    // scanner zodat ie in alles gebruikt kan worden
    Scanner in = new Scanner(System.in);
    String userinput;

    // maakt nieuwe instance van profile

    private Profile patient;


    public void Login() {
        boolean exit = false;
        // creert patient profiel. Later kan er hier geimporteerd worden vanuit database.
        patient = new Profile("Joel", "Soedito", 23, 75.6, 1.93);

        //Vraag gebruiker wie hij is, in latere versie hier naar patient nummer oid vragen
        System.out.println("Bent u een Zorgverlener [1] of een Patiënt [2]?");
        do {
            userinput = in.nextLine();
            switch (userinput) {
                case "1":
                case "2":
                    exit = true;
                        PrintDetails();
                        EditOption();
                        break;
                default:
                    System.out.println("Voer Zorgverlener [1] of Patiënt [2] in.");

            }
        }
        while (!exit);
    }

    /* method om gegevens uit te printen zodat het niet elke keer herhaald hoeft te worden

       Later kan ik hier in 2 methods van maken om het verschil in patient en zorgverlener te doen.

       tussenvoegsoel toevoegen
     */

    public void EditOption(){
        boolean exit2 = false;
        System.out.println("Wilt u de gegevens wijzigen? Ja [1] of Nee [2]");
        do {

            userinput = in.next();
            switch (userinput) {
                case "1":
                    EditDetails();
                    exit2 = true;
                    break;
                case "2":
                    exit2 = true;
                    System.out.println("Tot ziens!");
                    break;
                default:
                    System.out.println("Voer Ja [1] of Nee [2] in.");
                    break;
            }
        }
        while (!exit2);

    }


    public void EditDetails(){


        userinput = in.nextLine();

        // Nieuwe voornaam
        System.out.print("Voer voornaam in en druk op \"Enter\": ");
        while (true) {
            String userinput = in.nextLine();
            if (userinput.length() < 2) {
                System.out.println("Deze naam is te kort!");
            } else if (!userinput.matches("[a-zA-Z]+")) {
                System.out.println("Alleen letters gebruiken!");
            } else {
                patient.setFirstname(userinput);
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
                patient.setLastname(name);
                break;
            }
        }
        // Nieuwe leeftijd
        System.out.print("Voer uw leeftijd in en druk op  \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige leeftijd.");
            in.nextLine();
        }
        int age = in.nextInt();
        patient.setAge(age);


        // Nieuw gewicht
        System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig gewicht.");
            in.nextLine();
        }
        int weight = in.nextInt();
        patient.setWeight(weight);

        // nieuwe lengte
        System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige lengte.");
            in.nextLine();
        }
        int length = in.nextInt();
        double meters = length;
        patient.setlength(meters / 100);

        // als laatste print hij de gegevens uit
        PrintDetails();
        EditOption();



    }
    public void PrintDetails() {


        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam: " + patient.getFirstname().substring(0, 1).toUpperCase()
                + patient.getFirstname().substring(1).toLowerCase()
                + " "
                + patient.getLastname().substring(0, 1).toUpperCase() + patient.getLastname().substring(1).toLowerCase());
        System.out.println("Leeftijd: " + patient.getAge());
        System.out.println("Lengte: " + patient.getLength() + "m");
        System.out.println("Gewicht: " + patient.getWeight() + "kg");
        System.out.println("Uw BMI is: " + String.format("%.1f", patient.getBmi())  + "\n");
    }
}

