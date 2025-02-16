package lesson14.exercise3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class l14_e3_softAssertion_dataProvider {

    @DataProvider(name = "testData")
    public Object[][] createData() {
        return new Object[][]{
                {"Actual title", "Expected title", "Actual header", "Expected header",
                        "Actual footer", "Expected footer"}
                ,

                {"Expected title", "Expected title", "Expected header", "Expected header",
                        "Expected footer", "Expected footer"}
        };
    }

    @Test(dataProvider = "testData")
    public void checkPageElements(String actualTitle, String expectedTitle, String actualHeader,
                                  String expectedHeader, String actualFooter, String expectedFooter){

        SoftAssert testSoftAssert = new SoftAssert();

        testSoftAssert.assertEquals(actualTitle, expectedTitle, "This is not a title!");

        testSoftAssert.assertEquals(actualHeader, expectedHeader, "This is not a header!");

        testSoftAssert.assertEquals(actualFooter, expectedFooter, "This is not a footer!");

//        System.out.println("Actual: " + actualTitle + " " + actualHeader + " " + actualFooter);
//        System.out.println("Expected: " + actualTitle + " " + actualHeader + " " + actualFooter);

        testSoftAssert.assertAll();

    }
}
