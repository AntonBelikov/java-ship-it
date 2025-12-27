package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends  Parcel> {
    private int maxWeight;
    ArrayList<T> parcels = new ArrayList<>();
    private int startWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.startWeight = 0;
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
}
