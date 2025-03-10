package kioskBurger;

public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuExplanation;

    public MenuItem(String name, double price, String explan) {
        this.menuName = name;
        this.menuPrice = price;
        this.menuExplanation = explan;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public  String getMenuExplanation() {
        return menuExplanation;
    }
}
