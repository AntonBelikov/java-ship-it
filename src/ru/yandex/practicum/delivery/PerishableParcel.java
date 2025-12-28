package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    public static final int PERISHABLE_PRICE = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getConstant() {
        return PERISHABLE_PRICE;
    }

    public boolean isExpired(int currentDay) {
    return (getSendDay() + timeToLive) > currentDay;
    }

}
