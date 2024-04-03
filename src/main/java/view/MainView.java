package src.main.java.view;

import src.main.java.controller.TripController;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.util.List;
import java.util.Scanner;

public class MainView {
        //TravelApp에서 입력 받은 값을 전달 받아야
        //MainView mainView = new MainView();
        //mainView.sendView
        //startmessage,
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
}