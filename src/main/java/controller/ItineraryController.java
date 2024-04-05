package src.main.java.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import src.main.java.model.Itinerary;
import src.main.java.service.JsonConverter;

public class ItineraryController {
    private static final JsonConverter jsonConverter = new JsonConverter();

    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHH:mm");


    public void addItinerary(int tripId, HashMap<String, String> itineraryData) {
        Itinerary itinerary;
        try {
            if (itineraryData.containsKey("check_in")) {
                itinerary = new Itinerary(
                        itineraryData.get("departure_place"), itineraryData.get("destination"),
                        dateTimeFormat.parse(itineraryData.get("departure_time")),
                        dateTimeFormat.parse(itineraryData.get("arrival_time")),
                        dateTimeFormat.parse(itineraryData.get("check_in")),
                        dateTimeFormat.parse(itineraryData.get("check_out"))
                );
            } else {
                itinerary = new Itinerary(
                        itineraryData.get("departure_place"), itineraryData.get("destination"),
                        dateTimeFormat.parse(itineraryData.get("departure_time")),
                        dateTimeFormat.parse(itineraryData.get("arrival_time"))
                );
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<Itinerary> itineraries = jsonConverter.loadItineraries(tripId);
        int nextItineraryId = itineraries.size() + 1;
        itinerary.setItineraryId(nextItineraryId);
        itineraries.add(itinerary);
        jsonConverter.saveItineraries(tripId, itineraries);
    }


    public HashMap<Integer, HashMap<String, String>> getItinerary(int tripId) {
        List<Itinerary> itineraries = jsonConverter.loadItineraries(tripId);
        HashMap<Integer, HashMap<String, String>> itinerariesData = new HashMap<>();
        for (Itinerary obj : itineraries) {
            HashMap<String, String> itineraryData = new HashMap<>();
            itineraryData.put("itinerary_id", String.valueOf(obj.getItineraryId()));
            itineraryData.put("departure_place", obj.getDeparturePlace());
            itineraryData.put("destination", obj.getDestination());
            itineraryData.put("departure_time", dateTimeFormat.format(obj.getDepartureTime()));
            itineraryData.put("arrival_time", dateTimeFormat.format(obj.getArrivalTime()));
            if (obj.getCheckIn() != null) {
                itineraryData.put("check_in", dateTimeFormat.format(obj.getCheckIn()));
                itineraryData.put("check_out", dateTimeFormat.format(obj.getCheckOut()));
            }
            itinerariesData.put(obj.getItineraryId(), itineraryData);
        }

        return itinerariesData;
    }
}