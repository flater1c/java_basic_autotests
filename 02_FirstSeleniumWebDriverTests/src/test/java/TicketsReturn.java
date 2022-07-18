/* Задание 1 из урока 2.4
Что нужно сделать

    Составьте не менее пяти тест-кейсов для этой функции. Опирайтесь в первую очередь на аналитику, примените привычные вам техники тест-дизайна.
    Оформите сценарии в виде автотестов JUnit.


Аналитика

В случае отказа от посещения мероприятия по причинам, не связанным с отменой/переносом мероприятия, посетитель имеет право при возврате билета:

    За 10 и более дней — получить обратно полную стоимость билета.
    От 6 до 10 дней включительно — получить 50% стоимости билета.
    От 3 до 5 дней включительно — получить 30% стоимости билета.
    За 72 часа и менее до начала концерта — стоимость билета не возвращается.
*/

import org.junit.Assert;
import org.junit.Test;

public class TicketsReturn {
    @Test
    public void moreThanTenDays() {
        long actualResult = getRefundTicketPricePercent(241,false,false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void tenDays() {
        long actualResult = getRefundTicketPricePercent(240,false,false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void nineDays() {
        long actualResult = getRefundTicketPricePercent(216,false,false);
        Assert.assertEquals(50, actualResult);
    }

    @Test
    public void sixDays() {
        long actualResult = getRefundTicketPricePercent(144,false,false);
        Assert.assertEquals(50, actualResult);
    }

    @Test
    public void fiveDays() {
        long actualResult = getRefundTicketPricePercent(120,false,false);
        Assert.assertEquals(30, actualResult);
    }

    @Test
    public void threeDays() {
        long actualResult = getRefundTicketPricePercent(72,false,false);
        Assert.assertEquals(0, actualResult);
    }

    @Test
    public void oneHour() {
        long actualResult = getRefundTicketPricePercent(1,false,false);
        Assert.assertEquals(0, actualResult);
    }

    @Test
    public void negativeNumber() {
        long actualResult = getRefundTicketPricePercent(-1,false,false);
        Assert.assertEquals(0, actualResult);
    }

    @Test
    public void concertCancelled() {
        long actualResult = getRefundTicketPricePercent(24,true,false);
        Assert.assertEquals(100, actualResult);
    }

    @Test
    public void concertRescheduled() {
        long actualResult = getRefundTicketPricePercent(24,false,true);
        Assert.assertEquals(100, actualResult);
    }

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled) {
        if(wasConcertCancelled && wasConcertRescheduled) return 100;
        if(hoursBeforeConcert>240) return 100;
        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;
        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;
        return 0;
    }
}
