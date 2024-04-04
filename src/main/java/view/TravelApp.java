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
                case 3:
                    mainView.showItineraries();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. ");
                    break;
            }
        }
    }
}