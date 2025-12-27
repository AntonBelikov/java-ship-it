package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        System.out.println("Выберите тип посылки");
        System.out.println("1 — обычная");
        System.out.println("2 — скоропортящаяся");
        System.out.println("3 — хрупкая");

        Parcel parcel;
        String description;
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                description = "обычная";
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(parcel);
                break;
            case 2:
                description = "скоропортящаяся";
                System.out.println("Введите срок годности");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(parcel);
                break;
            case 3:
                description = "хрупкая";
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(parcel);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Сумма доставки = " + sum + " руб.");
    }

}

