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

    public int sendCase(){
        Messages.startApp();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public void addTrips(){
        Trip newTrip = addTripView.getTripInfo();
        tripController.addTrip(newTrip);
        Messages.sleep();
    }
    public void addItineraries(){
        List<Trip> trips = tripController.loadAllTrip();
        int selectedTripId = getTravelView.getTrip(trips);
        Trip trip = tripController.getTrip(selectedTripId);
        Itinerary itinerary = addItineraryView.getItineraryInfo(trip);
        itineraryController.addItinerary(selectedTripId ,itinerary);
        Messages.sleep();
    }
    public void  showItineraries(){
        List<Trip> trips = tripController.loadAllTrip();
        int selectedTripId = getTravelView.getTrip(trips);
        Trip selectedTrip = tripController.getTrip(selectedTripId);
        List<Itinerary> itineraries = itineraryController.getItinerary(selectedTripId);
        getTravelView.printItineraryInfo(selectedTrip, itineraries);
        Messages.sleep();
    }

}

