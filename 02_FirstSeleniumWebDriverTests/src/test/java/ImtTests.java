/* Задание 1 из урока 2.2
Что нужно сделать

    Создайте проект Maven.
    Подключите к нему JUnit.
    Добавьте в проект функцию.
    Составьте тест-кейсы по аналогии с ручным тестированием для функции ИМТ, опираясь на её ожидаемое поведение из аналитики. Для этого примените привычные вам техники тест-дизайна.
    Оформите их в виде автотестов JUnit.

Функция расчёта результата должна возвращать следующее:

    Для роста <= 0 см или > 350 см: «указан некорректный рост».
    Для веса <= 0 или > 1000 кг: «указан некорректный вес».
    Для ИМТ > 0 и <= 16: «выраженный дефицит массы тела».
    Для ИМТ > 16 и ИМТ < 19: «недостаточная масса тела».
    Для ИМТ >= 19 и ИМТ < 25: «нормальная масса тела».
    Для ИМТ >= 25: «избыточная масса тела».

*/
import org.junit.Assert;
import org.junit.Test;

public class ImtTests {
    @Test
    public void testNormalWeight()
    {
        var actualResult = getIMTResult(180f,75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testWeightDeficit() {
        var actualResult = getIMTResult(190f,40f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    @Test
    public void testWeightExcess() {
        var actualResult = getIMTResult(140f,100f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }

    @Test
    public void testWeightLack() {
        var actualResult = getIMTResult(180f,60f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    @Test
    public void testZeroHeight() {
        var actualResult = getIMTResult(0f,65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    private String getIMTResult(Float heightCm, Float weightKg)    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;

    }
}
