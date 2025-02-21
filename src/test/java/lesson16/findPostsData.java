package lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class findPostsData {
    @Test
    public void openLink() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-javascript");

        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");

        JavascriptExecutor js = webDriver;
        String userAgent = (String) js.executeScript("return navigator.userAgent;");

        System.out.println("User Agent: " + userAgent);

        String targetUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL is: " + targetUrl);
        System.out.println("------------------");

        //scrolling

//        for (int i = 0; i < 10; i++) {
//            webDriver.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//            Thread.sleep(2000);
//        }

//        WebElement body = webDriver.findElement(By.tagName("body"));
//        body.sendKeys(Keys.PAGE_DOWN);
//
//        for (int i = 0; i < 5; i++) {
//            body.sendKeys(Keys.PAGE_DOWN);
//            Thread.sleep(1000);


//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        List<WebElement> postsUsers = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='post-user']")));

            Thread.sleep(3000);

            List<WebElement> postsUsers = webDriver.findElements(By.xpath("//a[@class='post-user']"));


            System.out.println("Number of elements found: " + postsUsers.size());
            if (!postsUsers.isEmpty()) {
                for (WebElement postData : postsUsers) {
                    System.out.println("post data - Users: " + postData.getText());
                }
            } else {
                System.out.println("No posts found with the specified XPath.");
            }

        }
    }

