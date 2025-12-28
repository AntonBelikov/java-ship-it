package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerishableParcelTest {
    PerishableParcel perishableParcel = new PerishableParcel("Молоко", 21, "Ростов", 2, 10);

    @Test
    public void shouldNotExpiredLastDay() {
    assertTrue(perishableParcel.isExpired(11));
    }

    @Test
    public void shouldStartsToBeExpired() {
        assertFalse(perishableParcel.isExpired(12));
    }

    @Test
    public void shouldNotExpired() {
        assertTrue(perishableParcel.isExpired(2));
    }

    @Test
    public void shouldBeExpired() {
        assertFalse(perishableParcel.isExpired(20));
    }
}
