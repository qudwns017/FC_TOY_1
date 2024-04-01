package src.main.java.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import com.google.gson.Gson;
import java.util.Objects;
import src.main.java.model.Itinerary;

public class ItineraryController {
    public int checkExistFile(int tripId, String travelType) { // id 기준 json이 존재한다면 tripId 반환, 없으면 0 반환
        String dir = "src/main/resources/" + travelType + "/";
        File file = new File(dir);

        File[] list = file.listFiles();
        int index = 5;
        if (travelType == "itinerary") {
            index = 10;
        }

        for (File t : Objects.requireNonNull(list)) {
            int jsonFileId = Integer.parseInt(t.getName().substring(index, t.getName().indexOf('.')));
            if (Objects.equals(jsonFileId, tripId)) {
                return jsonFileId;
            }
        }
        return -1;
    }
}
