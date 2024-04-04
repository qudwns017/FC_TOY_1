package src.main.java.view;

import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddItineraryView {
    // private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddhh:mm");
    private static final Scanner sc = new Scanner(System.in);
    private static final Messages messages = new Messages();

<<<<<<< HEAD
    public static Itinerary getItineraryInfo(Trip trip) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Messages.equal();
=======
    public static Itinerary getItineraryInfo() {
        messages.equal();
>>>>>>> 5a0ab34c45765814a0ea6a8932c1b6544a3df423
        System.out.println("여정 정보를 추가합니다.");

        System.out.print("여정 출발 장소를 입력해주세요 :");
        String departurePlace = sc.nextLine();
        System.out.print("여정 도착 장소를 입력해주세요 :");
        String destination = sc.nextLine();

        Date departureDay, arrivalDay;

<<<<<<< HEAD
        while (true) {
            departureDay = Messages.parseDateTime("여정 출발");
            if (dateFormat.format(departureDay).compareTo(dateFormat.format(trip.getStartDate())) >= 0) break;
            else System.out.println("* 여정 출발일은 여행 시작일 이후여야 합니다. (여행 시작일 : " + dateFormat.format(trip.getStartDate()) + ")");
        }

        while (true) {
            arrivalDay = Messages.parseDateTime("여정 도착");
            if(dateFormat.format(arrivalDay).compareTo(dateFormat.format(trip.getEndDate())) > 0) {
                System.out.println("* 여정 도착일은 여행 종료일 이전이여야 합니다. (여행 종료일 : " + dateFormat.format(trip.getEndDate()) + ")" );
                continue;
            }

=======
        // TODO : 여행 날짜도 비교 필요
        departureDay = parseDateTime("여정 출발");
        while (true) {
            arrivalDay = parseDateTime("여정 도착");
>>>>>>> 5a0ab34c45765814a0ea6a8932c1b6544a3df423
            if (arrivalDay.after(departureDay)) break;
            else System.out.println("* 여정 도착일은 여정 출발일 이후여야 합니다.");
        }

        System.out.println();

        if (getYesNoAnswer("숙박을 하시나요?")) {
            Date checkInDay, checkOutDay;

            while (true) {
                checkInDay = parseDateTime("체크인");
                if (checkInDay.after(arrivalDay)) break;
                else System.out.println("* 체크인은 여정 도착 이후여야 합니다.");
            }

            while (true) {
                checkOutDay = parseDateTime("체크아웃");
                if (checkOutDay.after(checkInDay)) break;
                else System.out.println("* 체크아웃은 체크인 이전이여야 합니다.");
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