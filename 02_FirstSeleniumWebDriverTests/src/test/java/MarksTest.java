/* Задание 2 из урока 2.2
Что нужно сделать

    Создайте аналогично прошлому заданию проект с функцией перевода баллов экзамена в оценку.
    Покройте её автотестами (не менее десяти), которые проверяют, соответствует ли функция техническому заданию и корректно ли она работает.


Техническое задание на функцию

Ученик может заработать максимум 100 баллов, минимум 0.
Его оценка за экзамен может принимать значения 2, 3, 4 или 5.

Если ученик получил за экзамен

    от 0 баллов (включительно) до 35 (включительно): его оценка равна 2;
    от 36 баллов (включительно) до 56 (включительно): его оценка равна 3;
    от 57 баллов (включительно) до 71 (включительно): его оценка равна 4;
    от 72 баллов (включительно) до 100 баллов (включительно): его оценка равна 5.
*/

import org.junit.Assert;
import org.junit.Test;
public class MarksTest {

    @Test
    public void testMark0()
    {
        var actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testNegativeNumber()
    {
        var actualResult = getMarkResult(-1);
        Assert.assertEquals("no mark result", actualResult);
    }

    @Test
    public void testMark1()
    {
        var actualResult = getMarkResult(1);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testMark35()
    {
        var actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testMark36()
    {
        var actualResult = getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testMark56()
    {
        var actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testMark57()
    {
        var actualResult = getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void testMark71()
    {
        var actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void testMark72()
    {
        var actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testMark100()
    {
        var actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testMarkOver100()
    {
        var actualResult = getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }


    private String getMarkResult(Integer mark)

    {

        if(mark>=0 && mark <=35) return "2";

        if(mark>35 && mark <=56) return "3";

        if(mark>56 && mark<71) return "4";

        if(mark>72 && mark<100) return "5";

        return "no mark result";

    }
}
