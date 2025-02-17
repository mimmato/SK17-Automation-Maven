package lesson16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class l16_e1_webDriver {
    @Test
    public void webDriverTests() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();


        webDriver.get("http://training.skillo-bg.com:4200/posts/all");
        System.out.println("Current URL is: " + webDriver.getCurrentUrl());

        String title = webDriver.getTitle();
        System.out.println("Page title is: " + title);

        System.out.println("--------------------");
        Thread.sleep (2000);

        webDriver.navigate().to("http://training.skillo-bg.com:4200/users/login");
        System.out.println("Current URL is: " + webDriver.getCurrentUrl());
        System.out.println("Page title is: " + title);

        Thread.sleep (2000);

        System.out.println("Navigating to a url ->");
        webDriver.navigate().to("http://training.skillo-bg.com:4200/posts/all");
        System.out.println("Current URL is: " + webDriver.getCurrentUrl());

        Thread.sleep (2000);

        System.out.println("Going back to previous page ->");
        webDriver.navigate().back();
        System.out.println("Current URL is: " + webDriver.getCurrentUrl());

        System.out.println("--------------------");
//        System.out.println("Current window closed - " +  webDriver.getCurrentUrl());
//        webDriver.close();
        System.out.println("Current window & process closed - " +  webDriver.getCurrentUrl());
        webDriver.quit();
    }



    @Test
    public void closeCurrentWindow(){
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("http://training.skillo-bg.com:4200/posts/all");

        Object[] windowHandles = webDriver.getWindowHandles().toArray();

        openUrlInNewWindow(webDriver, "http://training.skillo-bg.com:4200/users/login");
        webDriver.close();

        webDriver.switchTo().window((String) windowHandles[0]);

        System.out.println(webDriver.getCurrentUrl());
    }

    private void openUrlInNewWindow(ChromeDriver webDriver, String url){
        webDriver.switchTo().newWindow(WindowType.WINDOW);
        webDriver.get(url);
    }
}
