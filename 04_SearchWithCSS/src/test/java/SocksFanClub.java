import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SocksFanClub {

    private static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        driver = new ChromeDriver();
        // driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html"); добавлено в каждый метод, т.к. меняется URL
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCase1() {
        var email = "@";
        var password = "123";
        var errorMessage = "Некорректный email или пароль";

        var emailLocator = By.name("email");
        var passwordLocator = By.id("password");
        var buttonLocator = By.tagName("button");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();

        var resultLocator = By.className("form-error-password-email");

        Assert.assertTrue("нет сообщения об ошибке", driver.findElement(resultLocator).isDisplayed());
        Assert.assertEquals("сообщение об ошибке некорректное", errorMessage, driver.findElement(resultLocator).getText());
    }

    @Test
    public void testCase2() {
        var email = "@";
        var password = "123";
        var errorMessage = "Некорректный email или пароль";

        var emailLocator = By.cssSelector(".input-data");
        var passwordLocator = By.cssSelector(".password");
        var buttonLocator = By.cssSelector(".form-submit");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();

        var resultLocator = By.cssSelector(".form-error-password-email");

        Assert.assertTrue("нет сообщения об ошибке", driver.findElement(resultLocator).isDisplayed());
        Assert.assertEquals("сообщение об ошибке некорректное", errorMessage, driver.findElement(resultLocator).getText());
    }

    @Test
    public void testCase3() {
        var email = "@";
        var password = "123";
        var errorMessage = "Некорректный email или пароль";

        var emailLocator = By.cssSelector("input.input-data");
        var passwordLocator = By.cssSelector("input.password");
        var buttonLocator = By.cssSelector("button.form-submit");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();

        var resultLocator = By.cssSelector("pre.form-error-password-email");

        Assert.assertTrue("нет сообщения об ошибке", driver.findElement(resultLocator).isDisplayed());
        Assert.assertEquals("сообщение об ошибке некорректное", errorMessage, driver.findElement(resultLocator).getText());
    }

    @Test
    public void testCase4() {
        var email = "@";
        var password = "123";
        var errorMessage = "Некорректный email или пароль";

        var emailLocator = By.cssSelector("#email");
        var passwordLocator = By.cssSelector("#password");
        var buttonLocator = By.cssSelector("#submit");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();

        var resultLocator = By.cssSelector("#error");

        Assert.assertTrue("нет сообщения об ошибке", driver.findElement(resultLocator).isDisplayed());
        Assert.assertEquals("сообщение об ошибке некорректное", errorMessage, driver.findElement(resultLocator).getText());
    }

    @Test
    public void testCase5() {
        var email = "@";
        var password = "123";
        var errorMessage = "Некорректный email или пароль";

        var emailLocator = By.cssSelector("input#email.form-input.input-data");
        var passwordLocator = By.cssSelector("input#password.form-input.password");
        var buttonLocator = By.cssSelector("button#submit.form-submit");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonLocator).click();

        var resultLocator = By.cssSelector("pre#error.form-error-password-email");

        Assert.assertTrue("нет сообщения об ошибке", driver.findElement(resultLocator).isDisplayed());
        Assert.assertEquals("сообщение об ошибке некорректное", errorMessage, driver.findElement(resultLocator).getText());
    }

}

