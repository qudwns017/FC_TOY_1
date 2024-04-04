package src.main.java.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Messages {
    private static final Scanner sc = new Scanner(System.in);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");;
    private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyyMMddHH:mm");;

    static {
        dateFormat.setLenient(false);
        dateTimeFormat.setLenient(false);
    }

    public static void startApp() {
        System.out.println(" _________  ________  ________  ___      ___ _______   ___          ");
        System.out.println("|\\___   ___\\\\   __  \\|\\   __  \\|\\  \\    /  /|\\  ___ \\ |\\  \\         ");
        System.out.println("\\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\  /  / | \\   __/|\\ \\  \\        ");
        System.out.println("     \\ \\  \\ \\ \\   _  _\\ \\   __  \\ \\  \\/  / / \\ \\  \\_|/_\\ \\  \\       ");
        System.out.println("      \\ \\  \\ \\ \\  \\\\  \\\\ \\  \\ \\  \\ \\    / /   \\ \\  \\_|\\ \\ \\  \\____  ");
        System.out.println("       \\ \\__\\ \\ \\__\\\\ _\\\\ \\__\\ \\__\\ \\__/ /     \\ \\_______\\ \\_______\\");
        System.out.println("        \\|__|  \\|__|\\|__|\\|__|\\|__|\\|__|/       \\|_______|\\|_______|");
        System.out.println();
        System.out.println("   #여행 여정을 기록과 관리하는 SNS 서비스#");
        System.out.println("=====================================================");
        System.out.println("(1) 여행기록 | (2) 여정기록 | (3) 여행조회 | (4) 종료");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.print(" 시작할 메뉴 번호를 입력 하고 엔터키를 눌러주세요 : ");
    }

    public static void equal() {
        System.out.println("=====================================================");
    }

    // TODO : promptYesNo 로 메서드명 변경
    public static boolean getYesNoAnswer(String message) {
        while (true) {
            System.out.print(message + " (Y/N) : ");
            String answer = sc.nextLine().toUpperCase();
            if (answer.equals("Y")) return true;
            else if (answer.equals("N")) return false;
            else System.out.println("잘못된 입력입니다. Y/N 형식으로 입력해주세요.");
        }
    }

    public static Date parseDateTime(String message) {
        while (true) {
            try {
                System.out.print(message + " 날짜를 입력해 주세요. (예: 20240401) : ");
                String dateStr = sc.nextLine();

                System.out.print(message + " 시간을 입력해 주세요. (24시간 형식) (예: 13:30) : ");
                String timeStr = sc.nextLine();

                return dateTimeFormat.parse(dateStr + timeStr);
            } catch (ParseException e) {
                System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
            }
        }
    }

    public static Date parseDate(String message) {
        while (true) {
            try {
                System.out.print(message + " 날짜를 입력해 주세요. (예: 20240401) : ");
                String dateStr = sc.nextLine();

                if(dateStr.length() != 8) throw new ParseException("", 0);

                return dateTimeFormat.parse(dateStr);
            } catch (ParseException e) {
                System.out.println("잘못된 형식입니다. 다시 입력해주세요.");
            }
        }
    }
}
