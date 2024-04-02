package src.main.java;

import src.main.java.controller.TripController;
import src.main.java.model.Trip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        Trip trip = new Trip();

        trip.setTrip_name("1");
        String start_date= "2024/04/12";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date startDate = dateFormat.parse(start_date);
            trip.setStart_date(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String end_date = "2024/04/24";
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date endDate = dateFormat.parse(end_date);
            trip.setStart_date(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TripController tripController = new TripController();
        tripController.addTrip(trip);

    }
}
