import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComputerRepair {


    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void positiveInput() {
        var fio = "Иванов Иван Иванович";
        var street = "Ленина";
        var building = "1";
        var flat = "12";
        var date = "31.12.2021";

        var fioLocator = By.cssSelector(".form-input.fio");
        var streetNameLocator = By.cssSelector(".data.form-input");
        var buildingLocator = By.cssSelector(".house");
        var flatLocator = By.cssSelector(".flat");
        var dateLocator = By.cssSelector(".date");
        var buttonLocator = By.cssSelector(".form-submit");
        driver.findElement(fioLocator).sendKeys(fio);
        driver.findElement(streetNameLocator).sendKeys(street);
        driver.findElement(buildingLocator).sendKeys(building);
        driver.findElement(flatLocator).sendKeys(flat);
        driver.findElement(dateLocator).sendKeys(date);
        driver.findElement(buttonLocator).click();
        var overallResult = By.cssSelector(".result");
        var fioResult = By.cssSelector(".show-fio");
        var streetResult = By.cssSelector(".show-street");
        var buildingResult = By.cssSelector(".show-house");
        var flatResult = By.cssSelector(".show-flat");
        var dateResult = By.cssSelector(".show-date");

        Assert.assertTrue("ошибка: не появились результаты", driver.findElement(overallResult).isDisplayed());
        Assert.assertEquals("не совпадает фио", '"' + fio + '"', driver.findElement(fioResult).getText());
        Assert.assertEquals("не совпадает улица", '"' + street + '"', driver.findElement(streetResult).getText());
        Assert.assertEquals("не совпадает дом", '"' + building + '"', driver.findElement(buildingResult).getText());
        Assert.assertEquals("не совпадает квартира", '"' + flat + '"', driver.findElement(flatResult).getText());
        Assert.assertEquals("не совпадает дата", '"' + date + '"', driver.findElement(dateResult).getText());

    }



}
