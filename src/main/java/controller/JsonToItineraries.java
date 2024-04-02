package src.main.java.controller;

import java.io.*;
import java.util.*;

import com.google.gson.*;

import src.main.java.model.*;

public class JsonToItineraries {
    private static List<Itinerary> readJson(int trip_id) {
        String path = "src/main/resources/itineraries/";
        String fileName = "itineraries_" + trip_id + ".json";

        try {
            FileReader json = new FileReader(path + fileName);

            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            ItinerariesJsonDTO ivo = gson.fromJson(json, ItinerariesJsonDTO.class);
            return ivo.getItineraries();
        } catch (FileNotFoundException e) {
            // throw new RuntimeException(e);
            return null;
        }
    }
}
