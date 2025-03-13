package kioskBurger;

public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuExplanation;
    private String menuCategory;

    public MenuItem(String name, double price, String explan, String category) {
        this.menuName = name;
        this.menuPrice = price;
        this.menuExplanation = explan;
        this.menuCategory = category;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public String getMenuExplanation() {
        return menuExplanation;
    }

    public String getMenuCategory () {
        return menuCategory;
    }
}
