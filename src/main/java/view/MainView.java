package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.util.InputMismatchException;
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
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }
        catch(InputMismatchException e){
            return -1;
        }

    }
    public void addTrips(){
        Trip newTrip = addTripView.getTripInfo();
        tripController.addTrip(newTrip);
        Messages.sleep();

        resentItineraries(newTrip);
        Messages.sleep();
        Messages.clear();
    }
    public void addItineraries(){
        List<Trip> trips = tripController.loadAllTrip();
        int selectedTripId = getTravelView.getTrip(trips);
        Trip trip = tripController.getTrip(selectedTripId);
        Itinerary itinerary = addItineraryView.getItineraryInfo(trip);
        itineraryController.addItinerary(selectedTripId ,itinerary);
        Messages.sleep();

        resentItineraries(trip);
        Messages.sleep();
        Messages.clear();
    }
    public void addItineraries(Trip newTrip){
        Itinerary itinerary = addItineraryView.getItineraryInfo(newTrip);
        itineraryController.addItinerary(newTrip.getTripId(), itinerary);
        resentItineraries(newTrip);
        Messages.sleep();
        Messages.clear();
    }

    public void resentItineraries(Trip trip){
        if(Messages.getYesNoAnswer("여정을 추가하시겠습니까?")){
            addItineraries(trip);
        }
        Messages.sleep();
        Messages.clear();
    }

    public void  showItineraries(){
        List<Trip> trips = tripController.loadAllTrip();
        int selectedTripId = getTravelView.getTrip(trips);
        Trip selectedTrip = tripController.getTrip(selectedTripId);
        List<Itinerary> itineraries = itineraryController.getItinerary(selectedTripId);
        getTravelView.printItineraryInfo(selectedTrip, itineraries);
        Messages.sleep();
        Messages.clear();
    }

}

