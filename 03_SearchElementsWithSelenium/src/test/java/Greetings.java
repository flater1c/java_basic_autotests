/* Задание из урока 3.2
В первом уроке мы разбирали пять браузерных тестов на сайте-приветствии с тремя полями ввода и кнопкой.
Вынесите в этих тестах в setUp- и tearDown-методы подготовительную работу по настройке драйвера, открытию и закрытию браузера.
*/

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Greetings {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPositiveInput() {
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
    }

    @Test
    public void testEmptyInput() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoName() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("ivan@ivanov.ru");
        driver.findElement(By.name("phone")).sendKeys("+79876543215");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (ivan@ivanov.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79876543215.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoEmail() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("phone")).sendKeys("+79876543215");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: +79876543215.";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testNoPhone() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("ivan@ivanov.ru");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Иванов Иван Иванович.\n" +
                "На вашу почту (ivan@ivanov.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
    }

}
