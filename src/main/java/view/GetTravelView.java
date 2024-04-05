package src.main.java.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import src.main.java.utils.Messages;

public class GetTravelView {
    Scanner sc;

    public int getTrip(HashMap<Integer, HashMap<String, String>> trips) {
        sc = new Scanner(System.in);
        Messages.equal();
        for (Entry<Integer, HashMap<String, String>> trip : trips.entrySet()) {
            System.out.println("여행 ID : " + trip.getKey() + "\t여행 이름 : " + trip.getValue().get("trip_name"));
        }
        Messages.equal();
        while (true) {
            System.out.print("조회할 여행 번호를 입력해주세요 : ");
            int trip_id = sc.nextInt();
            if (trip_id > trips.size() || trip_id <= 0) {
                System.out.println("입력하신 여행 ID는 존재하지 않습니다. 다시 입력해주세요.");
            } else {
                return trip_id;
            }
        }
    }

    private void printNextInfoItineraryInfo(HashMap<Integer, HashMap<String, String>> itineraries) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        sc = new Scanner(System.in);
        String answer = "Y";
        while (answer.equals("Y")) {
            for (Entry<Integer, HashMap<String, String>> itinerary : itineraries.entrySet()) {
                Messages.equal();
                try {
                    Date departureTime = dateFormat.parse(itinerary.getValue().get("departure_time"));
                    Date arrivalTime = dateFormat.parse(itinerary.getValue().get("arrival_time"));
                    Date checkIn = dateFormat.parse(itinerary.getValue().get("check_out"));
                    Date checkOut = dateFormat.parse(itinerary.getValue().get("check_in"));
                    System.out.println("출발지 : " + itinerary.getValue().get("departure_place"));
                    System.out.println("출발 시간 : " + Messages.printFormatDate(departureTime));
                    System.out.println("도착지 : " + itinerary.getValue().get("destination"));
                    System.out.println("도착 시간 : " + Messages.printFormatDate(arrivalTime));

                    if (checkIn != null) {
                        System.out.println("체크인 시간 : " + Messages.printFormatDateTime(checkIn));
                    } else {
                        System.out.println("체크인 시간 : 체크인 없음");
                    }

                    if (checkOut != null) {
                        System.out.println("체크아웃 시간 : " + Messages.printFormatDateTime(checkOut));
                    } else {
                        System.out.println("체크아웃 시간 : 체크아웃 없음");
                    }
                    Messages.equal();
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }

                System.out.print("\n다음 여정을 확인하시려면 엔터키를 누르세요.\n");
                sc.nextLine();
            }
            System.out.println("모든 여정을 확인했습니다.");
            System.out.print("여정을 다시 확인하시겠습니까? (Y/N) : ");
            answer = sc.nextLine();
        }
    }

    public void printItineraryInfo(HashMap<String, String> trip,
                                   HashMap<Integer, HashMap<String, String>> itineraries) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        sc = new Scanner(System.in);
        System.out.println(trip.get("trip_name") + "에 대한 여행 정보입니다");
        Messages.equal();
        System.out.println("여행 이름 : " + trip.get("trip_name"));
        try {
            Date startDate = dateFormat.parse(trip.get("start_date"));
            Date endDate = dateFormat.parse(trip.get("end_date"));

            System.out.println("시작 날짜 : " + Messages.printFormatDate(startDate));
            System.out.println("종료 날짜 : " + Messages.printFormatDate(endDate));
            System.out.print("해당 여행에 대한 여정 정보를 확인하시겠습니까? (Y/N) : ");
            String answer = sc.nextLine();
            if (answer.equals("Y")) { //여정정보 확인
                printNextInfoItineraryInfo(itineraries);
            } else {
                System.out.println("처음 화면으로 돌아갑니다.");
                return;
            }

            System.out.println("처음 화면으로 돌아갑니다.");

        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printTripNameDate(HashMap<String, String> trip) {
        Messages.equal();
        System.out.println("여행 이름 : " + trip.get("trip_name"));
        System.out.println("시작 날짜 : " + trip.get("start_date"));
        System.out.println("종료 날짜 : " + trip.get("end_date"));
    }
}
