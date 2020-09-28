package adsd.app.zorgapp;


import java.util.ArrayList;
import java.util.Scanner;



public class ZorgApp {

    // scanner zodat ie in alles gebruikt kan worden
    Scanner in = new Scanner(System.in);

    // attributen

    private Profil




    /*
    private int patientID;
    // private int user;

    // create ArrayLists
    private ArrayList<Profile> ProfileList = new ArrayList<>();
    private ArrayList<Medicine> MedicineList = new ArrayList<>();


     */
    public void Login() {
        boolean exit = false;


        //todo Zorgen dat dit in ProfileList Class en MedicineList Class staat
        /*
        patient0 = new Profile("Joel", "Soedito", 23, 75.6, 1.93);
        patient1 = new Profile("Ruud", "Koekoek", 56, 80.3, 1.64);


        ProfileList.add(patient0);
        ProfileList.add(patient1);

        patient0.addMedicijn(0);
        patient0.addMedicijn(1);

        patient1.addMedicijn(1);

        med1 = new Medicine("Ibuprofen", "Pijnstiller", "Sterk", "max. 40 per dag");
        med2 = new Medicine("Paracetamol", "Pijnstiller", "licht", "Max. 3 per jaar");

        MedicineList.add(med1);
        MedicineList.add(med2);

        */


    // Login Menu

        System.out.println("Bent u een Zorgverlener [1] of een Patiënt [2]?");
        do {
            switch (in.nextLine()) {
                case "1":
                    //todo zorgen dat alleen cijfers ingevoerd kunnen worden
                    System.out.println("\nVoer het patient ID in:");
                    patientID = in.nextInt();
                    ZorverlenerMenu();
                    exit = true;
                    break;

                case "2":
                    System.out.println("\nVoer het patient ID in:");
                    patientID = in.nextInt();
                    PatientenMenu();
                    exit = true;
                    break;

                default:
                    System.out.println("Voer Zorgverlener [1] of Patiënt [2] in.");
            }
        }
        while (!exit);



    }

    // Zorgverlener Menu

    private void ZorverlenerMenu() {


        //gegevens weergeven
        PrintDetails();

        System.out.println("\nMaak uw keuze: \n[1] Gegevens Wijzigen \n[2] Medicijnen bekijken \n[3] Medicijnen wijzigen");
        boolean exit3 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    EditDetailsMenu();
                    ZorverlenerMenu();
                    exit3 = true;
                    break;
                case "2":
                    PrintMedication();
                    ZorverlenerMenu();
                    exit3 = true;
                    break;

                case "3":
                    EditMedicationMenu();
                    break;

                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    break;
            }
        } while (!exit3);
    }

    // Patienten Menu
    private void PatientenMenu(){

        // Gegevens weergeven
        PrintDetails();

        System.out.println("\nMaak uw keuze: \n[1] Gegevens Wijzigen \n[2] Medicijnen bekijken");
        boolean exit4 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    EditDetailsMenu();
                    PatientenMenu();
                    exit4 = true;
                    break;
                case "2":
                    PrintMedication();
                    PatientenMenu();
                    exit4 = true;
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    break;
            }
        } while (!exit4);

    }



    private void EditDetailsMenu() {
        //todo onderscheid maken tussen zorgverlener en patient
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
        ProfileList.get(patientID).setFirstname(firstname);
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
        ProfileList.get(patientID).setLastname(lastname);
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
        ProfileList.get(patientID).setAge(age);
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
        ProfileList.get(patientID).setWeight(weight);
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
        ProfileList.get(patientID).setlength(meters/100);

    }

    public void EditMedicationMenu() {

        System.out.println(" Welk medicijn wilt u wijzigen:");



        //todo Menu maken waar je kan kiezen welk medicijn je wilt wijzigen en of je er 1 wilt toevoegen
    }


    public void PrintDetails() {


        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam:           " + ProfileList.get(patientID).getFirstname().substring(0, 1).toUpperCase()
                + ProfileList.get(patientID).getFirstname().substring(1).toLowerCase()
                + " "
                + ProfileList.get(patientID).getLastname().substring(0, 1).toUpperCase() + ProfileList.get(patientID).getLastname().substring(1).toLowerCase());
        System.out.println("Leeftijd:       " + ProfileList.get(patientID).getAge() + " jaar");
        System.out.println("Lengte:         " + ProfileList.get(patientID).getLength() + "m");
        System.out.println("Gewicht:        " + ProfileList.get(patientID).getWeight() + "kg");
        System.out.println("Uw BMI is:      " + String.format("%.1f", ProfileList.get(patientID).getBmi()) + "\n");
    }

    public void PrintMedication() {

        //todo use for loop to print arraylists

        for (int i : ProfileList.get(patientID).PatientMedicijnen) {


            System.out.println("\nMedicatie gegevens: ");
            System.out.println("Medcijnnaam:    " + MedicineList.get(i).getMedicineName());
            System.out.println("Beschrijving:   " + MedicineList.get(i).getDescription());
            System.out.println("Type:           " + MedicineList.get(i).getType());
            System.out.println("Dose:           " + MedicineList.get(i).getDose());
        }
    }

}

