package src.main.java.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;
import src.main.java.model.ItinerariesJsonDTO;
import src.main.java.model.Itinerary;

public class ItineraryController {
    Gson gson = new Gson();
    Date date = new Date();

    public void addItinerary(int tripId, List<Itinerary> itineraries) {
        itineraries = new ArrayList<>();
        if (checkExistFile(tripId, "trip") == -1) {
            System.out.println("여행이 존재하지 않습니다.");
            return;
        }
        Itinerary itinerary = new Itinerary(0, "A", "B", date, date);
        // list에 기존 객체 추가
        itineraries.add(itinerary);
        ItinerariesJsonDTO dto = new ItinerariesJsonDTO(itineraries);
        String fileName = "src/main/resources/itinerary/itinerary_" + tripId + ".json";
        try {
            FileWriter fw = new FileWriter(fileName);
            gson.toJson(dto, fw); // 변환한 json을 파일로 기록
            fw.flush();
            fw.close();
            System.out.println("작성 완료");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public int checkExistFile(int tripId, String travelType) { // id 기준 json이 존재한다면 tripId 반환, 없으면 0 반환
        String dir = "src/main/resources/" + travelType + "/";
        File file = new File(dir);

        File[] list = file.listFiles();
        int index = 5;
        if (Objects.equals(travelType, "itinerary")) {
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