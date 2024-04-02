package src.main.java.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripController {

    public TripController() {
    }

    // 여행 추가하는 함수
    public void addTrip(Trip trip) {
        // trip_(num).json 저장 위치
        String JSON_DIRECTORY = "src/main/resources/trip/";
        File dir = new File(JSON_DIRECTORY);

        // json 파일 개수 세기 > trip_id
        String[] jsons = dir.list();
        trip.setTrip_id(jsons.length + 1);

        // trip_(num).json 추가하기
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        String tripJson = gson.toJson(trip);
        String newTrip = JSON_DIRECTORY + "trip_" + trip.getTrip_id() + ".json";

        try {
            FileWriter fw = new FileWriter(newTrip);
            gson.toJson(tripJson, fw);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
