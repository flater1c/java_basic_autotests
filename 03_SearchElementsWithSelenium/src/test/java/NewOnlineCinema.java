/* Задание 4 из урока 3.4
Запишите не менее трёх тестов для сайта онлайн-кинотеатра:
    В первом тесте реализуйте следующий сценарий:
        введите текст в поле «Ваши любимые фильмы»;
        введите текст в поле «Ваши любимые сериалы»;
        нажмите «Сохранить»;
        нажмите на кнопку 2;
        нажмите на кнопку «ВВОД»;
        нажмите на кнопку «ОК»;
        проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому, который вы вводили в поле «Ваши любимые фильмы»;
        проверьте, что после нажатия кнопки «ОК» появился текст и он равен тому, который вы вводили в поле «Ваши любимые сериалы».
    Сценарии остальных тестов выберите на своё усмотрение, опираясь на техники тест-дизайна. Для поиска элементов в тесте по возможности используйте все изученные стратегии поиска.

Задание 5 из урока 3.4
    Внесите изменения, чтобы браузер перед тестами из четвёртого задания открывался один раз и закрывался только после прохождения всех тестов из четвёртого задания.
    Сравните, на сколько быстрее стали проходить тесты на вашем компьютере после видоизменений.
    На проверку пришлите утверждение вида «в четвёртом задании все тесты проходили за N секунд. После видоизменений в пятом задании все тесты стали проходить за M секунд».
 */

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewOnlineCinema {

    private static WebDriver driver;

    @BeforeClass
        public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.ru/qa_tester/module07/practice3/");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void filmsAndSerialsInput() {
        var films = "Фильмы";
        var serials = "Сериалы";
        driver.findElement(By.tagName("input")).sendKeys(films);
        driver.findElement(By.name("serials")).sendKeys(serials);
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var filmsResult = driver.findElement(By.className("result__text")).getText();
        var serialResult = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("фильмы не совпадают", films, filmsResult);
        Assert.assertEquals("сериалы не совпадают", serials, serialResult);
        driver.navigate().refresh();
    }

    @Test
    public void emptyInput() {
        driver.findElement(By.id("two")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var filmsResult = driver.findElement(By.id("best_films")).getText();
        var serialResult = driver.findElement(By.id("best_serials")).getText();
        Assert.assertEquals("фильмы не совпадают","", filmsResult);
        Assert.assertEquals("сериалы не совпадают", "", serialResult);
        driver.navigate().refresh();
    }

    @Test
    public void inputWithoutSaving() {
        var films = "Фильмы";
        var serials = "Сериалы";
        driver.findElement(By.tagName("input")).sendKeys(films);
        driver.findElement(By.name("serials")).sendKeys(serials);
        driver.findElement(By.id("two")).click();
        driver.findElement(By.className("fake-checkbox")).click();
        driver.findElement(By.id("save")).click();
        driver.findElement(By.id("ok")).click();
        var filmsResult = driver.findElement(By.id("best_films")).getText();
        var serialResult = driver.findElement(By.id("best_serials")).getText();
        var subResult = driver.findElement(By.id("language")).getText();
        Assert.assertEquals("фильмы не совпадают","", filmsResult);
        Assert.assertEquals("сериалы не совпадают", "", serialResult);
        Assert.assertEquals("не отображается инфо про русские субтитры", "С русскими субтитрами", subResult);
        driver.navigate().refresh();
    }
}
