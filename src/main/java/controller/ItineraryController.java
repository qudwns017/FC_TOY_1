package src.main.java.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import com.google.gson.Gson;
import java.util.Objects;
import src.main.java.model.Itinerary;

public class ItineraryController {
    Gson gson = new Gson();
    Date date = new Date();

    public void addItinerary(int tripId) {
        if (checkExistFile(tripId, "trip") == -1) {
            System.out.println("여행이 존재하지 않습니다.");
            return;
        }
        if (checkExistFile(tripId, "itinerary") == -1) { // 유효한 tripId지만 입력된 여정이 없을 때
                int itineraryId = tripId;
                Itinerary itinerary = new Itinerary(itineraryId, "A", "B", date, date);
                String fileName = "src/main/resources/itinerary/itinerary_" + itinerary.getItinerary_id() + ".json";
                try {
                    FileWriter fw = new FileWriter(fileName);
                    gson.toJson(itinerary, fw);
                    fw.flush();
                    fw.close();
                    System.out.println("작성 완료");
                } catch (IOException e) {
                    System.out.println(e);
                }
        } else {
            // 이어쓰기 필요
        }
    }

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
