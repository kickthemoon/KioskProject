package kioskBurger;

import java.util.Scanner;
import java.util.List;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    Cart cart = new Cart();

    public void start(){

        boolean turnOff = false;

        do {
            // 메인 메뉴 화면
            System.out.println("[ MAIN MENU ] ");
            System.out.println("1. Burgers ");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("0. 종료");

            cart.showOrders();

            int menuSelect = inputValidInt();

            if (menuSelect>=0 && menuSelect<=5) {
                // 0 입력시 종료, 그외 각 카테고리 불러오기
                if(menuSelect>0 && menuSelect<=3) {
                    menu.setSelectNum(menuSelect);
                    menu.makeListMenu(menuSelect); // 선택한 값을 메뉴클래스로 넘기기

                    List<MenuItem> menuList = menu.getMenuItem();

                    // 버거 음료 디저트 선택 화면 출력
                    while (true) {
                        System.out.println("[ "+ menuList.get(menuSelect - 1).getMenuCategory() +" MENU ]");

                        // 배열에 메뉴를 저장
                        for (int i = 0; i < menuList.size(); i++) {
                            System.out.println((i + 1) + ". " + menuList.get(i).getMenuName());
                        }
                        System.out.println("0. 되돌아가기");

                        int menuItemSelect = inputValidInt();

                        // 버거 음료 디저트 선택 작업 처리
                        if (menuItemSelect >= 0 && menuItemSelect <= menuList.size()) {
                            if (menuItemSelect != 0) {
                                // 배열에 있는 값 보여주기
                                while (true) {
                                    System.out.println("[ "+ menuList.get(menuItemSelect - 1).getMenuCategory() +" ]  "
                                            + menuList.get(menuItemSelect - 1).getMenuName() + "| W "
                                            + menuList.get(menuItemSelect - 1).getMenuPrice() + " | "
                                            + menuList.get(menuItemSelect - 1).getMenuExplanation());
                                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                    System.out.println("1. 추가하기            0. 뒤로가기");

                                    int cartSelect = inputValidInt();

                                    if (cartSelect == 0) {
                                        break;
                                    } else if(cartSelect == 1) {
                                        cart.saveShopCart(menuList.get(cartSelect - 1));
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
                } else if(menuSelect>3 && menuSelect<=5){
                    if(cart.getCartList().size()>0) {

                        switch (menuSelect) {
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
                    turnOff=true; // 메인 화면에서 0 입력 받으면 프로그램 종료
                }
            }
        } while (!turnOff);
    }
    // 예외처리 코드
    public int inputValidInt() {
        int select = 0;

        while (true) {
            try {
                select = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("잘못 입력하였습니다.");
            }
        }
        return select;
    }
}
