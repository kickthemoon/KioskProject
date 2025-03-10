package kioskBurger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    List<MenuItem> menuItems = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    private int chooseMain;
    private boolean turnOff = false;

    public Kiosk() {
        menuItems.add(new MenuItem("ShackBurger   ",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack    ",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger   ",7.2,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger   ",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void start(){
        do {
            System.out.println("");
            System.out.println("[ SHAKESHACK MENU ]");
            for(int i=0; i<menuItems.size(); i++) {
                System.out.println((i+1)+ ". "+ menuItems.get(i).getMenuName());
            }
            System.out.println("0. 종료");

            try {
                chooseMain = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못 입력 하셨습니다.");
                sc.nextLine();
                continue;
            }

            if (chooseMain < 0 || chooseMain > 4) {
                System.out.println("잘못 입력 하셨습니다.");
            } else {
                if(chooseMain != 0) {
                    while (true) {
                        System.out.println(menuItems.get(chooseMain - 1).getMenuName() + "| W "
                                + menuItems.get(chooseMain - 1).getMenuPrice() + " | "
                                + menuItems.get(chooseMain - 1).getMenuExplanation());

                        System.out.println("0. 뒤로가기");
                        try {
                            if(0 == sc.nextInt()){
                                break;
                            }
                        } catch (Exception e) {
                            sc.nextLine();
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
