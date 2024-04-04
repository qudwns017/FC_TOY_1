package src.main.java.view;

import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddTripView {

    Messages messages = new Messages();
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat TimeFormat = new SimpleDateFormat("yyyyMMddhh:mm");

    public Trip getTripInfo() { //1.여행 기록
        messages.equal();
        System.out.print("- 여행 이름을 입력해주세요. :");
        String tripName = sc.nextLine();

        String startDateFormat;
        String endDateFormat;

        while (true) {
            System.out.print("- 시작 날짜를 입력해주세요. ex) 20240401 :");
            String startDate = sc.nextLine();
            if (startDate.length() == 8) {
                startDateFormat = startDate;
                break;
            } else {
                System.out.println("잘못된 형식입니다. yyyymmdd 형식으로 입력해주세요");
            }
        }

        while (true) {
            System.out.print("- 종료 날자를 입력해주세요. ex) 20240403 :");
            String endDate = sc.nextLine();
            if (endDate.length() == 8) {
                endDateFormat = endDate;
                break;
            } else {
                System.out.println("잘못된 형식입니다. yyyymmdd 형식으로 입력해주세요");
            }
        }

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
}
