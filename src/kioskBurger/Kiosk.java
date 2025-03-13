package kioskBurger;

import java.util.Scanner;
import java.util.List;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    Cart cart = new Cart();

    private int choose;
    private int tempChoose;
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

                cart.showOrders();

                // 메인 메뉴 숫자외 입력 오류처리
                try {
                    choose = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("잘못 입력 하셨습니다.");
                    sc.nextLine();
                }
            }

            if (choose>=0 && choose<=5) {
                // 0 입력시 종료, 그외 각 카테고리 불러오기
                if(choose>0 && choose<=3) {
                    menu.setChooseNum(choose);
                    menu.makeListMenu(choose); // 초이스 값 메뉴클래스로 넘기기

                    List<MenuItem> menuList = menu.getMenuItem();

                    // 버거 음료 디저트 선택 화면 출력
                    while (true) {
                        System.out.println("[ "+ menuList.get(choose - 1).getMenuCategory() +" MENU ]");

                        // 배열에 메뉴를 저장
                        for (int i = 0; i < menuList.size(); i++) {
                            System.out.println((i + 1) + ". " + menuList.get(i).getMenuName());
                        }
                        System.out.println("0. 되돌아가기");

                        try {
                            choose = sc.nextInt();
                        } catch (Exception e) {
                            sc.nextLine();
                            continue;
                        }

                        // 버거 음료 디저트 선택 작업 처리
                        if (choose >= 0 && choose <= menuList.size()) {
                            if (choose != 0) {
                                // 배열에 있는 값 보여주기
                                while (true) {
                                    System.out.println("[ "+ menuList.get(choose - 1).getMenuCategory() +" ]  "
                                            + menuList.get(choose - 1).getMenuName() + "| W "
                                            + menuList.get(choose - 1).getMenuPrice() + " | "
                                            + menuList.get(choose - 1).getMenuExplanation());
                                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                    System.out.println("1. 추가하기            0. 뒤로가기");

                                    try {
                                        tempChoose = sc.nextInt();
                                    } catch (Exception e) {
                                        sc.nextLine();
                                        continue;
                                    }

                                    if (tempChoose != 1) {
                                        break;
                                    } else {
                                        cart.saveShopCart(menuList.get(choose - 1));
                                        System.out.println("장바구니에 담았습니다.");
                                        System.out.println("");
                                        break;
                                    }
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } else if(choose>3 && choose<=5){
                    if(cart.getCartList().size()>0) {

                        switch (choose) {
                            case 4:
                                System.out.println("아래와 같이 주문 하시겠습니까?");
                                System.out.println("");
                                System.out.println("[ Orders ]");
                                cart.showShopCart();
                                System.out.println("[ Total ]");
                                System.out.println("W "+cart.sumPrice());
                                System.out.println("");
                                System.out.println("1. 주문         2. 메뉴판");
                                break;
                            case  5:
                                System.out.println("장바구니 지우기");
                                cart.eraseShopCart();
                                break;
                        }
                    } else {
                        System.out.println("잘못 입력 하셨습니다."); // 장바구니가 없을때 실행.
                    }
                } else {
                    System.out.println("키오스크를 종료합니다.");
                    turnOff=true;
                }
            }
        } while (!turnOff);
    }
}
