package adsd.app.zorgapp;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class ZorgApp {


    private Scanner in = new Scanner(System.in);
    private int patientID;
    private int totalweightmeasurements;

    private ProfileList profileMap;
    private MedicineList medicineList;
    private Measurement measurement;




    public void login() {

        boolean exit = false;
        profileMap = new ProfileList();
        medicineList = new MedicineList();


        // Login Menu
        System.out.println("Bent u een Zorgverlener [1] of een Patiënt [2]?");
        do {
            switch (in.nextLine()) {
                case "1":
                    choosePatientID();
                    zorgverlenerMenu();
                    exit = true;
                    break;

                case "2":
                    choosePatientID();
                    patientenMenu();
                    exit = true;
                    break;

                default:
                    System.out.println("Voer Zorgverlener [1] of Patiënt [2] in.");
            }
        }
        while (!exit);
    }

    private void choosePatientID() {
        // Choose patient
        System.out.println("\nVoer het patient ID in:");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig ID nummer!");
            in.nextLine();
            System.out.print("Voer het patient ID in en druk op  \"Enter\": ");
        }
        patientID = in.nextInt();
    }

    //todo method to search on name
//   private void choosePatientName(){
//        HashMap<Integer, Profile> profilemap = profileMap.getProfilemap();
//        String input;
//
//        System.out.println("\nVoer de patient naam in:");
//        if(input.equals()
//
//        input = in.nextLine();
//
//    }

    // Zorgverlener Menu
    private void zorgverlenerMenu() {
        HashMap<Integer, Profile> profilemap = profileMap.getProfilemap();

        System.out.println("\nGekozen profiel: " + profilemap.get(patientID).getFirstname().substring(0, 1).toUpperCase()
                + profilemap.get(patientID).getFirstname().substring(1).toLowerCase()
                + " "
                + profilemap.get(patientID).getLastname().substring(0, 1).toUpperCase() + profileMap.getProfilemap().get(patientID).getLastname().substring(1).toLowerCase());

        System.out.println("Maak uw keuze: \n[1] Gegevens weergeven \n[2] Gegevens Wijzigen \n[3] Medicijnen bekijken \n[4] Medicijnen toevoegen \n[5] Medicijn bewerken" +
                "\n[6] Gewicht meetpunten \n[7] Overzicht \n[8] Andere Patient \n[9] Afsluiten");

        boolean exit3 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    printDetails();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "2":
                    editDetailsMenuZ();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "3":
                    printMedication();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "4":
                    addMedicationMenu();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "5":
                    editPatientMedication();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "6":
                    showWeightMeasurments();
                    showGraph();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "7":
                    printOverview();
                    zorgverlenerMenu();
                case "8":
                    choosePatientID();
                    zorgverlenerMenu();
                    exit3 = true;
                    break;
                case "9":
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
    private void patientenMenu() {

        // Shows patient details first
        printDetails();

        System.out.println("\nMaak uw keuze: \n[1] Gegevens Wijzigen \n[2] Medicijnen bekijken \n[3] Afsluiten");
        boolean exit4 = false;
        do {
            switch (in.nextLine()) {
                case "1":
                    editDetailsMenuP();
                    patientenMenu();
                    exit4 = true;
                    break;
                case "2":
                    printMedication();
                    patientenMenu();
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

    private void editDetailsMenuZ() {
        System.out.println("\nWelke gegevens wilt u wijzigen? \n[1] Voornaam \n[2] Achternaam \n[3] Leeftijd \n[4] Gewicht \n[5] Lengte \n[6] Alle gegevens");

        boolean exit2 = true;
        String userinput = in.nextLine();
        do {
            switch (userinput) {
                case "1":
                    in.nextLine();
                    editFirstName();
                    break;
                case "2":
                    in.nextLine();
                    editLastName();
                    break;
                case "3":
                    in.nextLine();
                    editAge();
                    break;
                case "4":
                    in.nextLine();
                    editWeight();
                    break;
                case "5":
                    in.nextLine();
                    editLength();
                    break;
                case "6":
                    in.nextLine();
                    editFirstName();
                    editLastName();
                    editAge();
                    editWeight();
                    editLength();
                    break;
                default:
                    System.out.println("Maak een keuze door een cijfer in te toetsen");
                    exit2 = false;
            }
        }
        while (!exit2);
        System.out.println("Uw wijzigingen zijn succesvol opgeslagen!");
    }

    private void editDetailsMenuP() {
        System.out.println("\nWelke gegevens wilt u wijzigen? \n[1] Voornaam \n[2] Achternaam \n[3] Leeftijd  \n[4] Alle gegevens");

        boolean exit2 = true;
        String userinput = in.nextLine();
        do {
            switch (userinput) {
                case "1":
                    in.nextLine();
                    editFirstName();
                    break;
                case "2":
                    in.nextLine();
                    editLastName();
                    break;
                case "3":
                    in.nextLine();
                    editAge();
                    break;
                case "4":
                    in.nextLine();
                    editFirstName();
                    editLastName();
                    editAge();
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
    private void editFirstName() {
        System.out.print("Voer voornaam in en druk op \"Enter\": ");
        while (!in.hasNext("[a-zA-Z]+")) {
            System.out.println("Alleen letters gebruiken!");
            in.nextLine();
            System.out.print("Voer voornaam in en druk op \"Enter\": ");
        }
        String firstname = in.nextLine();
        profileMap.getProfilemap().get(patientID).setFirstname(firstname);
    }

    // Edit Lastname method
    private void editLastName() {
        System.out.print("Voer achternaam in en druk op \"Enter\": ");
        while (!in.hasNext("[a-zA-Z]+")) {
            System.out.println("Alleen letters gebruiken!");
            in.nextLine();
            System.out.print("Voer achternaam in en druk op \"Enter\": ");
        }

        String lastname = in.nextLine();
        profileMap.getProfilemap().get(patientID).setLastname(lastname);
    }

    // Edit age method
    private void editAge() {
        System.out.print("Voer de leeftijd in en druk op  \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige leeftijd.");
            in.nextLine();
            System.out.print("Voer uw leeftijd in en druk op  \"Enter\": ");
        }
        int age = in.nextInt();
        profileMap.getProfilemap().get(patientID).setAge(age);
    }

    // Edit Weight Method
    private void editWeight() {
        System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig gewicht.");
            in.nextLine();
            System.out.print("Voer uw gewicht in kg in en druk op \"Enter\": ");
        }
        int weight = in.nextInt();
        profileMap.getProfilemap().get(patientID).setWeight(weight);
    }

    // Edit Length Method
    private void editLength() {
        System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldige lengte.");
            in.nextLine();
            System.out.print("Voer uw lengte in cm in en druk op \"Enter\": ");
        }
        double centimeters = in.nextInt();
        profileMap.getProfilemap().get(patientID).setlength(centimeters / 100);

    }


    // Add new medication to patient
    private void addMedicationMenu() {
        System.out.println("Welk medicijn wilt u toevoegen?");
        while (!in.hasNextInt()) {
            System.out.println("Dit is geen geldig medicijn nummer.");
            in.nextLine();
            System.out.println("Voer een medicijnnummer in dat uw wilt toevoegen:");
        }
        int newmed = in.nextInt();
        profileMap.getProfilemap().get(patientID).addMedicine(newmed);
    }

    //todo make it so it actually edits the personal medicine.

    public void editPatientMedication() {

        ArrayList<Integer> patientmedicines = profileMap.getProfilemap().get(patientID).patientmedicines;

        printMedication();
        System.out.println("Welk medicijn wilt u aanpassen?");
        int mednum = in.nextInt();

        System.out.println("Schrijf de dosering");
        in.nextLine();
        String input = in.nextLine();
        medicineList.getMedicineList().get(mednum).setDose(input);
    }


    private void showWeightMeasurments(){
        ArrayList<Measurement> PatientWeightList = profileMap.getProfilemap().get(patientID).getPatientWeightList(measurement);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Gewicht meetpunten:");

        for (int i = 0; i < PatientWeightList.size(); i++) {
            System.out.println("Op " + dateTimeFormatter.format(PatientWeightList.get(i).getDate()) + "om " + PatientWeightList.get(i).getTime() + " was het gewicht: " + PatientWeightList.get(i).getMeasureWeight() + "kg");
        }
    }

    // Method to print patient Details
    private void printDetails() {
        HashMap<Integer, Profile> profilemap = profileMap.getProfilemap();

        System.out.println("\nGegevens van de patiënt:");
        System.out.println("Naam:           " + profilemap.get(patientID).getFirstname().substring(0, 1).toUpperCase()
                + profilemap.get(patientID).getFirstname().substring(1).toLowerCase()
                + " "
                + profilemap.get(patientID).getLastname().substring(0, 1).toUpperCase() + profileMap.getProfilemap().get(patientID).getLastname().substring(1).toLowerCase());
        System.out.println("Leeftijd:       " + profilemap.get(patientID).getAge() + " jaar");
        System.out.println("Lengte:         " + profilemap.get(patientID).getLength() + "m");
        System.out.println("Gewicht:        " + profilemap.get(patientID).getWeight() + "kg");
        System.out.println("Uw BMI is:      " + String.format("%.1f", profilemap.get(patientID).getBmi()) + "\n");
    }

    // Method to print Medication
    private void printMedication() {

        for (int i : profileMap.getProfilemap().get(patientID).patientmedicines) {
            System.out.println("\nMedicatie nummer: " + medicineList.getMedicineList().get(i).getMedicineID());
            System.out.println("Medcijnnaam:    " + medicineList.getMedicineList().get(i).getMedicineName());
            System.out.println("Beschrijving:   " + medicineList.getMedicineList().get(i).getDescription());
            System.out.println("Type:           " + medicineList.getMedicineList().get(i).getType());
            System.out.println("Dose:           " + medicineList.getMedicineList().get(i).getDose());

            ;
        }

    }

    //todo make function to print all details and overview
    private void printOverview(){
        HashMap<Integer, Profile> profilemap = profileMap.getProfilemap();


        checkMeasurementTotal();

        System.out.println("Algemene informatie: ");
        System.out.println("Totaal aantal patienten:            " + profilemap.size());
        System.out.println("Totaal aantal gewogen patienten:    " + totalweightmeasurements + "\n");

        for (int i: profilemap.keySet()){

            System.out.println("Patient:                            " + profilemap.get(i).getFirstname() + " " + profilemap.get(i).getLastname());
            System.out.println("Aantal voorgeschreven medicatie:    " + profilemap.get(i).getPatientmedicines().size());
            System.out.println("Aantal opgenomen weegpunten:        " + profilemap.get(i).getPatientWeightList(measurement).size() + "\n");
        }
    }


    private void checkMeasurementTotal(){
        HashMap<Integer, Profile> profilemap = profileMap.getProfilemap();

        for (int i: profilemap.keySet()){
            if (profilemap.get(i).patientweightlist.size() > 0){
                totalweightmeasurements++;
            }

        }
    }
    //todo DATE TIME FORMATTER
    public void showGraph(){
       ArrayList<Measurement> patientweightlist = profileMap.getProfilemap().get(patientID).getPatientWeightList(measurement);
       DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

       System.out.println("Grafiek: ");

       for(Measurement currentMeasurement: patientweightlist){

                System.out.print("\n" + dateTimeFormatter.format(currentMeasurement.getDate()) + " " +currentMeasurement.getTime() + "    ");

                double weightIndicator = currentMeasurement.getMeasureWeight() / 3;

                for(int i=0; i < weightIndicator; i++){
                    System.out.print("■");
                }
            }
        System.out.println("\nGewicht in kg:      0                50             100              150");
    }

}

