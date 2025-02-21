package lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class locateFillClick {
    @Test
    public void openLink() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/users/login");
        String targetUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL is: " + targetUrl);

//        Thread.sleep(100);

        Assert.assertEquals(
                targetUrl,
                "http://training.skillo-bg.com:4200/users/login",
                "This URL is incorrect!"
        );

//        String username = System.getenv("TEST_USER");
//        System.out.println(username);
        WebElement userLogin = webDriver.findElement(By.id("defaultLoginFormUsername"));
        System.out.println("Hash to show that the field was found: " + userLogin);
        userLogin.sendKeys("mishm");
        Assert.assertEquals(
                "mishm",
                "mishm",
                "Username is incorrect"
        );

        WebElement passLogin = webDriver.findElement(By.id("defaultLoginFormPassword"));
        System.out.println("Hash to show that the field was found: " + passLogin);
        String correctPassword = "Testing123!";
        passLogin.sendKeys("wrongPassword");
        Assert.assertEquals(
                "wrongPassword",
                "correctPassword",
                "Password is incorrect"
        );

        WebElement signInButton = webDriver.findElement(By.id("sign-in-button"));
        System.out.println("Hash to show that the field was found: " + signInButton);
        System.out.println("String within the button: " + signInButton.getText());
        signInButton.click();


        webDriver.quit();



    }


}
