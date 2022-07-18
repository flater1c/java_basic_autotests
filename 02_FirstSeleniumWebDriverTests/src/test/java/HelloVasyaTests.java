/* Задания 2-3 из урока 2.4
Задание 2. Приветствие Васи на простом сайте-приветствии

Что нужно сделать

Повторите действия из прошлого урока для сайта-приветствия: создайте тест, который вводит имя «Вася» и получает текст «Привет, Вася!».

Задание 3. Пустое значение имени на простом сайте-приветствии

Что нужно сделать

Запишите ещё один тест для этого же сайта, который бы:

    открывал браузер;
    переходил на сайт-приветствие;
    сразу же кликал по кнопке «Ввод»;
    проверял полученный текст приветствия;
    закрывал браузер.
*/

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloVasyaTests {

    @Test
    public void testHelloVasya() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, Вася!";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    @Test
    public void testEmptyInput() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Привет, !";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
