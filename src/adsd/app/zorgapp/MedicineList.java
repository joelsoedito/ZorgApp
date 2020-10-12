package adsd.app.zorgapp;


import java.util.ArrayList;
import java.util.HashMap;

public class MedicineList {

    // Atributen
    private HashMap<Integer, Medicine> MedicineList = new HashMap<>();

    public MedicineList() {

        Medicine med1 = new Medicine("Ibuprofen", "Pijnstiller", "Sterk", "max. 40 per dag", 10);
        Medicine med2 = new Medicine("Paracetamol", "Pijnstiller", "licht", "Max. 3 per jaar", 20);

        MedicineList.put(med1.getMedicineID(), med1);
        MedicineList.put(med2.getMedicineID(), med2);


    }

    public HashMap<Integer, Medicine> getMedicineList() {
        return MedicineList;
    }


}
