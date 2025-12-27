package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {
    public static final int FRAGILE_PRICE = 4;
    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getConstant() {
        return FRAGILE_PRICE;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + getDescription() + " обёрнута в защитную плёнку");
        super.packageItem();
    }
}
