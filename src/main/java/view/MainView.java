package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.utils.Messages;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    AddTripView addTripView = new AddTripView();
    AddItineraryView addItineraryView = new AddItineraryView();
    GetTravelView getTravelView = new GetTravelView();
    TripController tripController = new TripController();
    ItineraryController itineraryController = new ItineraryController();

    public int sendCase() {
        Messages.startApp();
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        }

    }

    public void addTrips() {
        HashMap<String, String> newTrip = addTripView.getTripInfo();
        tripController.addTrip(newTrip);
        Messages.sleep();

        resentItineraries(newTrip);
        Messages.sleep();
        Messages.clear();
    }

    public void addItineraries() {
        HashMap<Integer, HashMap<String, String>> trips = tripController.loadAllTrip();
        int selectedTripId = getTravelView.getTrip(trips);
        HashMap<String, String> trip = tripController.getTrip(selectedTripId);
        getTravelView.printTripNameDate(trip);
        HashMap<String, String> itinerary = addItineraryView.getItineraryInfo(trip);
        itineraryController.addItinerary(selectedTripId, itinerary);
        Messages.sleep();
        resentItineraries(trip);
        Messages.sleep();
        Messages.clear();
    }

    public void addItineraries(HashMap<String, String> newTrip) {
        HashMap<String, String> itinerary = addItineraryView.getItineraryInfo(newTrip);
        itineraryController.addItinerary(Integer.parseInt(newTrip.get("trip_id")), itinerary);
        resentItineraries(newTrip);
        Messages.sleep();
        Messages.clear();
    }

    public void resentItineraries(HashMap<String, String> trip) {
        if (Messages.getYesNoAnswer("여정을 추가하시겠습니까?")) {
            addItineraries(trip);
        }
        Messages.sleep();
        Messages.clear();
    }

    public void showItineraries() {
        HashMap<Integer, HashMap<String, String>> trips = tripController.loadAllTrip();
        int selectedTripId = getTravelView.getTrip(trips);
        HashMap<String, String> selectedTrip = tripController.getTrip(selectedTripId);
        HashMap<Integer, HashMap<String, String>> itineraries = itineraryController.getItinerary(selectedTripId);
        getTravelView.printItineraryInfo(selectedTrip, itineraries);
        Messages.sleep();
        Messages.clear();
    }

}

