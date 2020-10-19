package adsd.app.zorgapp;

import java.util.HashMap;

public class MedicineList {

    // Atributen
    private HashMap<Integer, Medicine> MedicineList = new HashMap<>();

    public MedicineList() {

        Medicine med1 = new Medicine("Ibuprofen", "Pijnstiller", "Sterk", "max. 40 per dag", 10);
        Medicine med2 = new Medicine("Paracetamol", "Pijnstiller", "licht", "Max. 3 per jaar", 20);
        Medicine med3 = new Medicine("Ibuprofen", "Pijnstiller", "Sterk", "max. 40 per dag", 30);
        Medicine med4 = new Medicine("Paracetamol", "Pijnstiller", "licht", "Max. 3 per jaar", 40);
        Medicine med5 = new Medicine("Ibuprofen", "Pijnstiller", "Sterk", "max. 40 per dag", 50);
        Medicine med6 = new Medicine("Paracetamol", "Pijnstiller", "licht", "Max. 3 per jaar", 60);

        MedicineList.put(med1.getMedicineID(), med1);
        MedicineList.put(med2.getMedicineID(), med2);
        MedicineList.put(med3.getMedicineID(), med3);
        MedicineList.put(med4.getMedicineID(), med4);
        MedicineList.put(med5.getMedicineID(), med5);
        MedicineList.put(med6.getMedicineID(), med6);

    }

    public HashMap<Integer, Medicine> getMedicineList() {
        return MedicineList;
    }


}
