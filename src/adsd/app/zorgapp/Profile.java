package adsd.app.zorgapp;

import java.util.ArrayList;


public class Profile {

    // Attributes
    private String firstname;
    private String lastname;
    private int age;
    private double weight;
    private double length;
    private int profileID;

    public ArrayList<Integer> patientmedicines = new ArrayList<>();
    public ArrayList<Measurement> patientweightlist = new ArrayList<>();
    private MedicineList medicineList;

    // Constructor for Profile
    public Profile(String firstname, String lastname, int age, double weight, double length, int profileID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
        this.length = length;
        this.profileID = profileID;
    }

    // Add, remove and index of Measurments list.
    public void addWeightMeasurment(Measurement newEntry)  {
        patientweightlist.add(newEntry);
    }
    public void removeWeightMeasurment(int i){
        patientweightlist.remove(i);
    }

    public ArrayList<Measurement> getPatientWeightList(Measurement i) {
        return patientweightlist;
    }


    // Add, Remove and Index Methods for Medicines on MedicineList
    //todo Create index method to show how many Medicines are on the List
    public void addMedicine(int i) {

        patientmedicines.add(i);
    }

    public void removeMedicine(int i) {
        patientmedicines.remove(i);
    }

    //todo make patientMedicines private
    public ArrayList<Integer> getPatientmedicines() {
        return patientmedicines;
    }


    // Getters and Setters for Medicne
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setlength(double length) {
        this.length = length;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public int getAge() {
        return this.age;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getLength() {
        return this.length;
    }

    public double getBmi() {
        return (weight / (length * length));
    }

    public int getProfileID() {
        return this.profileID;
    }

}



