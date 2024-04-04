package src.main.java.view;

import src.main.java.model.Itinerary;
import src.main.java.utils.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddItineraryView {
    private static final Scanner sc = new Scanner(System.in);

    public static Itinerary getItineraryInfo() {
        Messages.equal();
        System.out.println("여정 정보를 추가합니다.");

        System.out.print("여정 출발 장소를 입력해주세요 :");
        String departurePlace = sc.nextLine();
        System.out.print("여정 도착 장소를 입력해주세요 :");
        String destination = sc.nextLine();

        Date departureDay, arrivalDay;

        // TODO : 여행 날짜도 비교 필요
        departureDay = Messages.parseDateTime("여정 출발");
        while (true) {
            arrivalDay = Messages.parseDateTime("여정 도착");
            if (arrivalDay.after(departureDay)) break;
            else System.out.println("여정 도착일이 출발일 이후여야 합니다.");
        }

        System.out.println();

        if (Messages.getYesNoAnswer("숙박을 하시나요?")) {
            Date checkInDay, checkOutDay;

            while (true) {
                checkInDay = Messages.parseDateTime("체크인");
                if (checkInDay.after(arrivalDay)) break;
                else System.out.println("체크인은 여정 도착 이후여야 합니다.");
            }

            while (true) {
                checkOutDay = Messages.parseDateTime("체크아웃");
                if (checkOutDay.after(checkInDay)) break;
                else System.out.println("체크아웃은 체크인 이전이여야 합니다.");
            }

            return new Itinerary(departurePlace, destination, departureDay, arrivalDay,
                    checkInDay, checkOutDay);
        } else {
            return new Itinerary(departurePlace, destination, departureDay, arrivalDay);
        }
    }
}