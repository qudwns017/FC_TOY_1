package src.main.java.view;

import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleView {
    Messages messages = new Messages();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    public Trip getTripInfo() { //1.여행 기록
        messages.equal();
        System.out.println("- 여행 이름을 입력해주세요. :");
        String tripName = sc.nextLine();
        System.out.println("- 시작 날짜를 입력해주세요. ex) 20240401 :");
        String startDateFormat = sc.nextLine();
        System.out.println("- 종료 날자를 입력해주세요. ex) 20240403 :");
        String endDateFormat = sc.nextLine();
        System.out.println();

        Date startDate;
        Date endDate;

        try { //문자열을 데이트 포맷으로 변경
            startDate = dateFormat.parse(startDateFormat);
            endDate = dateFormat.parse(endDateFormat);
        } catch (Exception e) {
            System.out.println("잘못된 형식입니다. yyyymmdd 형식으로 입력해주세요");
            return null;
        }
        return new Trip(tripName, startDate, endDate);
    }

    public Itinerary getItineraryInfo() { //2.여정기록
        messages.equal();
        System.out.println("여정에 대한 정보를 입력하겠습니다.");
        System.out.println(" 여정 이름을 입력해주세요 :");
        String itinerary_name = sc.nextLine();
        System.out.println("여정 출발 장소를 입력해주세요 :");
        String departure_place = sc.nextLine();
        System.out.println(" 여정 도착 장소를 입력해주세요 :");
        String destination = sc.nextLine();

        System.out.println("여정 출발 날짜를 입력해주세요 ex) 240401 : ");
        String departure_day_format = sc.nextLine();//
        System.out.println("여정 출발 시간을 입력해주세요 ex) 13:30 : ");
        String departure_time_format = sc.nextLine();//
        System.out.println("여정 도착 날짜를 입력해주세요 ex) 240402 :");
        String arrival_day_format = sc.nextLine();
        System.out.println(" 여정 도착 시간을 입력해주세요 ex) 17:30 : ");
        String arrival_time_format = sc.nextLine();
        System.out.println();
        System.out.println("체크인을 하십니까? (Y/N) : ");
        String check_in_answer = sc.nextLine();
        Date departure_time;
        Date arrival_time;
        Date departure_day;
        Date arrival_day;

        try {
            departure_day = dateFormat.parse(departure_day_format);
            arrival_day = dateFormat.parse(arrival_day_format);


        } catch (Exception e) {
            System.out.println("잘못된 형식입니다. yyyymmdd 형식으로 입력해주세요.");
            return null;
        }

        try {
            departure_time = TimeFormat.parse(departure_time_format);
            arrival_time = TimeFormat.parse(arrival_time_format);

        } catch (Exception e) {
            System.out.println("잘못된 형식입니다. HH:mm 형식으로 입력해주세요.");
            return null;
        }

        if (check_in_answer.equals("Y")) { //체크인 Y
            System.out.println(" 체크인 날짜를 입력해주세요 ex) 240401 : ");
            String check_in_day_format = sc.nextLine();
            System.out.println("체크인 시간을 입력해주세요 ex) 15:00 : ");
            String check_in_format = sc.nextLine();
            System.out.println("체크아웃 날짜를 입력해주세요 ex) 240402 :");
            String check_out_day_format = sc.nextLine();
            System.out.println("체크아웃 시간을 입력해주세요 ex) 12:30 : ");
            String check_out_format = sc.nextLine();

            try { //문자열을 date 로 변환
                // Date check_out_day = dateFormat.parse(check_out_day_format);
                // Date check_in_day = dateFormat.parse(check_in_day_format);
                Date check_in = TimeFormat.parse(check_in_format);
                Date check_out = TimeFormat.parse(check_out_format);
                //체크인 시간이 여정 출발 시간 이전인지 and 도착 시간이 체크인 이후인지
                if (check_in.before(departure_time) || check_in.after(arrival_time)) {
                    System.out.println(" 체크인/체크아웃 시간은 여정 출발 시간과 도착 시간 사이여야합니다.");
                    return null;
                }
            } catch (Exception e) {
                System.out.println("잘못된 형식입니다. ");
                return null;
            }
        } else if (check_in_answer.equals("N")) { //체크인 하지 않는다
            return new Itinerary(itinerary_name, departure_place, destination, departure_time, arrival_time);
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

        return new Itinerary(itinerary_name, departure_place, destination, departure_time, arrival_time,
                check_in, check_out);

    }
}
