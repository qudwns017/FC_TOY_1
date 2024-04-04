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
        MainView mainView = new MainView();
        mainView.sendView();;

    }
}
/*
        ItineraryController itineraryController = new ItineraryController();
        TripController tripController = new TripController();
        ConsoleView consoleView = new ConsoleView();
        MainView mainView = new MainView(); //값을 전달 한다면
        Messages messages = new Messages();
        messages.startApp();
        GetTravelView getTravelView = new GetTravelView();
        AddTripView addTripView = new AddTripView();

        while (true){
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            mainView.sendView(num); //mainView에게 값을 전달 한다면
            switch (num){
                case 1: //여행 기록
                    Trip newTrip = addTripView.getTripInfo();
                    tripController.addTrip(newTrip);
                    System.out.println("여행이 추가되었습니다. ");

                    try {
                        Thread.sleep(1500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;

                     //@@@@@@@@수정 필요
                case 2: //여정기록
                    List<Trip> trip = tripController.loadAllTrip();

                    int trip_id = consoleView.getTrip(trip);
                    if(trip_id == -1){
                        System.out.println("존재하지 않는 여행 번호 입니다. ");
                        return;
                    }
                    Itinerary newItinerary = consoleView.getItineraryInfo();
                    itineraryController.addItinerary(trip_id, newItinerary);

                    break;

                case 3: //조회
                    List<Trip> trips = tripController.loadAllTrip(); //여행 번호와 아이디만 findAllTrip()
                    // 여행 상세 추가 printAllTrip()
                    try{ // @@@@@@@@@ 조회할 여행 번호 받아오기
                        int trips_id = getTravelView.getTrip(trips);
                        if(trips_id == -1){
                            System.out.println("존재하지 않는 여행 번호 입니다. ");
                            return;
                        }

                        List<Itinerary> itineraries = itineraryController.getItinerary(trips_id);
                        Trip cur_trip = tripController.getTrip(trips_id);
                        getTravelView.printItineraryInfo(cur_trip,itineraries);
                        break;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                case 4:
                    System.out.println(" 프로그램을 종료합니다. ");
                    return;
                default:
                    System.out.println(" 잘못된 입력입니다. ");
                    break;
            }
        }
*/
