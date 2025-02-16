package lesson14.exercise2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class l14_e2_softAssertion {

    @Test
    public void checkPageElements(){

//        Write a test class to verify the content of a web page. The class should
//include one test to check if the page title, header, and footer are displayed
//        correctly. The test must always check all elements.
//                Hints:
//• Use String to represent page elements
//• Choose your own values when comparing
//• Use Soft assertions

        SoftAssert testSoftAssert = new SoftAssert();

        String title = "My site title";
        String header = "My site header";
        String footer = "My site footer";

        String myPage = "My page is made of: " + title + " ," + header + " ," + footer;

//        testSoftAssert.assertEquals(header, title, "This is not a title!");
//        testSoftAssert.assertEquals(footer, title, "This is not a title!");
//
//        testSoftAssert.assertEquals(title, header, "This is not a header!");
//        testSoftAssert.assertEquals(footer, header, "This is not a header!");
//
//        testSoftAssert.assertEquals(title, footer, "This is not a footer!");
//        testSoftAssert.assertEquals(header, footer, "This is not a footer!");

        testSoftAssert.assertEquals(header, myPage, "This page is missing elements!");

        testSoftAssert.assertAll();

    }
}
