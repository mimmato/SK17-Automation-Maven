package lesson14.exercise3;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class l14_e3_hardAssertion_dataProvider {

    @DataProvider(name = "testData")
    public Object[][] createData() {
        return new Object[][]{
                {"paid", "paid", 130, 130},
                {"processing", "processing", 80, 80},
                {"shipped", "delivered", 150, 200},
                {"delivered", "delivered", 150, 200}
        };
    }

    @Test(dataProvider = "testData")
    public void testOrderStatusAndPrice(String actualStatus, String expectedStatus, double actualPrice, double expectedPrice) {
        Assert.assertEquals(actualStatus, expectedStatus, "Order status is incorrect");
        Assert.assertEquals(actualPrice, expectedPrice, "Total price is incorrect");
    }
}



