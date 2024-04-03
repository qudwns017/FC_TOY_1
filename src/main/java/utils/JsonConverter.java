package src.main.java.utils;

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


    public Trip loadTrip(int tripId) {
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

    public List<Trip> loadAllTrip() {
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

    public void saveTrip(Trip trip) {
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

    public List<Itinerary> loadItineraries(int tripId) {
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

    public void saveItineraries(int tripId, List<Itinerary> itineraries) {
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
}
