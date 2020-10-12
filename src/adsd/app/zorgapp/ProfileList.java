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

        // put profiles in a HashMap
        profilemap.put(patient0.getProfileID(), patient0);
        profilemap.put(patient1.getProfileID(), patient1);

        // appoint medicine to profile
        patient0.addMedicine(10);
        patient0.addMedicine(20);
        patient1.addMedicine(10);

        // create and put weight measurement on personal list
        patient0.addWeightMeasurment(new Measurement(LocalDate.of(2020, 1, 1), 78.42));
        patient0.addWeightMeasurment(new Measurement(LocalDate.of(2020, 2, 2), 80.62));
    }

    public HashMap<Integer, Profile> getProfileMap() {
        return profilemap;
    }
}


