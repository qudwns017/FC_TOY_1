package src.main.java.view;

import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
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
}
