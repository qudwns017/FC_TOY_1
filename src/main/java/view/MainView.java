package src.main.java.view;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        AddTripView addTripView = new AddTripView(); //여행 기록 뷰
        AddItineraryView addItineraryView = new AddItineraryView(); //여정 기록 뷰
        GetTravelView getTravelView = new GetTravelView(); // 여정/여행 조회 뷰
    }
}
