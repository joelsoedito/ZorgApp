package adsd.app.zorgapp;

import java.util.ArrayList;
import java.util.Scanner;

public class ZorgApp {

    // scanner zodat ie in alles gebruikt kan worden
    Scanner in = new Scanner(System.in);

    // maakt nieuwe instance van profile

    private Profile patient;
    private Medicine medicine;



    public void Login() {
        boolean exit = false;
        // creert patient profiel.
        patient = new Profile("Joel", "Soedito", 23, 75.6, 1.93);



        //Vraag gebruiker wie hij is, in latere versie hier naar patient nummer oid vragen
        System.out.println("Bent u een Zorgverlener [1] of een Patiënt [2]?");
        do {
            switch (in.nextLine()) {
                case "1":
                    ZorverlenerMenu();
                    exit = true;
                    break;

                case "2":
                    PatientenMenu();
                    exit = true;
                    break;

                default:
                    System.out.println("Voer Zorgverlener [1] of Patiënt [2] in.");
            }
        }
        while (!exit);
    }

    private void ZorverlenerMenu() {

        // patient zoeken
        // System.out.println("\nVoer het patient ID in");

        //gegevens weergeven
        System.out.println("\nMaak uw keuze: \n[1] Gegevens bekijken \n[2] Gegevens Wijzigen \n[3] Medicijnen bekijken \n[4] Medicijnen wijzigen");
        boolean exit3 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    PrintDetails();
                    ZorverlenerMenu();
                    exit3 = true;
                    break;
                case "2":
                    EditDetailsMenu();
                    ZorverlenerMenu();
                    exit3 = true;
                    break;

                case "3":
                    // Medicijnen weergeven
                    break;
                case "4":
                    // Medicijnen wijzigen
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    break;
            }
        } while (!exit3);
    }

    private void PatientenMenu(){
        System.out.println("\nMaak uw keuze: \n[1] Gegevens bekijken \n[2] Gegevens Wijzigen \n[3] Medicijnen bekijken");
        boolean exit4 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    PrintDetails();
                    PatientenMenu();
                    exit4 = true;
                    break;
                case "2":
                    EditDetailsMenu();
                    PatientenMenu();
                    exit4 = true;
                    break;

                case "3":
                    // Medicijnen weergeven
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    break;
            }
        } while (!exit4);

    }


    /*public void EditOption() {
        boolean exit2 = false;
        System.out.println("Wilt u uw gegevens wijzigen? Ja [1] of Nee [2]");
        do {

            switch (in.nextLine()) {
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
    */


    private void EditDetailsMenu() {
        //gegevens bewerken
        System.out.println("\nWelke gegevens wilt u wijzigen? \n[1] Voornaam \n[2] Achternaam \n[3] Leeftijd \n[4] Gewicht \n[5] Lengte \n[6] Alle gegevens");
        boolean exit2 = true;
        do {
            switch (in.nextLine()) {
                case "1":
                    EditFirstName();
                    break;
                case "2":
                    EditLastName();
                    break;
                case "3":
                    EditAge();
                    break;
                case "4":
                    EditWeight();
                    break;
                case "5":
                    EditLength();
                    break;
                case "6":
                    EditFirstName();
                    EditLastName();
                    EditAge();
                    EditWeight();
                    EditLength();
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    exit2 = false;
            }
        }
        while (!exit2);
        System.out.println("Uw wijzigingen zijn succesvol opgeslagen!");
    }




    private void EditFirstName() {
        // Nieuwe voornaam
        System.out.print("Voer voornaam in en druk op \"Enter\": ");
        while (!in.hasNext("[a-zA-Z]+")) {
            System.out.println("Alleen letters gebruiken!");
            in.nextLine();
            System.out.print("Voer voornaam in en druk op \"Enter\": ");
        }
        String firstname = in.nextLine();
        patient.setFirstname(firstname);
    }

    public void EditLastName() {
        // Nieuwe achternaam
        System.out.print("Voer achternaam in en druk op \"Enter\": ");
        while (!in.hasNext("[a-zA-Z]+")) {
            System.out.println("Alleen letters gebruiken!");
            in.nextLine();
            System.out.print("Voer achternaam in en druk op \"Enter\": ");
        }

        String lastname = in.nextLine();
        patient.setLastname(lastname);
    }

    public void EditAge() {
        // Nieuwe leeftijd
        System.out.print("Voer de leeftijd in en druk op  \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige leeftijd.");
            in.nextLine();
            System.out.print("Voer uw leeftijd in en druk op  \"Enter\": ");
        }
        int age = in.nextInt();
        patient.setAge(age);
    }

    public void EditWeight() {
        // Nieuw gewicht
        System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig gewicht.");
            in.nextLine();
            System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        }
        int weight = in.nextInt();
        patient.setWeight(weight);
    }

    public void EditLength() {
        // nieuwe lengte
        System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige lengte.");
            in.nextLine();
            System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        }
        double meters = in.nextInt();
        patient.setlength(meters / 100);
    }



    public void PrintDetails() {


        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam: " + patient.getFirstname().substring(0, 1).toUpperCase()
                + patient.getFirstname().substring(1).toLowerCase()
                + " "
                + patient.getLastname().substring(0, 1).toUpperCase() + patient.getLastname().substring(1).toLowerCase());
        System.out.println("Leeftijd: " + patient.getAge() + " jaar");
        System.out.println("Lengte: " + patient.getLength() + "m");
        System.out.println("Gewicht: " + patient.getWeight() + "kg");
        System.out.println("Uw BMI is: " + String.format("%.1f", patient.getBmi()) + "\n");
    }
}

