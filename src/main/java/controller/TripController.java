package src.main.java.controller;

import src.main.java.model.Trip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import src.main.java.utils.JsonConverter;

public class TripController {

    JsonConverter jsonConverter = new JsonConverter();
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public void addTrip(HashMap<String, String> tripHash){
        List<Trip> list = jsonConverter.loadAllTrip();
        Trip trip = null;
        try {
            trip = new Trip(tripHash.get("trip_name"),
                    dateFormat.parse(tripHash.get("start_date")) ,
                    dateFormat.parse(tripHash.get("end_date")));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        trip.setTripId(list.size() + 1);
        jsonConverter.saveTrip(trip);
    }

    public HashMap<String, String> getTrip(int tripId) {
        Trip trip = jsonConverter.loadTrip(tripId);
        HashMap<String, String> tripHash = new HashMap<>();
        tripHash.put("trip_id", trip.getTripId() +"");
        tripHash.put("trip_name", trip.getTripName());
        tripHash.put("start_date", dateFormat.format(trip.getStartDate()));
        tripHash.put("end_date",dateFormat.format(trip.getEndDate()));

        return tripHash;
    }

    public HashMap<Integer, HashMap<String, String>> loadAllTrip() {
        // 여행이 최소 1개 있는지 확인
        List<Trip> tripList = jsonConverter.loadAllTrip();
        HashMap<Integer, HashMap<String, String>> trips = new HashMap<>();

        for(Trip trip : tripList){
            HashMap<String, String> subTripHash = new HashMap<>();
            subTripHash.put("trip_name", trip.getTripName());
            subTripHash.put("start_date", dateFormat.format(trip.getStartDate()));
            subTripHash.put("end_date",dateFormat.format(trip.getEndDate()));

            trips.put(trip.getTripId(), subTripHash);
        }

        return trips;
    }

//    public void removeTrip(int tripId) {
//
//    }
}
