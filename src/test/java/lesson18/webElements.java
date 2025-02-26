package lesson18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class webElements {

    private WebDriver webDriver;

    @BeforeSuite
    protected final void setupTestSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    protected final void setUpTest() {
        this.webDriver = new ChromeDriver();
        //this.webDriver = new EdgeDriver();

        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    private final void tearDownTest() {
        if (this.webDriver != null) {
            this.webDriver.close();
        }
    }

    // https://www.imot.bg/pcgi/imot.cgi?act=2&rub=1
    //checkboxes on that page
    @Test
    public void checkBox() {
        this.webDriver.get("https://www.imot.bg/pcgi/imot.cgi?act=2&rub=1");
        String currentURL = this.webDriver.getCurrentUrl();
        System.out.println("The current URL is: " + currentURL);

        WebElement checkbox1Room = webDriver.findElement(By.xpath("//label[./input[@id='vi1']]"));
        String checkboxLabel = checkbox1Room.getText();
        System.out.println("Text of checkbox: " + checkboxLabel);
        Assert.assertEquals(checkboxLabel, "1-СТАЕН", "The checkbox label is incorrect");

        System.out.println("First click on checkbox.");
        checkbox1Room.click();

        //First click. Verify that the box is checked
        WebElement isCheckedOrNotChecked = this.webDriver.findElement(
                (By.xpath("//label[./input[@id='vi1']]/input")));
        Assert.assertTrue(isCheckedOrNotChecked.isSelected(), "Checkbox IS NOT selected");

        //Second click
        System.out.println("Second click on checkbox.");
        checkbox1Room.click();
        Assert.assertFalse(isCheckedOrNotChecked.isSelected(), "Checkbox IS selected");
    }

    // https://www.imot.bg/pcgi/imot.cgi?act=26
    // radio where fields cannot be used before an option is checked
    @Test
    public void testRadioButton() {

        this.webDriver.get("https://www.imot.bg/pcgi/imot.cgi?act=26");
        String currentURL = this.webDriver.getCurrentUrl();
        System.out.println("The current URL is: " + currentURL);

        WebElement radioButton1Label = webDriver.findElement(By.xpath("//label[./input[@type='radio' and @value='1']]"));
        String radioButtonLabel = radioButton1Label.getText();
        System.out.println("Text of radio button: " + radioButtonLabel);
        Assert.assertEquals(radioButtonLabel, "За агенции", "The radio button label is incorrect!");

        // locating by input instead of label
        WebElement radioButton1Input = webDriver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
        System.out.println("First click on radio button1.");
        radioButton1Input.click();
        Assert.assertTrue(radioButton1Input.isSelected(), "The radio button IS NOT selected");

        // locating another radio button
        WebElement radioButton2 = webDriver.findElement(By.xpath("//label[./input[@type='radio' and @value='2']]"));
        radioButtonLabel = radioButton2.getText();
        System.out.println("Text of radio button2: " + radioButtonLabel);
        Assert.assertEquals(radioButtonLabel, "За частни лица", "The radio button label is incorrect!");

        System.out.println("First click on radio button2");
        radioButton2.click();

        Assert.assertFalse(radioButton2.isSelected(), "Radio button 2 IS NOT selected");

        System.out.println("Second click on radio button1");
        radioButton1Input.click();
//        WebDriverWait explicitWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
//        explicitWait.until(ExpectedConditions.elementToBeSelected(radioButton1Label));
//        radioButton1Input.click();
//        Assert.assertFalse(radioButton1Input.isSelected(), "The radio button IS NOT selected");
        Assert.assertTrue(radioButton1Input.isSelected(), "Radio button 1 IS NOT selected");
        Assert.assertFalse(radioButton2.isSelected(), "Radio button 2 IS selected");
    }

    // https://www.imot.bg/pcgi/imot.cgi?act=2&rub=1
    // dropdown/select on that page
    @Test
    public void testDropDown() {
        this.webDriver.get("https://www.imot.bg/pcgi/imot.cgi?act=2&rub=1");
        String currentURL = this.webDriver.getCurrentUrl();
        System.out.println("The current URL is: " + currentURL);

        Select dropDown = new Select(this.webDriver.findElement(By.xpath("//select[@class='sw260']")));
        List<WebElement> dropDownOptions = dropDown.getOptions();

        for (WebElement option : dropDownOptions) {
            System.out.println("option: " + option.getText());
        }

        System.out.println("Check if the first selected option in the dropdown is correct");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Вид/Район/Цена", "This is not the first option in the dropdown");

        System.out.println("selecting the first option");
        dropDown.selectByIndex(0);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Вид/Район/Цена");

        System.out.println("selecting the third option");
        dropDown.selectByContainsVisibleText("Цена");
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(), "Цена");
    }

    // https://www.imot.bg/pcgi/imot.cgi?act=14
    // tables on that page

    @Test
    public void testTables() {
        this.webDriver.get("https://www.imot.bg/pcgi/imot.cgi?act=14");
        String currentURL = this.webDriver.getCurrentUrl();
        System.out.println("The current URL is: " + currentURL);

//        WebElement table = this.webDriver.findElement(By.xpath("//table[@id='tableStats']"));
//        System.out.println(table.getText()); // see the entire table contents

        //locate ALL header/column names
        List<WebElement> tableHeaders = this.webDriver.findElements(By.xpath("//td[@class='tabStatHead']"));
        for (WebElement headerElement : tableHeaders) {
            System.out.println("Column name: " + headerElement.getText());
        }

        System.out.println("------------------------------------");
        WebElement firstColumnName = this.webDriver.findElement(By.xpath("//td[@class='tabStatHead'][1]"));
        System.out.println("The first column is: " + firstColumnName.getText());
        WebElement lastColumnName = this.webDriver.findElement(By.xpath("//td[@class='tabStatHead'][last()]"));
        System.out.println("The last column is: " + lastColumnName.getText());
        System.out.println("------------------------------------");

        int columnIndex = 0;

        for (int i = 0; i < tableHeaders.size(); i++) {
            if (tableHeaders.get(i).getText().equals("ДВУСТАЙНИ")) {
                columnIndex = i + 1;
                break;
            }
        }
        Assert.assertNotEquals(columnIndex, 0, "Header 'ДВУСТАЙНИ' was not found!");
        System.out.println("Column 'ДВУСТАЙНИ' is at index: " + columnIndex);
        System.out.println("------------------------------------");

        List<WebElement> tableRows = this.webDriver.findElements(By.xpath("//table[@id='tableStats']//tr[position() > 1]"));
        for (WebElement row : tableRows) {
//            System.out.println(row.getText());
//            System.out.println(row.getText());

            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (cells.size() >= columnIndex) {
                String cellValue = cells.get(columnIndex - 1).findElement(By.xpath("//td//a//b")).getText();
                // Use columnIndex - 1 for 0-based indexing
                System.out.println("Value in column 'ДВУСТАЙНИ': " + cellValue);
            }

//        System.out.println(tableRows.getFirst());


        }
    }
}


    //https://www.imot.bg/pcgi/imot.cgi
    // locate cookie icon and select option from popup
    //https://www.imot.bg/pcgi/imot.cgi
    // click on language icon for another popup

