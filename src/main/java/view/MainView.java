package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;

import java.util.List;
import java.util.Scanner;

public class MainView {
        AddTripView addTripView = new AddTripView(); //여행 기록 뷰
        AddItineraryView addItineraryView = new AddItineraryView(); //여정 기록 뷰
        GetTravelView getTravelView = new GetTravelView(); // 여정/여행 조회 뷰

        public void sendView(int num){
                switch (num){
                        case 1:
                                addTripView.getTripInfo();
                                break;
                        case 2:
                                addItineraryView.getItineraryInfo();
                                break;

                }
        }
}