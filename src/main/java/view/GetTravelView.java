package src.main.java.view;

import java.util.List;
import java.util.Scanner;
import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

public class GetTravelView {
    Messages messages = new Messages();
    Scanner sc;

    public int getTrip(List<Trip> trips) {
        sc = new Scanner(System.in);
        messages.equal();
        for (Trip trip : trips) {
            System.out.println("여행 id : " + trip.getTripId() + "\t여행 이름 : " + trip.getTripName());
        }
        messages.equal();
        System.out.print("조회할 여행 번호를 입력해주세요 : ");
        int trip_id = sc.nextInt();
        if (trip_id > trips.size() || trip_id <= 0) {
            trip_id = -1;
        }
        return trip_id;
    }

    private void printNextInfoItineraryInfo(List<Itinerary> itineraries) {
        sc = new Scanner(System.in);
        String answer = "Y";
        while (answer.equals("Y")) {
            for (Itinerary itinerary : itineraries) {
                messages.equal();
                System.out.println("출발지 : " + itinerary.getDeparturePlace());
                System.out.println("출발 시간 :" + itinerary.getDepartureTime());
                System.out.println("도착지 : " + itinerary.getDestination());
                System.out.println("도착 시간 :" + itinerary.getArrivalTime());

                if (itinerary.getCheckIn() != null) {
                    System.out.println("체크인 시간 :" + itinerary.getCheckIn());
                } else {
                    System.out.println("체크인 시간 : 체크인 없음");
                }

                if (itinerary.getCheckOut() != null) {
                    System.out.println("체크아웃 시간 :" + itinerary.getCheckOut());
                } else {
                    System.out.println("체크아웃 시간 : 체크아웃 없음");
                }
                messages.equal();

                System.out.print("\n다음 여정을 확인하시려면 엔터키를 누르세요.\n");
                sc.nextLine();
            }
            System.out.println("모든 여정을 확인했습니다.");
            System.out.print("여정을 다시 확인하시겠습니까? (Y/N) : ");
            answer = sc.nextLine();
        }
    }

    public void printItineraryInfo(Trip trip, List<Itinerary> itineraries) { // 3
        sc = new Scanner(System.in);
        List<Itinerary> allItinerary = itineraries;
        System.out.println(trip.getTripName() + "에 대한 여행 정보입니다");
        messages.equal();
        System.out.println("여행 이름 : " + trip.getTripName());
        System.out.println("시작 날짜 : " + trip.getStartDate());
        System.out.println("종료 날짜 : " + trip.getEndDate());
        System.out.print("해당 여행에 대한 여정 정보를 확인하시겠습니까? (Y/N) : ");
        String answer = sc.nextLine();
        if (answer.equals("Y")) { //여정정보 확인
            printNextInfoItineraryInfo(allItinerary);
        } else {
            System.out.println("처음 화면으로 돌아갑니다.");
            return;
        }

        System.out.println("처음 화면으로 돌아갑니다.");

    }
}
