package kioskBurger;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String burgers;
    private String drinks;
    private String desserts;
    private int chooseNum;

    List<MenuItem> menuItems = new ArrayList<>();

    public void setChooseNum(int num) {
        this.chooseNum = num;
    }

    public int getChooseNum() {
        return chooseNum;
    }

    public Menu() {
        // menuBurgers();

        switch (chooseNum) {
            case 1:
                menuBurgers();
                break;
            case 2:
                menuDrigks();
                break;
            case 3:
                menuDesserts();
                break;
            default:
                System.out.println("그런건 존재 하지 않는다!");
        }
    }

    public void menuBurgers() {
        menuItems.add(new MenuItem("ShackBurger   ",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack    ",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger   ",7.2,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger   ",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    public void menuDrigks() {
        menuItems.add(new MenuItem("C0ca-Cola", 1.5, "코카콜라"));
        menuItems.add(new MenuItem("C0ca-Cola Zero", 1.5, "코카콜라 제로"));
        menuItems.add(new MenuItem("Sprite", 1.5, "스프라이트"));
    }

    public void menuDesserts() {
        menuItems.add(new MenuItem("French fries", 2.3, "감자튀김, 케찹 포함"));
        menuItems.add(new MenuItem("Cheese French Fries", 3.3, "치즈 감자튀김"));
        menuItems.add(new MenuItem("Chicken Nuggets", 3.5, "치킨너겟, 케찹 포함"));
        menuItems.add(new MenuItem("Corn salad", 2.4, "콘 샐러드"));
        menuItems.add(new MenuItem("Coleslaw", 2.4, "코울슬로"));
    }
}
