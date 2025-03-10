package kioskBurger;

import java.util.Scanner;

public class Kiosk {

    Scanner sc = new Scanner(System.in);

    private int choose;
    private boolean turnOff = false;

    public void start(Menu menu){

        do {

            // 메인 메뉴 화면
            System.out.println("[ MAIN MENU ] ");
            System.out.println("1. Burgers ");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료");

            // 메인 메뉴 숫자외 입력 오류처리
            try {
                choose = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못 입력 하셨습니다.");
                sc.nextLine();
            }

            if (choose<0 || choose>3) {
                System.out.println("잘못 입력 하셨습니다."); // 범위 벗어난 숫자 처리
            } else {

                // 0 입력시 종료, 그외 각 카테고리 불러오기
                if(choose != 0) {
                    menu.switchMenu(choose); // 초이스 값 메뉴클래스로 넘기기
                    // 카테고리 메뉴 보여주기
                    while (true) {

                        System.out.println("[ BURGERS MENU ]");

                        for (int i = 0; i < menu.menuItems.size(); i++) {
                            System.out.println((i + 1) + ". " + menu.menuItems.get(i).getMenuName());
                        }
                        System.out.println("0. 되돌아가기");

                        try {
                            choose = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("잘못 입력 하셨습니다.");
                            sc.nextLine();
                            continue;
                        }

                        if (choose < 0 || choose > menu.menuItems.size()) {
                            System.out.println("잘못 입력 하셨습니다.");
                        } else {
                            if (choose != 0) {
                                // 배열에 있는 값 보여주기
                                while (true) {
                                    System.out.println(menu.menuItems.get(choose - 1).getMenuName() + "| W "
                                            + menu.menuItems.get(choose - 1).getMenuPrice() + " | "
                                            + menu.menuItems.get(choose - 1).getMenuExplanation());
                                    System.out.println("0. 뒤로가기");

                                    try {
                                        if (0 == sc.nextInt()) {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        sc.nextLine();
                                    }
                                }
                            } else break;
                        }
                    }
                } else {
                    System.out.println("키오스크를 종료합니다.");
                    turnOff=true;
                }
            }

        } while (!turnOff);
    }
}
