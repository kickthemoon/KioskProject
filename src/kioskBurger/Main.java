package kioskBurger;

public class Main {
    public static void main(String[] args) {

        Kiosk kiosk = new Kiosk();
        Menu menu = new Menu();

        kiosk.start(menu.menuItems);

    }
}