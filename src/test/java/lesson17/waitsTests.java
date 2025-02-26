package lesson17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;


public class waitsTests {
    private WebDriver webDriver;
    @BeforeSuite
    protected final void setupTestSuite(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest(){
        this.webDriver = new ChromeDriver();
        //this.webDriver = new EdgeDriver();

        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterMethod
    private final void tearDownTest(){
        if (this.webDriver != null) {
            this.webDriver.close();
        }
    }

    @Test
    public void verifyHomeRedirect(){
        this.webDriver.navigate().to("https://www.imot.bg/");

        String urlAfterRedirect = webDriver.getCurrentUrl();
        System.out.println("The current URL is: " + urlAfterRedirect);

        Assert.assertEquals(
                urlAfterRedirect,
                "https://www.imot.bg/pcgi/imot.cgi",
                "The expected URL is https://www.imot.bg/pcgi/imot.cgi, but you got " + urlAfterRedirect
        );

        // wait for cookie window
        WebDriverWait explicitWait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
        WebElement cookieWindow = explicitWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//*[@id='cookiescript_injected']"))));
        System.out.println("Cookie windows is: " + cookieWindow.getText());

        // locate button to accept cookies

        WebElement acceptCookieButton = webDriver.findElement(By.xpath("//*[@id='cookiescript_accept']"));
        System.out.println("The cookie button was found: " + acceptCookieButton.getText());

        // click on Accept

        acceptCookieButton.click();
        System.out.println("Accept cookies button was clicked");

        // refresh the page to reload html after cookie accept
        webDriver.navigate().refresh();
        System.out.println("Page was refreshed!");

        // wait for the entire body to be loaded
//        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        // do a second check for a cookie window. It should NOT be there
        try {
            WebElement newCookieWindowCheck = webDriver.findElement(By.xpath("//*[@id='cookiescript_injected']"));
            System.out.println("Cookie windows is: " + newCookieWindowCheck.getText());
        } catch (NoSuchElementException exception){
            System.out.println("No cookie window was found!");
        }

        // locate Search in nav menu
        WebElement searchButtonMenu = webDriver.findElement(By.xpath("//a[contains(text(), 'Търсене')]"));
        System.out.println("Search menu button is called: " + searchButtonMenu.getText());
        // check if nav menu element matches the expected text
        Assert.assertEquals(
                searchButtonMenu.getText(),
                "Търсене",
                "The String inside your button is not 'Търсене'"
        );
        //click the Search button from nav menu
        searchButtonMenu.click();
        System.out.println("Search button was clicked");
        System.out.println("Redirecting to the Search place...");

        String urlAfterRedirectToSearch = webDriver.getCurrentUrl();
        System.out.println("The current URL is: " + urlAfterRedirectToSearch);

        // locate the 6 boxes for search categories
        System.out.println("The categories assigned to the 6 options are:");
        List<WebElement> sixCategoriesBox = webDriver.findElements(By.xpath("//a[contains(@class, 'search')]"));
        for (WebElement category : sixCategoriesBox){
            System.out.println("class name: " + category.getAttribute("class"));
        }




    }

}
