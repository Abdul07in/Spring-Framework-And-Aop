package aopdemo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status) {
//        Logging , Authentication , Authorization , Sanitize Data
        System.out.println("Checkout method from shopping cart : " + status);
    }

    public int getQuantity() {
        return 2;
    }
}
