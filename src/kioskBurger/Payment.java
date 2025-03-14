package kioskBurger;

public class Payment {

    public double sumPrice(Cart cart) {
        double tempPrice = 0;

        for(int i=0; i<cart.getCartList().size();i++) {
            tempPrice += cart.getCartList().get(i).getMenuPrice();
        }
        return Math.round(tempPrice*10)/10.0; // 소수점 1번째 까지 나타내기
    }

    public enum Discounts {
        NATIOANL_MERITORIOUS_PERSON("국가유공자", 10),
        SOLDIER("군인", 5),
        STUDENT("학생",3),
        COMMON("일반",0);

        private final String status;
        private final int rate;

        Discounts(String status, int rate) {
            this.status = status;
            this.rate = rate;
        }
        public String getStatus() {
            return this.status;
        }
        public int getRate(){
            return this.rate;
        }
    }
}
