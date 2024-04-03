package src.main.java.view;

import src.main.java.model.Itinerary;
import src.main.java.utils.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddItineraryView {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddhh:mm");
    private static final Scanner sc = new Scanner(System.in);
    private  static final Messages messages = new Messages();

    public static Itinerary getItineraryInfo() {
        messages.equal();
        System.out.println("여정 정보를 추가합니다.");

        System.out.print("여정 출발 장소를 입력해주세요 :");
        String departurePlace = sc.nextLine();
        System.out.print("여정 도착 장소를 입력해주세요 :");
        String destination = sc.nextLine();

        Date departureDay, arrivalDay;

        // TODO : 여행 날짜도 비교해야함
        departureDay = parseDateTime("여정 출발");
        while(true) {
            arrivalDay = parseDateTime("여정 도착");
            // 출발 < 도착
            if (arrivalDay.after(departureDay)) break;
            else System.out.println("여정 도착일이 출발일 이후여야 합니다.");
        }

        System.out.println();

        if (getYesNoAnswer("숙박을 하시나요?")) {
            Date checkInDay, checkOutDay;

            while (true) {
                checkInDay = parseDateTime("체크인");
                // 도착일 < 체크인 ?
                if (checkInDay.after(arrivalDay)) break;
                else System.out.println("체크인은 여정 도착 이후여야 합니다.");
            }

            while (true) {
                checkOutDay = parseDateTime("체크아웃");
                // 체크인 < 체크아웃 ?
                if (checkOutDay.after(checkInDay)) break;
                else System.out.println("체크아웃은 체크인 이전이여야 합니다.");
            }

            return new Itinerary(departurePlace, destination, departureDay, arrivalDay,
                    checkInDay, checkOutDay);
        } else {
            return new Itinerary(departurePlace, destination, departureDay, arrivalDay);
        }
    }

    private static boolean getYesNoAnswer(String message) {
        while (true) {
            System.out.print(message + " (Y/N) : ");
            String answer = sc.nextLine().toUpperCase();
            if (answer.equals("Y")) return true;
            else if (answer.equals("N")) return false;
            else System.out.println("잘못된 입력입니다. Y/N 형식으로 입력해주세요.");
        }
    }

    private static Date parseDateTime(String message) {
        while (true) {
            try {
                System.out.print(message + " 날짜를 입력해 주세요. ex) 20240401 : ");
                String dateStr = sc.nextLine();

                System.out.print(message + " 시간을 입력해 주세요. ex) 13:30 : ");
                String timeStr = sc.nextLine();

                return dateTimeFormat.parse(dateStr + timeStr);
            } catch (ParseException e) {
                System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
            }
        }
    }
}
