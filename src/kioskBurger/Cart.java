package kioskBurger;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<MenuItem> cartList = new ArrayList<>();

    // 장바구니 넣기
    public void saveShopCart(MenuItem cartMenuList) {
        cartList.add(cartMenuList);
    }

    // 장바구니 데이터 사본
    public List<MenuItem> getCartList() {
        List<MenuItem> tempCartItems = new ArrayList<>();
        tempCartItems.addAll(cartList);
        return tempCartItems;
    }

    // 장바구니 보여주기
    public void showShopCart() {
        System.out.println("");
        for(int i=0; i<cartList.size();i++) {
            System.out.println("[ "+ cartList.get(i).getMenuCategory() +" ]  "
                    + cartList.get(i).getMenuName() + "| W "
                    + cartList.get(i).getMenuPrice() + " | "
                    + cartList.get(i).getMenuExplanation());
        }
        System.out.println("");
    }

    // 장바구니 지우기
    public void eraseShopCart() {
        cartList.clear();
    }

    // orders 표기 / 미표기
    public void showOrders() {
        if(cartList.size()>0) {
            System.out.println(" [ ORDER MENU ] ");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
    }
}
