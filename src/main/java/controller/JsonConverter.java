package src.main.java.controller;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.*;

import src.main.java.model.*;

public class JsonConverter {
    private static final String BASE_PATH = "src/main/resources/";
    private static final String TRIP_PATH = BASE_PATH + "trip/";
    private static final String ITINERARIES_PATH = BASE_PATH + "itineraries/";


    public static Trip loadTrip(int tripId) {
        String fileName = "trip_" + tripId + ".json";

        try (FileReader fr = new FileReader(TRIP_PATH + fileName)) {
            Gson gson = new GsonBuilder()
                    // .setDateFormat("yyyy-MM-dd")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            return gson.fromJson(fr, Trip.class);
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    public static List<Trip> loadAllTrip() {
        // 존재하는 Trip 파일 ID 검색
        List<Integer> existTripFileId = new ArrayList<>();

        File directory = new File(TRIP_PATH);
        File[] files = directory.listFiles();
        if (files != null) {
            Pattern pattern = Pattern.compile("\\d+");
            for (File file : files) {
                if (file.isFile() && file.getName().startsWith("trip_") && file.getName().endsWith(".json")) {
                    Matcher matcher = pattern.matcher(file.getName());
                    while (matcher.find()) {
                        existTripFileId.add(Integer.parseInt(matcher.group()));
                    }
                }
            }
        }

        Collections.sort(existTripFileId);

        List<Trip> trips = new ArrayList<>();
        for (int tripId : existTripFileId) {
            trips.add(loadTrip(tripId));
        }

        return trips;
    }

    public static void saveTrip(Trip trip) {
        String fileName = "trip_" + trip.getTripId() + ".json";

        try (FileWriter fw = new FileWriter(TRIP_PATH + fileName)) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();
            gson.toJson(trip, fw);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static List<Itinerary> loadItineraries(int tripId) {
        String fileName = "itineraries_" + tripId + ".json";

        try (FileReader fr = new FileReader(ITINERARIES_PATH + fileName)) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();
            ItinerariesJsonDTO dto = gson.fromJson(fr, ItinerariesJsonDTO.class);
            return dto.getItineraries();
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    // 생각해보니 이건 컨트롤러에 있어야 할 듯;;
    public static Itinerary loadItinerary(int tripId, int itinerartId) {
        List<Itinerary> itineraries = loadItineraries(tripId);

        if (itineraries == null) return null;

        for (Itinerary i : itineraries) {
            if (i.getItineraryId() == itinerartId) {
                return i;
            }
        }
        return null;
    }

    public static void saveItineraries(int tripId, List<Itinerary> itineraries) {
        String fileName = "itineraries_" + tripId + ".json";

        try (FileWriter fw = new FileWriter(ITINERARIES_PATH + fileName)) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();
            ItinerariesJsonDTO dto = new ItinerariesJsonDTO(itineraries);
            gson.toJson(dto, fw);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void testAdds() {
        int tripId = 3;

        // Trip 저장 테스트 시작
        String tripName = "trip_" + tripId;
        Date startDate = new Date();
        Date endDate = new Date(System.currentTimeMillis() + 86400000 * 2);
        saveTrip(new Trip(tripId, tripName, startDate, endDate));
        // Trip 저장 테스트 종료

        // Itinerary 저장 테스트 시작
        String departurePlace = "Place ";
        String destination = "Place ";
        Date now = new Date(); // 현재 시간
        List<Itinerary> itineraries = new ArrayList<>();

        itineraries.add(new Itinerary(1, departurePlace + "H", destination + "B", now, new Date(now.getTime() + 90000000), now, new Date(now.getTime() + 80000000)));
        itineraries.add(new Itinerary(2, departurePlace + "B", destination + "C", itineraries.get(0).getArrivalTime(), new Date(itineraries.get(0).getArrivalTime().getTime() + 90000000), itineraries.get(0).getArrivalTime(), new Date(itineraries.get(0).getArrivalTime().getTime() + 80000000)));
        itineraries.add(new Itinerary(2, departurePlace + "C", destination + "D", itineraries.get(1).getArrivalTime(), new Date(itineraries.get(1).getArrivalTime().getTime() + 90000000), itineraries.get(1).getArrivalTime(), new Date(itineraries.get(1).getArrivalTime().getTime() + 80000000)));
        itineraries.add(new Itinerary(2, departurePlace + "D", destination + "E", itineraries.get(2).getArrivalTime(), new Date(itineraries.get(2).getArrivalTime().getTime() + 90000000), itineraries.get(2).getArrivalTime(), new Date(itineraries.get(2).getArrivalTime().getTime() + 80000000)));
        itineraries.add(new Itinerary(2, departurePlace + "E", destination + "H", itineraries.get(3).getArrivalTime(), new Date(itineraries.get(3).getArrivalTime().getTime() + 90000000), itineraries.get(3).getArrivalTime(), new Date(itineraries.get(3).getArrivalTime().getTime() + 80000000)));
        saveItineraries(tripId, itineraries);
        // Itinerary 저장 테스트 정료
    }

    private static void testLoad() {
        // Trip, Itinerary 읽기 테스트 시작
        System.out.println("*** Trip");
        int loadTripId = 2;
        System.out.println(loadTrip(loadTripId));

        System.out.println("*** Itineraries");
        List<Itinerary> it = loadItineraries(loadTripId);
        for (Itinerary i : it) {
            System.out.println(i);
        }
        // Trip, Itinerary 읽기 테스트 종료

        System.out.println("*** Trips");
        List<Trip> trips = loadAllTrip();
        for (Trip t : trips) {
            System.out.println(t);
        }
    }

}
