package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Itinerary;
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

                case 2: //여정기록
                    Itinerary newItinerary = consoleView.getItineraryInfo();
                    if (addItinerary != null){
                        TripController.addItinerary(newItinerary);
                        System.out.println("추가 완료 했습니다");
                    }else{
                        System.out.println("추가에 실패했습니다.");
                    }
                    break;

            }
        }
    }
}
