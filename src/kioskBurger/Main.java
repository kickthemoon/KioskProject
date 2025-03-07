package kioskBurger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int chooseMain;
        boolean turnOff = false;

        do {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1. ShackBurger");
            System.out.println("2. SmokeShack");
            System.out.println("3. Cheeseburger");
            System.out.println("4. Hamburger");
            System.out.println("0. 종료");

            chooseMain = sc.nextInt();

            if (chooseMain < 0 || chooseMain > 5) {
                System.out.println("잘못 입력 하셨습니다.");
            } else {
                switch (chooseMain) {
                    case 1 :
                        System.out.println("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
                        break;
                    case 2 :
                        System.out.println("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
                        break;
                    case 3 :
                        System.out.println("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
                        break;
                    case 4 :
                        System.out.println("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
                        break;
                    case 0 :
                        System.out.println("키오스크를 종료합니다.");
                        turnOff=true;
                }
            }
        } while (!turnOff);
    }
}