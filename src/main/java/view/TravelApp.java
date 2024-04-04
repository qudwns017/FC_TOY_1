package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.util.List;
import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        MainView mainView = MainView();

        while(true){
            int num = mainView.sendCase();
            switch (num){
                case 1:
                    mainView.addTrips();
                    break;
                case 2:
                    mainView.addItineraries();
                    break;

            }
        }
    }
}

/*
public int sendCase()
public void addTrips()
public void addItineraries()
public void  showItineraries()
 */