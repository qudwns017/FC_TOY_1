package src.main.java.view;

import src.main.java.model.Itinerary;
import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddItineraryView {
    private static final Scanner sc = new Scanner(System.in);

    public Itinerary getItineraryInfo(Trip trip) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Messages.equal();
        System.out.println("여정 정보를 추가합니다.");

        System.out.print("여정 출발 장소를 입력해주세요 :");
        String departurePlace = sc.nextLine();
        System.out.print("여정 도착 장소를 입력해주세요 :");
        String destination = sc.nextLine();

        Date departureDay, arrivalDay;

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

            if (arrivalDay.after(departureDay)) break;
            else System.out.println("* 여정 도착일은 여정 출발일 이후여야 합니다.");
        }

        System.out.println();

        if (Messages.getYesNoAnswer("숙박을 하시나요?")) {
            Date checkInDay, checkOutDay;

            while (true) {
                checkInDay = Messages.parseDateTime("체크인");
                if (checkInDay.after(arrivalDay)) break;
                else System.out.println("* 체크인은 여정 도착 이후여야 합니다.");
            }

            while (true) {
                checkOutDay = Messages.parseDateTime("체크아웃");
                if (checkOutDay.after(checkInDay)) break;
                else System.out.println("* 체크아웃은 체크인 이전이여야 합니다.");
            }
            System.out.println("여정 추가가 완료되었습니다.");
            return new Itinerary(departurePlace, destination, departureDay, arrivalDay,
                    checkInDay, checkOutDay);
        } else {
            System.out.println("여정 추가가 완료되었습니다.");
            return new Itinerary(departurePlace, destination, departureDay, arrivalDay);
        }
    }
}