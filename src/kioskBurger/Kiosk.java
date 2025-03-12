package kioskBurger;

import java.util.Scanner;
import java.util.List;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();

    private int choose;  // 입력값 저장
    private int categoryChoose;  // 카테고리 변경을 막기 위한 입력값 저장
    private boolean turnOff = false;

    public void start(){

        do {
            while (true) {
                // 메인 메뉴 화면
                System.out.println("[ MAIN MENU ] ");
                System.out.println("1. Burgers ");
                System.out.println("2. Drinks");
                System.out.println("3. Desserts");
                System.out.println("0. 종료");

                // 메인 메뉴 숫자외 입력 오류처리
                try {
                    choose = sc.nextInt();
                    categoryChoose = choose;
                    break;
                } catch (Exception e) {
                    System.out.println("잘못 입력 하셨습니다.");
                    sc.nextLine();
                }
            }

            if (choose<0 || choose>3) {
                System.out.println("잘못 입력 하셨습니다."); // 범위 벗어난 숫자 처리
            } else {

                // 0 입력시 종료, 그외 각 카테고리 불러오기
                if(choose != 0) {
                    menu.chooseMenu(choose); // 초이스 값 메뉴클래스로 넘기기
                    List<MenuItem> menuList = menu.getMenuItem();

                    // 버거 음료 디저트 선택 화면 출력
                    while (true) {
                        System.out.println("[ "+ menu.menuCategory(categoryChoose) +" MENU ]");

                        // 배열에 메뉴를 저장
                        for (int i = 0; i < menuList.size(); i++) {
                            System.out.println((i + 1) + ". " + menuList.get(i).getMenuName());
                        }
                        System.out.println("0. 되돌아가기");

                        try {
                            choose = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("잘못 입력 하셨습니다.");
                            sc.nextLine();
                            continue;
                        }

                        // 버거 음료 디저트 선택 작업 처리
                        if (choose < 0 || choose > menuList.size()) {
                            System.out.println("잘못 입력 하셨습니다.");
                        } else {
                            if (choose != 0) {
                                // 배열에 있는 값 보여주기
                                while (true) {
                                    System.out.println("[ "+ menu.menuCategory(categoryChoose) +" ]  "
                                            + menuList.get(choose - 1).getMenuName() + "| W "
                                            + menuList.get(choose - 1).getMenuPrice() + " | "
                                            + menuList.get(choose - 1).getMenuExplanation());
                                    System.out.println("0. 뒤로가기");

                                    try {
                                        if (0 == sc.nextInt()) {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        sc.nextLine();
                                    }
                                }
                            } else {
                                break;
                            }
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
