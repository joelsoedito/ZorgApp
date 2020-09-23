package adsd.app.zorgapp;

public class Profile {

    // creërt de variabelen van profiel
    private String firstname;
    private String lastname;
    private int age;
    private double weight;
    private double length;


    // Constructor

    public Profile(String firstname, String lastname, int age, double weight,double length) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.weight = weight;
        this.length = length;

    }

    // Dit is om de variabelen te schrijven en op te halen
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setLastname (String lastname) {
        this.lastname = lastname;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setlength(double length) {
        this.length = length;
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
    public double getWeight(){
        return this.weight;
    }
    public double getLength(){
        return this.length;
    }
    public double getBmi(){
        return (weight / (length * length));
    }

}

