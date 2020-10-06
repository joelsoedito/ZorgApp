package adsd.app.zorgapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ZorgApp {

    // import scanner for use throughout the program
    private Scanner in = new Scanner(System.in);
    private int patientID;


    // create ArrayLists
    private HashMap<Integer, Profile> ProfileMap = new HashMap<>();
    private HashMap<Integer, Medicine> MedicineList = new HashMap<>();


    public void Login() {
        boolean exit = false;


        //todo create ProfileList Class and MedicineList Class and import to ZorgApp

        // Attributen
        Profile patient0 = new Profile("Joel", "Soedito", 23, 75.6, 1.93, 1111);
        Profile patient1 = new Profile("Ruud", "Koekoek", 56, 80.3, 1.64, 2222);


        ProfileMap.put(patient0.getProfileID(), patient0);
        ProfileMap.put(patient1.getProfileID(), patient1);

        patient0.addMedicine(10);
        patient0.addMedicine(20);
        patient1.addMedicine(20);

        Medicine med1 = new Medicine("Ibuprofen", "Pijnstiller", "Sterk", "max. 40 per dag", 10);
        Medicine med2 = new Medicine("Paracetamol", "Pijnstiller", "licht", "Max. 3 per jaar", 20);

        MedicineList.put(med1.getMedicineID(), med1);
        MedicineList.put(med2.getMedicineID(), med2);




        // Login Menu
        //todo move placement of PatientID in program.
        System.out.println("Bent u een Zorgverlener [1] of een Patiënt [2]?");
        do {
            switch (in.nextLine()) {
                case "1":
                    ChoosePatientID();
                    ZorgverlenerMenu();
                    exit = true;
                    break;

                case "2":
                    ChoosePatientID();
                    PatientenMenu();
                    exit = true;
                    break;

                default:
                    System.out.println("Voer Zorgverlener [1] of Patiënt [2] in.");
            }
        }
        while (!exit);
    }

    private void ChoosePatientID() {
        // Choose patient
        System.out.println("\nVoer het patient ID in:");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig ID nummer!");
            in.nextLine();
            System.out.print("Voer het patient ID in en druk op  \"Enter\": ");
        }
        patientID = in.nextInt();
    }


    // Zorgverlener Menu
    private void ZorgverlenerMenu() {
        //todo if statement die rekening houd met patient of vzorgverelener


        System.out.println("\nMaak uw keuze: \n[1] Gegevens weergeven \n[2] Gegevens Wijzigen \n[3] Medicijnen bekijken \n[4] Medicijnen toevoegen \n[5] Andere Patient \n[6] Afsluiten");
        boolean exit3 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    PrintDetails();
                    ZorgverlenerMenu();
                case "2":
                    EditDetailsMenuZ();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
                case "3":
                    PrintMedication();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
                case "4":
                    AddMedicationMenu();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
                case "5":
                    ChoosePatientID();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
                case "6":
                    System.out.println("Bedankt en tot ziens!");
                    exit3 = true;
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    break;
            }
        } while (!exit3);
    }

    // Patienten Menu
    private void PatientenMenu() {

        // Shows patient details first
        PrintDetails();

        System.out.println("\nMaak uw keuze: \n[1] Gegevens Wijzigen \n[2] Medicijnen bekijken \n[3] Afsluiten");
        boolean exit4 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    EditDetailsMenuP();
                    PatientenMenu();
                    exit4 = true;
                    break;
                case "2":
                    PrintMedication();
                    PatientenMenu();
                    exit4 = true;
                    break;
                case "3":
                    System.out.println("Bedankt en tot ziens!");
                    exit4 = true;
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    break;
            }
        } while (!exit4);
    }


    // Edit patient details
    // todo create difference between Zorgverlener and Patient, give patient less options to edit

    private void EditDetailsMenuZ() {
        System.out.println("\nWelke gegevens wilt u wijzigen? \n[1] Voornaam \n[2] Achternaam \n[3] Leeftijd \n[4] Gewicht \n[5] Lengte \n[6] Alle gegevens");

        boolean exit2 = true;
        String userinput = in.nextLine();
        do {
            switch (userinput) {
                case "1":
                    in.nextLine();
                    EditFirstName();
                    break;
                case "2":
                    in.nextLine();
                    EditLastName();
                    break;
                case "3":
                    in.nextLine();
                    EditAge();
                    break;
                case "4":
                    in.nextLine();
                    EditWeight();
                    break;
                case "5":
                    in.nextLine();
                    EditLength();
                    break;
                case "6":
                    in.nextLine();
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

    private void EditDetailsMenuP() {
        System.out.println("\nWelke gegevens wilt u wijzigen? \n[1] Voornaam \n[2] Achternaam \n[3] Leeftijd  \n[4] Alle gegevens");

        boolean exit2 = true;
        String userinput = in.nextLine();
        do {
            switch (userinput) {
                case "1":
                    in.nextLine();
                    EditFirstName();
                    break;
                case "2":
                    in.nextLine();
                    EditLastName();
                    break;
                case "3":
                    in.nextLine();
                    EditAge();
                    break;
                case "4":
                    in.nextLine();
                    EditFirstName();
                    EditLastName();
                    EditAge();
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    exit2 = false;
            }
        }
        while (!exit2);
        System.out.println("Uw wijzigingen zijn succesvol opgeslagen!");
    }

    // Edit Firstname method

    private void EditFirstName() {
        System.out.print("Voer voornaam in en druk op \"Enter\": ");
        while (!in.hasNext("[a-zA-Z]+")) {
            System.out.println("Alleen letters gebruiken!");
            in.nextLine();
            System.out.print("Voer voornaam in en druk op \"Enter\": ");
        }
        String firstname = in.nextLine();
        ProfileMap.get(patientID).setFirstname(firstname);
    }

    // Edit Lastname method
    public void EditLastName() {
        System.out.print("Voer achternaam in en druk op \"Enter\": ");
        while (!in.hasNext("[a-zA-Z]+")) {
            System.out.println("Alleen letters gebruiken!");
            in.nextLine();
            System.out.print("Voer achternaam in en druk op \"Enter\": ");
        }

        String lastname = in.nextLine();
        ProfileMap.get(patientID).setLastname(lastname);
    }

    // Edit age method
    public void EditAge() {
        System.out.print("Voer de leeftijd in en druk op  \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige leeftijd.");
            in.nextLine();
            System.out.print("Voer uw leeftijd in en druk op  \"Enter\": ");
        }
        int age = in.nextInt();
        ProfileMap.get(patientID).setAge(age);
    }

    // Edit Weight Method
    public void EditWeight() {
        System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig gewicht.");
            in.nextLine();
            System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        }
        int weight = in.nextInt();
        ProfileMap.get(patientID).setWeight(weight);
    }

    // Edit Length Method
    public void EditLength() {
        System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige lengte.");
            in.nextLine();
            System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        }
        double centimeters = in.nextInt();
        ProfileMap.get(patientID).setlength(centimeters / 100);

    }

    // Edit Medication menu
    //todo create methods to show full MedicineList
    //todo create method to edit item from MedicineList

    // Add new medication to patient
    public void AddMedicationMenu() {
        System.out.println("Welk medicijn wilt u toevoegen?");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig medicijn nummer.");
            in.nextLine();
            System.out.println("Voer een medicijnnummer in dat uw wilt toevoegen:");
        }
        int newmed = in.nextInt();
        ProfileMap.get(patientID).addMedicine(newmed);
    }

    // Method to print patient Details
    public void PrintDetails() {
        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam:           " + ProfileMap.get(patientID).getFirstname().substring(0, 1).toUpperCase()
                + ProfileMap.get(patientID).getFirstname().substring(1).toLowerCase()
                + " "
                + ProfileMap.get(patientID).getLastname().substring(0, 1).toUpperCase() + ProfileMap.get(patientID).getLastname().substring(1).toLowerCase());
        System.out.println("Leeftijd:       " + ProfileMap.get(patientID).getAge() + " jaar");
        System.out.println("Lengte:         " + ProfileMap.get(patientID).getLength() + "m");
        System.out.println("Gewicht:        " + ProfileMap.get(patientID).getWeight() + "kg");
        System.out.println("Uw BMI is:      " + String.format("%.1f", ProfileMap.get(patientID).getBmi()) + "\n");
    }

    // Method to print Medication
    public void PrintMedication() {
        for (int i : ProfileMap.get(patientID).PatientMedicines) {
            System.out.println("\nMedicatie gegevens: ");
            System.out.println("Medcijnnaam:    " + MedicineList.get(i).getMedicineName());
            System.out.println("Beschrijving:   " + MedicineList.get(i).getMedicineName());
            System.out.println("Type:           " + MedicineList.get(i).getMedicineName());
            System.out.println("Dose:           " + MedicineList.get(i).getMedicineName());
        }

    }

}

