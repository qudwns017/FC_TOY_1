package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.utils.Messages;

import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        ItineraryController itineraryController = new ItineraryController();
        TripController tripController = new TripController();
        src.main.java.ConsoleView consoleView = new src.main.java.ConsoleView();
        Messages messages = new Messages();

        while (num){
            messages.startApp();
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
        }
    }
}
