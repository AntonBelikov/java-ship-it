package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;
import ru.yandex.practicum.delivery.FragileParcel;

public class DeliveryCostTest {

    @Test
    public void shouldBe12ForWeight4ForPerishable() {
        PerishableParcel perishableParcel = new PerishableParcel("Колбаса", 4, "Сочи", 12, 60);
        Assertions.assertEquals(12, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe300ForWeight100ForPerishable() {
        PerishableParcel perishableParcel = new PerishableParcel("Мясо", 100, "Самара", 11, 20);
        Assertions.assertEquals(300, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe200ForWeight100ForStandart() {
        StandardParcel standardParcel = new StandardParcel("Бумага", 100, "Москва", 2);
        Assertions.assertEquals(200, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe70ForWeight35ForStandart() {
        StandardParcel standardParcel = new StandardParcel("Конверты", 35, "Екатеринбург", 1);
        Assertions.assertEquals(70, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe400ForWeight100ForFragile() {
        FragileParcel fragileParcel = new FragileParcel("Стекло", 100, "Сургут", 7);
        Assertions.assertEquals(400, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBe200ForWeight50ForFragile() {
        FragileParcel fragileParcel = new FragileParcel("Керамика", 50, "Лондон", 5);
        Assertions.assertEquals(200, fragileParcel.calculateDeliveryCost());
    }
}
