package src.main.java.view;

import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AddTripView {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static final Scanner sc = new Scanner(System.in);
    private static final Messages messages = new Messages();

    public Trip getTripInfo() { //1.여행 기록
        messages.equal();
        System.out.print("- 여행 이름을 입력해주세요. :");
        String tripName = sc.nextLine();

        Date startDate = messages.parseDate("- 여행 시작");

        while (true) {
            Date endDate = messages.parseDate("- 여행 종료");
            if (dateFormat.format(endDate).compareTo(dateFormat.format(startDate)) >= 0) {
                System.out.println("여행 추가가 완료되었습니다.");
                return new Trip(tripName, startDate, endDate);
            } else {
                System.out.println("여행 종료일이 시작일 이후여야 합니다.");
            }
        }
    }
}
