package src.main.java.view;

import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/*
- getTripInfo(): Trip //1. 여행기록 .
- getItineraryInfo(): Itinerary  //2. 여정 기록

- printItinerary(trip_id, itinerary_id) //여정 프린트,여정 하나씩 출력. 하나씩 출력,
- printItineraries() // 모든 여정 프린트 //3.조회 .

- printAllTrip() //모든 여행 //3. 조회
- printTrip(int trip_id) // 여행 상세, 출발, 도착 , 여행 번호 입력?
 */

public class ConsoleView {
    Messages messages = new Messages();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyyMMddhh:mm");

    public int getTrip(List<Trip> trips){
        messages.equal();
        for (Trip trip : trips) {
            System.out.println("여행 id : " + trip.getTripId()+ "\t여행 이름 : " + trip.getTripName());
        }
        messages.equal();
        System.out.println("조회할 여행 번호를 입력해주세요 : ");
        int trip_id = sc.nextInt();
        if(trip_id > trips.size() || trip_id <= 0){
            trip_id = -1;
        }
        return trip_id;
    }

    public String getString(String str){
        System.out.print(str + "을 입력해주세요 : ");
        String tmp = sc.nextLine();
        return tmp;
    }

    public Date getDate(String str){
        System.out.print(str + "를 입력해주세요 ex)20240401 : ");
        String dateInput = sc.nextLine();

        Date date = null;
        try{
            date = dateFormat.parse(dateInput);
        }
        catch(Exception e){
            System.out.println("잘못된 형식입니다. yyyymmdd 형식으로 입력해주세요");
            date = getDate(str);
        }
        System.out.println(" ");
        return date;
    }

    public Date getDateTime(String str, Date date){
        System.out.print(str + "을 입력해주세요 ex) 12:30 : ");
        String timeInput = sc.nextLine();

        String dateString = dateFormat.format(date);
        Date time = null;
        try{
            time = TimeFormat.parse(dateString + timeInput);
            return time;
        }
        catch(Exception e){
            System.out.println("잘못된 형식입니다. hh:mm 형식으로 입력해주세요");
            time = getDateTime(str, date);
        }
        System.out.println(" ");
        return time;
    }

    public Trip getTripInfo() { //1.여행 기록
        messages.equal();
        System.out.println("- 여행 이름을 입력해주세요. :");
        String tripName = sc.nextLine();

        Date startDate;
        Date endDate;
        startDate = getDate("시작 날짜");
        endDate = getDate("종료 날짜");

        return new Trip(tripName, startDate, endDate);
    }

    public Itinerary getItineraryInfo() { //2.여정기록
        messages.equal();
        sc = new Scanner(System.in);
        System.out.println("여정에 대한 정보를 입력하겠습니다.");
        System.out.println("여정 출발 장소를 입력해주세요 :");
        String departurePlace = sc.nextLine();
        System.out.println("여정 도착 장소를 입력해주세요 :");
        String destination = sc.nextLine();


        Date departure_day;
        Date arrival_day;

        departure_day = getDate("여정 출발 날짜");
        departure_day = getDateTime("여정 출발 시간", departure_day);

        arrival_day = getDate("여정 도착 날짜");
        arrival_day = getDateTime("여정 도착 시간", arrival_day);

        System.out.println("체크인을 하십니까? (Y/N) : ");
        String check_in_answer = sc.nextLine();

        Date check_in = null;
        Date check_out = null;
        if (check_in_answer.equals("Y")) { //체크인 Y
            check_in = getDate("체크인 날짜");
            check_in = getDateTime("체크인 시간", check_in);

            check_out = getDate("체크아웃 날짜");
            check_out = getDateTime("체크아웃 시간", check_out);

            try {
                //체크인 시간이 여정 출발 시간 이전인지 and 도착 시간이 체크인 이후인지
                if (check_in.before(departure_day) || check_in.after(arrival_day)) {
                    System.out.println(" 체크인/체크아웃 시간은 여정 출발 시간과 도착 시간 사이여야합니다.");
                    return null;
                }
            } catch (Exception e) {
                System.out.println("잘못된 형식입니다. ");
                return null;
            }
        } else if (check_in_answer.equals("N")) { //체크인 하지 않는다
            return new Itinerary(departurePlace, destination, departure_day, arrival_day);
        }

        System.out.println(" - 여정을 더 추가하시겠습니까? (Y/N) : "); //TravelApp?
        String answer = sc.nextLine();
        if (answer.equals("Y")) {
            return getItineraryInfo();//여정 기록으로 돌아감
        } else if (answer.equals("N")) {
            //메인으로 돌아감
        } else {
            System.out.println("잘못된 입력입니다 Y / N 형식으로 입력해주세요.");
        }

        return new Itinerary(departurePlace, destination, departure_day, arrival_day,
                check_in, check_out);
    }

    public void printItineraryInfo(Trip trip, List<Itinerary> itineraries) { //조회
        sc = new Scanner(System.in);
        List<Itinerary> allItinerary = itineraries;
        System.out.println(trip.getTripName() + "에 대한 여정 정보입니다");
        System.out.println("해당 여행에 대한 여정 정보를 확인하시겠습니까? (Y/N) :");
        String answer = sc.nextLine();
        if (answer.equals("Y")) { //여정정보 확인
            for (Itinerary itinerary : allItinerary) {
                System.out.println("출발 시간 :" + itinerary.getDepartureTime());
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
            }
        } else if (answer.equals("N")) { //여정 정보 확인하지 않음
            return;

        }
    }
}
