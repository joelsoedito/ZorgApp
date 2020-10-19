package adsd.app.zorgapp;

import java.time.LocalDate;
import java.util.HashMap;

public class ProfileList {

    // Attributen
    private HashMap<Integer, Profile> profilemap = new HashMap<>();

    public ProfileList () {

        // create profiles
        Profile patient0 = new Profile("Joel", "Soedito", 23, 75.6, 1.93, 1111);
        Profile patient1 = new Profile("Ruud", "Koekoek", 56, 80.3, 1.64, 2222);
        Profile patient2 = new Profile("Yannick", "van dan Bos", 38, 78, 1.48, 3333);
        Profile patient3 = new Profile("Roy", "van Ballengooi", 67, 70, 1.70, 4444);


        // put profiles in a HashMap
        profilemap.put(patient0.getProfileID(), patient0);
        profilemap.put(patient1.getProfileID(), patient1);
        profilemap.put(patient2.getProfileID(), patient2);
        profilemap.put(patient3.getProfileID(), patient3);

        // appoint medicine to profile
        patient0.addMedicine(10);
        patient0.addMedicine(20);
        patient1.addMedicine(10);
        patient2.addMedicine(30);
        patient2.addMedicine(40);
        patient3.addMedicine(50);

        // create and put weight measurement on personal list
        patient0.addWeightMeasurment(new Measurement(LocalDate.of(2020, 1, 1), "14:30" , 78.42));
        patient0.addWeightMeasurment(new Measurement(LocalDate.of(2020, 2, 2), "15:15" , 87.62));

        patient1.addWeightMeasurment(new Measurement(LocalDate.of(2020, 1, 15), "09:00", 50));
        patient1.addWeightMeasurment(new Measurement(LocalDate.of(2020, 3, 15), "10:30", 100));
        patient1.addWeightMeasurment(new Measurement(LocalDate.of(2020, 4, 15), "14:00", 150));
    }

    public HashMap<Integer, Profile> getProfilemap() {
        return profilemap;
    }
}


