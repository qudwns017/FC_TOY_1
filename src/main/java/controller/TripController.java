package src.main.java.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import src.main.java.dto.TripSub;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;

import java.io.*;
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
        trip.setTripId(jsons.length + 1);

        // trip_(num).json 추가하기
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String newTrip = JSON_DIRECTORY + "trip_" + trip.getTripId() + ".json";

        try {
            FileWriter fw = new FileWriter(newTrip);
            gson.toJson(trip, fw);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Trip getTrip(int tripId) {
        String fileDirectory = "src/main/resources/trip/";
        String fileName = "trip_" + tripId + ".json";
        Trip trip;

        Reader reader = null;
        try {
            reader = new FileReader(fileDirectory+fileName);
            Gson gson = new Gson();
            trip = gson.fromJson(reader, Trip.class);
        } catch (FileNotFoundException ex) {
            return null;
        }

        return trip;
    }

    public static ArrayList<TripSub> getAllTrip(){
        String fileDirectory = "src/main/resources/trip/";
        File dir = new File(fileDirectory);
        ArrayList<TripSub> tripList = new ArrayList<>();
        Reader reader;

        String[] fileList = dir.list();
        if(fileList.length == 0){
            return null;
        }
        for (String fileName : fileList) {
            Gson gson = new Gson();
            try {
                reader = new FileReader(fileDirectory + fileName);
            }
            catch(FileNotFoundException e){
                return null;
            }
            JsonObject json = gson.fromJson(reader, JsonObject.class);
            tripList.add(new TripSub(json.get("trip_id").getAsInt(), json.get("trip_name").getAsString()));
        }
        return tripList;
    }

}
