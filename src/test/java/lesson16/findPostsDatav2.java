package lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class findPostsDatav2 {


    @Test
    public void openLink() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://161.35.202.130:3000/posts?take=1000&skip=0");

        String targetUrl = webDriver.getCurrentUrl();
        System.out.println("Current URL is: " + targetUrl);
        System.out.println("------------------");

        List<WebElement> postsUsers = webDriver.findElements(By.id("username"));

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