package adsd.app.zorgapp;

public class Medicine {

    //variablen voor medicijn
    private String medicineName;
    private String description;
    private String type;
    private String dose;


    //constructor voor medicijn
    public Medicine(String medicineName, String description, String type, String dose) {
        this.medicineName = medicineName;
        this.description = description;
        this.type = type;
        this.dose = dose;
    }




    //getters en setters voor medicijn
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
}
