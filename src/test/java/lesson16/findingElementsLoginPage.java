package lesson16;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

public class findingElementsLoginPage {

    @Test
    public void findTextFields() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/users/login");

        WebElement textFields = webDriver.findElement(By.xpath("//input[@formcontrolname]"));
        System.out.println(textFields);

        webDriver.quit();
    }

    @Test
    public void findTextFields2() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/users/login");

        List<WebElement> textFields = webDriver.findElements(By.xpath("//input[@formcontrolname]"));
        for (WebElement i : textFields) {
            System.out.println(i);
        }

        webDriver.quit();

    }

    @Test
    public void findTextFields3() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/users/login");

        List<WebElement> textFieldsAttributes = webDriver.findElements(By.xpath("//input[@formcontrolname]"));
        for (WebElement field : textFieldsAttributes) {
            System.out.println("getAccessibleName: " + field.getAccessibleName());
            System.out.println("-------------");
            System.out.println("getAriaRole: " + field.getAriaRole());
            System.out.println("-------------");
            System.out.println("getDomAttribute: " + field.getDomAttribute(""));
            System.out.println("-------------");
            System.out.println("getAttribute: " + field.getAttribute("type"));
            System.out.println("-------------");
            System.out.println("getLocation: " + field.getLocation());

        }

        webDriver.quit();

    }

    @Test
    public void findTextAlerts() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://training.skillo-bg.com:4200/users/login");
        webDriver.quit();

    }
}


