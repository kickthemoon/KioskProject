package kioskBurger;

public class Payment {
    public double sumPrice(Cart cart) {
        double tempPrice = 0;

        for(int i=0; i<cart.getCartList().size();i++) {
            tempPrice += cart.getCartList().get(i).getMenuPrice();
        }
        return Math.round(tempPrice*10)/10.0; // 소수점 1번째 까지 나타내기
    }
}
