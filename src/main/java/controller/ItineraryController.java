package src.main.java.controller;

import src.main.java.model.Itinerary;

import java.util.ArrayList;
import java.util.List;

public class ItineraryController {

    private List<Itinerary> itineraries = new ArrayList<>();

    public void addItinerary(Itinerary itinerary) {
        itineraries.add(itinerary);
    }

    public List<Itinerary> findItineraries(int tripId) {
        List<Itinerary> result = new ArrayList<>();
        for (Itinerary itinerary : itineraries) {
            if (itinerary.getTrip_id() == tripId) {
                result.add(itinerary);
            }
        }

        return result;
    }
}
