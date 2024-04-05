package src.main.java.view;

import src.main.java.model.Trip;
import src.main.java.utils.Messages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AddTripView {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    private static final Scanner sc = new Scanner(System.in);

    public HashMap<String, String> getTripInfo() { //1.여행 기록
        Messages.equal();
        HashMap<String, String> trip = new HashMap<>();
        System.out.print("- 여행 이름을 입력해주세요. : ");
        String tripName = sc.nextLine();
        trip.put("trip_name", tripName);

        Date startDate = Messages.parseDate("- 여행 시작");
        trip.put("start_date", dateFormat.format(startDate));

        while (true) {
            Date endDate = Messages.parseDate("- 여행 종료");
            if (dateFormat.format(endDate).compareTo(dateFormat.format(startDate)) >= 0) {
                trip.put("end_date", dateFormat.format(startDate));
                System.out.println("여행 추가가 완료되었습니다.");
                return trip;
            } else {
                System.out.println("여행 종료일이 시작일 이후여야 합니다.");
            }
        }
    }
}
