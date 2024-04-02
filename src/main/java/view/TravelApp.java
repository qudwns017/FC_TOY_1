package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.util.Scanner;

public class TravelApp {
    public static void main(String[] args) {
        ItineraryController itineraryController = new ItineraryController();
        TripController tripController = new TripController();
        src.main.java.ConsoleView consoleView = new src.main.java.ConsoleView();
        Messages messages = new Messages();

        while (true){
            messages.startApp();
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            switch (num){
                case 1: //여행 기록
                    Trip newTrip = consoleView.getTripInfo();
                    tripController = addTrip(newTrip);
                    System.out.println("여행이 추가되었습니다. ");
                    break;

            }
        }
    }
}
