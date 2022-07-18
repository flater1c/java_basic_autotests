/* Задания  3.2 - 3.3

3.2: Добавьте два новых браузерных теста для сайта-регистрации в онлайн-кинотеатре, осуществляя поиск элементов по их атрибуту name, а в случае его отсутствия — по классу
Методы positiveInput() и emptyInput()
3.3: Повторите действия из этого урока для сайта онлайн-кинотеатра:
создайте тест, который переходит на сайт, ищет поля Email, «Пароль» и «Подтверждение пароля».
Метод testLocators()
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineCinema {

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
    public void positiveInput() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Иванов Иван Иванович");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void emptyInput() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-error")).getText();
        var expectedResult = "Введите имя";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testLocators() {
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var passwordElement = driver.findElement(By.id("password"));
        var confirmPasswordElement = driver.findElement(By.name("confirm_password"));
    }


}
