package adsd.app.zorgapp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ZorgApp {


    private Scanner in = new Scanner(System.in);
    private int patientID;

    private ProfileList profileMap;
    private MedicineList medicineList;
    private Measurement measurement;


    public void Login() {

        boolean exit = false;
        profileMap = new ProfileList();
        medicineList = new MedicineList();


        // Login Menu
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
        System.out.println("\nMaak uw keuze: \n[1] Gegevens weergeven \n[2] Gegevens Wijzigen \n[3] Medicijnen bekijken \n[4] Medicijnen toevoegen \n[5] Laat gewicht zien a mattie \n[6] Andere Patient \n[7] Afsluiten");
        boolean exit3 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    PrintDetails();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
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
                    ShowWeightMeasurments();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
                case "6":
                    ChoosePatientID();
                    ZorgverlenerMenu();
                    exit3 = true;
                    break;
                case "7":
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
        profileMap.getProfileMap().get(patientID).setFirstname(firstname);
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
        profileMap.getProfileMap().get(patientID).setLastname(lastname);
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
        profileMap.getProfileMap().get(patientID).setAge(age);
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
        profileMap.getProfileMap().get(patientID).setWeight(weight);
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
        profileMap.getProfileMap().get(patientID).setlength(centimeters / 100);

    }


    // Add new medication to patient
    public void AddMedicationMenu() {
        System.out.println("Welk medicijn wilt u toevoegen?");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig medicijn nummer.");
            in.nextLine();
            System.out.println("Voer een medicijnnummer in dat uw wilt toevoegen:");
        }
        int newmed = in.nextInt();
        profileMap.getProfileMap().get(patientID).addMedicine(newmed);
    }

    public void ShowWeightMeasurments(){
        ArrayList<Measurement> PatientWeightList = profileMap.getProfileMap().get(patientID).getPatientWeightList(measurement);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Gewicht meetpunten:");

        for (int i = 0; i < PatientWeightList.size(); i++) {
            System.out.println("Op " + dateTimeFormatter.format(PatientWeightList.get(i).getDate()) + " was het gewicht: " + PatientWeightList.get(i).getMeasureWeight() + "kg");
        }
    }

    // Method to print patient Details
    public void PrintDetails() {
        HashMap<Integer, Profile> profilemap = profileMap.getProfileMap();

        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam:           " + profilemap.get(patientID).getFirstname().substring(0, 1).toUpperCase()
                + profilemap.get(patientID).getFirstname().substring(1).toLowerCase()
                + " "
                + profilemap.get(patientID).getLastname().substring(0, 1).toUpperCase() + profileMap.getProfileMap().get(patientID).getLastname().substring(1).toLowerCase());
        System.out.println("Leeftijd:       " + profilemap.get(patientID).getAge() + " jaar");
        System.out.println("Lengte:         " + profilemap.get(patientID).getLength() + "m");
        System.out.println("Gewicht:        " + profilemap.get(patientID).getWeight() + "kg");
        System.out.println("Uw BMI is:      " + String.format("%.1f", profilemap.get(patientID).getBmi()) + "\n");
    }

    // Method to print Medication
    public void PrintMedication() {
        for (int i : profileMap.getProfileMap().get(patientID).PatientMedicines) {
            System.out.println("\nMedicatie gegevens: ");
            System.out.println("Medcijnnaam:    " + medicineList.getMedicineList().get(i).getMedicineName());
            System.out.println("Beschrijving:   " + medicineList.getMedicineList().get(i).getDescription());
            System.out.println("Type:           " + medicineList.getMedicineList().get(i).getType());
            System.out.println("Dose:           " + medicineList.getMedicineList().get(i).getDose());
        }

    }




}

