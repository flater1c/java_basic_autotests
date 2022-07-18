/* Задание 4 из урока 2.4
Что нужно сделать

Это задание выполните по желанию. Для усложнённой версии сайта-приветствия напишите не менее пяти браузерных тестов с использованием JUnit и Selenium WebDriver,
применяя привычные вам техники тест-дизайна.
*/

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Greetings {
    @Test
    public void testPositiveInput() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan@ivanov.ru");
        driver.findElement(By.name("phone")).sendKeys("+79876543215");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan@ivanov.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79876543215.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void testEmptyInput() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void testNoName() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("ivan@ivanov.ru");
        driver.findElement(By.name("phone")).sendKeys("+79876543215");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (ivan@ivanov.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79876543215.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void testNoEmail() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("phone")).sendKeys("+79876543215");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79876543215.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void testNoPhone() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan@ivanov.ru");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan@ivanov.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

}
