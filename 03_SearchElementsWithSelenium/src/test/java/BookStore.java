/* Задания 2 и 3 из урока 3.4
1. Запишите тест для сайта книжного магазина. В этом тесте не будет действий, только поиск элементов по локаторам.

2. Запишите тест для сайта книжного магазина:
    В тесте осуществите переход на сайт.
    Найдите с помощью функции findElements все элементы <div class="book-info">.
    Проверьте, что их ровно 15 штук.
 */

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStore {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/hamster/autotesting-java-basics/02_FirstSeleniumWebDriverTests/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void locatorSearch() {
        var feedback = driver.findElement(By.linkText("Обратная связь"));
        var preorder = driver.findElement(By.linkText("Предзаказы"));
        var addToCart = driver.findElement(By.className("book-add"));
        var cartCount = driver.findElement(By.id("cart_count"));
        var booksCategory = driver.findElement(By.linkText("Книги"));
        var search = driver.findElement(By.name("search-input-form"));
    }

    @Test
    public void itemsCountTest() {
        var actualResult = driver.findElements(By.className("book-info"));
        Assert.assertEquals("Неверное кол-во книг на странице", 15, actualResult.size());
    }

}
