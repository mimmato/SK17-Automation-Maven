package lesson14.exercise1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class l14_e1_hardAssertion {

    @Test
    public void testOrderStatusAndPrice() {
        String orderStatus = "processing";
        System.out.println("order status is: " + orderStatus);

        orderStatus = "paid";
        System.out.println("order status is: " + orderStatus);

        Assert.assertEquals(orderStatus, "processing", "Order status is incorrect");

        System.out.println("--------------------");

        double price = 100;
        System.out.println("price is: " + price);

        price = 120;
        System.out.println("price is: " + price);

        Assert.assertEquals(price, 100, "Total price is incorrect");
    }
}

