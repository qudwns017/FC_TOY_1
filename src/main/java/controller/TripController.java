package src.main.java.controller;

import src.main.java.model.Trip;

import java.util.List;
import src.main.java.utils.JsonConverter;

public class TripController {

    JsonConverter jsonConverter = new JsonConverter();

    public void addTrip(Trip trip) {
        // 출발일 <= 도착일 확인하기
        // 같은 이름의 같은 일정으로 여행이 있는지 확인하기
        List<Trip> list = jsonConverter.loadAllTrip();
        trip.setTripId(list.size() + 1);
        jsonConverter.saveTrip(trip);
    }

    public Trip getTrip(int tripId) {
        // 여행이 최소 1개 있는지 확인
        return jsonConverter.loadTrip(tripId);
    }

    public List<Trip> loadAllTrip() {
        // 여행이 최소 1개 있는지 확인
        return jsonConverter.loadAllTrip();
    }

//    public void removeTrip(int tripId) {
//
//    }
}
