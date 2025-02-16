package lesson14.exercise2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class l14_e2_softAssertion {

    @Test
    public void checkPageElements(){

        SoftAssert testSoftAssert = new SoftAssert();

        String title = "My site title";
        String header = "My site header";
        String footer = "My site footer";


        testSoftAssert.assertEquals(title, footer, "This is not a footer!");

        testSoftAssert.assertEquals(title, title, "This is not a title!");

        testSoftAssert.assertEquals(title, header, "This is not a header!");

        testSoftAssert.assertAll();

    }
}
