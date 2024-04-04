package src.main.java.controller;

import java.util.ArrayList;
import java.util.List;
import src.main.java.model.Itinerary;
import src.main.java.utils.JsonConverter;

public class ItineraryController {
    JsonConverter jsonConverter = new JsonConverter();

    // 파일이 있을 때 / 없을 때
    // 있을 때
    // json파일을 읽어서 list에 삽입
    // 새로 받은 객체를 리스트의 마지막에 추가하여 json에 다시 save

    // 없을 때
    // 새로 받은 객체를 바로 save에 넣기

    public void addItinerary(int tripId, Itinerary itinerary) {
        int itineraryId;
        List<Itinerary> itineraryList;
        if (getItinerary(tripId) != null) {
            itineraryList = getItinerary(tripId);
            itineraryId = itineraryList.get(itineraryList.size() - 1).getItineraryId() + 1;
            itinerary.setItineraryId(itineraryId);
        } else {
            itineraryList = new ArrayList<>();
            itinerary.setItineraryId(1);
        }
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