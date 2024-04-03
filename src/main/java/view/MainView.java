package src.main.java.view;

import src.main.java.controller.ItineraryController;
import src.main.java.controller.TripController;
import src.main.java.model.Trip;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        AddTripView addTripView = new AddTripView(); //여행 기록 뷰
        AddItineraryView addItineraryView = new AddItineraryView(); //여정 기록 뷰
        GetTravelView getTravelView = new GetTravelView(); // 여정/여행 조회 뷰
        ItineraryController itineraryController = new ItineraryController();
        TripController tripController = new TripController();

        while (true){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            switch (num){
                case 1:
                    Trip newTrip = addTripView.getTripInfo();
                    tripController.addTrip(newTrip);
                    System.out.println("여행이 추가되었습니다. ");
                    break;

            }
        }
    }

}