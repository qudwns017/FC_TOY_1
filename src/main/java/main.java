package src.main.java;

import src.main.java.controller.TripController;
import src.main.java.dto.TripSub;
import src.main.java.model.Trip;

import java.util.ArrayList;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        Trip trip = new Trip("trip_name", new Date(), new Date(), new ArrayList<>());

        TripController tripController = new TripController();
        tripController.addTrip(trip);

        System.out.println(TripController.getTrip(1).toString());
        ArrayList<TripSub> sub = TripController.getAllTrip();
        for (int i = 0; i < sub.size(); i++) {
            System.out.println(sub.get(i).toString());
        }
    }
}
