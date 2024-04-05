package src.main.java.view;

import java.util.HashMap;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddItineraryView {
    private static final Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHH:mm");

    public HashMap<String, String> getItineraryInfo(HashMap<String, String> trip) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        HashMap<String, String> itinerary = new HashMap<>();

        Messages.equal();
        System.out.println("여정 정보를 추가합니다.");

        System.out.print("여정 출발 장소를 입력해주세요 : ");
        String departurePlace = sc.nextLine();
        itinerary.put("departure_place", departurePlace);

        System.out.print("여정 도착 장소를 입력해주세요 : ");
        String destination = sc.nextLine();
        itinerary.put("destination", destination);

        Date departureDay, arrivalDay;
        try {
            Date startDate = dateFormat.parse(trip.get("start_date"));
            Date endDate = dateFormat.parse(trip.get("end_date"));

            while (true) {
                departureDay = Messages.parseDateTime("여정 출발");
                if (!(dateFormat.format(departureDay).compareTo(dateFormat.format(startDate)) >= 0)) {
                    System.out.println(
                            "* 여정 출발일은 여행 시작일 이후여야 합니다. (여행 시작일 : " + Messages.printFormatDate(startDate)
                                    + ")");
                    continue;
                }
                if (dateFormat.format(departureDay).compareTo(dateFormat.format(endDate)) <= 0) {
                    itinerary.put("departure_day", dateTimeFormat.format(departureDay));
                    break;
                } else {
                    System.out.println(
                            "* 여정 출발일은 여행 종료일 이전이여야 합니다. (여행 종료일 : " + Messages.printFormatDate(endDate)
                                    + ")");
                }
            }

            while (true) {
                arrivalDay = Messages.parseDateTime("여정 도착");
                if (dateFormat.format(arrivalDay).compareTo(dateFormat.format(endDate)) > 0) {
                    System.out.println(
                            "* 여정 도착일은 여행 종료일 이전이여야 합니다. (여행 종료일 : " + Messages.printFormatDate(endDate)
                                    + ")");
                    continue;
                }

                if (arrivalDay.after(departureDay)) {
                    itinerary.put("arrival_day", dateTimeFormat.format(arrivalDay));
                    break;
                } else {
                    System.out.println("* 여정 도착일은 여정 출발일 이후여야 합니다.");
                }
            }

            System.out.println();

            if (Messages.getYesNoAnswer("숙박을 하시나요?")) {
                Date checkInDay, checkOutDay;

                while (true) {
                    checkInDay = Messages.parseDateTime("체크인");
                    if (checkInDay.after(arrivalDay)) {
                        itinerary.put("check_in_day", dateTimeFormat.format(checkInDay));
                        break;
                    } else {
                        System.out.println("* 체크인은 여정 도착 이후여야 합니다.");
                    }
                }

                while (true) {
                    checkOutDay = Messages.parseDateTime("체크아웃");
                    if (checkOutDay.after(checkInDay)) {
                        itinerary.put("check_out_day", dateTimeFormat.format(checkOutDay));
                        break;
                    } else {
                        System.out.println("* 체크아웃은 체크인 이전이여야 합니다.");
                    }
                }
                System.out.println("여정 추가가 완료되었습니다.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itinerary;
    }
}
