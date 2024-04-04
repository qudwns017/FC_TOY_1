package src.main.java.controller;

import java.util.List;
import src.main.java.model.Itinerary;
import src.main.java.utils.JsonConverter;

public class ItineraryController {
    JsonConverter jsonConverter = new JsonConverter();

    public void addItinerary(int tripId, Itinerary itinerary) {
        List<Itinerary> itineraryList = getItinerary(tripId);
        int itineraryId = itineraryList.size() + 1;
        itinerary.setItineraryId(itineraryId);
        itineraryList.add(itinerary);
        jsonConverter.saveItineraries(tripId, itineraryList);
    }

    public List<Itinerary> getItinerary(int tripId) {
        return jsonConverter.loadItineraries(tripId);
    }

    public Itinerary getItinerary(int tripId, int itinerary_id) {
        List<Itinerary> itineraryList = jsonConverter.loadItineraries(tripId);
        for (Itinerary obj : itineraryList) {
            if (itinerary_id == obj.getItineraryId()) {
                return obj;
            }
        }
        System.out.println("해당하는 여정이 없음");
        return null;
    }
}