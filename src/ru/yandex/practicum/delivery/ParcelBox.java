package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends  Parcel> {
    private final int maxWeight;
    private final ArrayList<T> parcels;
    private int startWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.startWeight = 0;
        parcels = new ArrayList<>();
    }

    public void addParcel(T parsel) {
        startWeight += parsel.getWeight();

        if (startWeight <= maxWeight) {
            parcels.add(parsel);
            return;
        }

        startWeight -= parsel.getWeight();
        System.out.println("Вес превышен, посылка не добавлена в коробку");
    }

    public void getAllParcels() {
        for (T parsel : parcels) {
            System.out.println(parsel.getDescription());
        }
    }

    public T getObj() {
        for (T parsel : parcels) {
            return parsel;
        }
        return null;
    }
}
