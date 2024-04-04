package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.util.List;
import java.util.Scanner;

public class MainView {
    AddTripView addTripView = new AddTripView(); //여행추가
    AddItineraryView addItineraryView = new AddItineraryView(); //여정기록
    GetTravelView getTravelView = new GetTravelView(); // 여정/여행 조회 뷰
    TripController tripController = new TripController();
    ItineraryController itineraryController = new ItineraryController();
    Messages messages = new Messages();
    public int sendCase(){
        messages.startApp();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public void addTrips(){
        Trip newTrip = addTripView.getTripInfo();
        tripController.addTrip(newTrip);
    }

}

