package src.main.java.model;

import java.util.*;

public class ItinerariesJsonDTO {
    private List<Itinerary> itineraries;

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public ItinerariesJsonDTO(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }
}
