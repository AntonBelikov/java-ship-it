package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ParcelBoxTest {
    private static ParcelBox<StandardParcel> parcelBox;

    @BeforeEach
    public void beforeEach() {
        parcelBox = new ParcelBox<>(10000);
    }

    @Test
    public void shouldReturnNotNullAmount() {
        StandardParcel standardParcel = new StandardParcel("Черенки", 40, "Тула", 2);
        parcelBox.addParcel(standardParcel);
        assertNotNull(parcelBox.getObj());
    }

    @Test
    public void shouldReturnNullAmount22500() {
        StandardParcel aluminumParsel = new StandardParcel("Алюминий", 225000, "Кострома", 3);
        parcelBox.addParcel(aluminumParsel);
        assertNull(parcelBox.getObj());
    }

    @Test
    public void shouldReturnNullAmount10001() {
        StandardParcel FerParsel = new StandardParcel("Железо", 10001, "Челябинск", 7);
        parcelBox.addParcel(FerParsel);
        assertNull(parcelBox.getObj());
    }
}
