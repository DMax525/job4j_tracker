package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Количество пассажиров: " + passengers);
    }

    @Override
    public int refill(int amount) {
        int price = 50;
        return price * amount;
    }
}
