package adsd.app.zorgapp;

public class Medicine {

    //Attributes for Medicine
    private String medicineName;
    private String description;
    private String type;
    private String dose;
    private int medicineID;

    //Constructor for Medicine
    public Medicine(String medicineName, String description, String type, String dose, int medicineID) {
        this.medicineName = medicineName;
        this.description = description;
        this.type = type;
        this.dose = dose;
        this.medicineID = medicineID;
    }

    //Getters and Setters for Medicine
    public void setMedicineName(String medicineName ) {
        this.medicineName = medicineName;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setDose(String dose){
        this.dose = dose;
    }
    public String getMedicineName(){
        return this.medicineName;
    }
    public String getDescription(){
        return this.description;
    }
    public String getType(){
        return this.type;
    }
    public String getDose(){
        return this.dose;
    }
    public int getMedicineID(){
        return this.medicineID;
    }

}
