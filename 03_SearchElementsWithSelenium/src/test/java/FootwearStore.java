/* Задание  3.3
Запишите ещё один тест на позитивный сценарий для сайта магазина обуви.
Примените известные вам техники тест-дизайна при составлении сценария.
Для поиска элементов используйте разные неповторяющиеся стратегии поиска By.

Метод positiveInput()

Задание 1 из урока 3.4
Запишите один тест на негативный сценарий для сайта магазина обуви.

Метод negativeInput()
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FootwearStore {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void positiveInput() {
        driver.findElement(By.name("check")).sendKeys("36");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals("текст не совпадает с ожидаемым", expectedResult, actualResult);
    }

    @Test
    public void negativeInput() {
        driver.findElement(By.name("check")).sendKeys("0");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals("текст не совпадает с ожидаемым", expectedResult, actualResult);
    }

}
