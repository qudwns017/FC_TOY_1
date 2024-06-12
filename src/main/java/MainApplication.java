package src.main.java;

import src.main.java.view.MainView;

public class MainApplication {
    public static void main(String[] args) {
        MainView mainView = new MainView();

        while(true){
            int num = mainView.sendCase();
            switch (num) {
                case 1 -> mainView.addTrips();
                case 2 -> mainView.addItineraries();
                case 3 -> mainView.showItineraries();
                case 4 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. ");
            }
        }
    }
}