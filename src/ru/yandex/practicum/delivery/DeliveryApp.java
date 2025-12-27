package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static ArrayList<FragileParcel> tracckableFragile = new ArrayList<>();
    private static ParcelBox<StandardParcel> standartBox = new ParcelBox<>(100000);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(80000);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(50000);

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
                case 4:
                    reportStatus();
                    break;
                case 5:
                    System.out.println("Выберите тип посылок:");
                    System.out.println("1 — обычные");
                    System.out.println("2 — скоропортящиеся");
                    System.out.println("3 — хрупкие");

                    int type = Integer.parseInt(scanner.nextLine());

                    switch (type) {
                        case 1:
                            standartBox.getAllParcels();
                            break;
                        case 2:
                            perishableBox.getAllParcels();
                            break;
                        case 3:
                            fragileBox.getAllParcels();
                            break;
                        default:
                            System.out.println("Данного типа нет");
                    }

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
        System.out.println("4 — Отследить хрупкие посылки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Введите вес посылки");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки");
        int sendDay = Integer.parseInt(scanner.nextLine());

        System.out.println("Добавьте описание");
        String description = scanner.nextLine();

        System.out.println("Выберите тип посылки");
        System.out.println("1 — обычная");
        System.out.println("2 — скоропортящаяся");
        System.out.println("3 — хрупкая");

        int type = Integer.parseInt(scanner.nextLine());
        Parcel parcel;

        switch (type) {
            case 1:
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(parcel);
                standartBox.addParcel((StandardParcel) parcel);
                break;
            case 2:
                System.out.println("Введите срок годности");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(parcel);
                perishableBox.addParcel((PerishableParcel) parcel);
                break;
            case 3:
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(parcel);
                tracckableFragile.add((FragileParcel)parcel);
                fragileBox.addParcel((FragileParcel) parcel);
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

    private static void reportStatus() {
        for (FragileParcel fragileParcel : tracckableFragile) {
            System.out.println("Введите местоположение посылки " + fragileParcel.getDescription());
            fragileParcel.reportStatus(scanner.nextLine());
        }
    }

}

