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
        ItineraryController itineraryController = new ItineraryController();
        TripController tripController = new TripController();
        public AddTripView getAddTripView(){
                return addTripView;
        }

        public AddItineraryView getAddItineraryView() {
                return addItineraryView;
        }

        public GetTravelView getGetTravelView(){
                return getTravelView;
        }
}