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
    Messages messages = new Messages();

    public void sendView(){

        while(true){
            messages.startApp();
            Scanner sc = new Scanner(System.in);
            int num =sc.nextInt();
            switch (num){
                case 1: //여행 추가
                    Trip newTrip = addTripView.getTripInfo();
                    tripController.addTrip(newTrip);
                    //Y시 여정 기록으로 넘어가야함 addItineraryView.getItineraryInfo();
                    break;

                case 2: //2.여정기록
                    //2-3.여정기록받기
                    Itinerary itinerary = addItineraryView.getItineraryInfo();
                   /*2-1.여행 아이디, 여행 이름이 첫화면으로 뜨게
                    =====================================================
                    여행 아이디 / 여행 이름

                    여행 아이디 / 여행 이름

                    여행 아이디 / 여행 이름
                   =====================================================
                   2-2. 여정 추가할 여행 아이디 받기
                    여정 추가할 여행의 아이디를 입력해주세요. :

                   =====================================================
                   2-4
                    // - 여정을 더 추가하시겠습니까? (Y/N) :
                    //        - Y : 여정 추가 반복
                    //       // N : Main으로
                    */

                    break;

                case 3://여정조회
                    List<Trip> trips = tripController.loadAllTrip();
                    int selectedTripId = getTravelView.getTrip(trips);
                    Trip selectedTrip = tripController.getTrip(selectedTripId);
                    List<Itinerary> itineraries = itineraryController.getItinerary(selectedTripId);
                    getTravelView.printItineraryInfo(selectedTrip, itineraries);
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. ");
                    break;
            }


        }
    }
}

/*
        //TravelApp에서 입력 받은 값을 전달 받아야
        //MainView mainView = new MainView();
        //mainView.sendView
        //switch를 travelapp, mainview 둘 중 하나에서만
        AddTripView addTripView = new AddTripView(); //여행 기록 뷰
        AddItineraryView addItineraryView = new AddItineraryView(); //여정 기록 뷰
        GetTravelView getTravelView = new GetTravelView(); // 여정/여행 조회 뷰
        TripController tripController = new TripController();
        public void sendView(int num){
               switch (num){
                   case 1: //1. 여행추가
                       addTripView.getTripInfo();
                       break;

                   case 2: //2.여정기록
                       addItineraryView.getItineraryInfo();
                       break;
                   case 3://여정조회
                       List<Trip> trips = tripController.loadAllTrip();
                       int selectedTripId = getTravelView.getTrip(trips);
                       break;
                   case 4:
                       System.out.println("프로그램을 종료합니다");
                       return;
                   default:
                       System.out.println("잘못된 입력입니다. ");
                       break;
               }

     }

     */