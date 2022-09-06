package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public boolean drive() {
        return drive();
    }

    @Override
    public int passengers(int passengers) {
        return passengers;
    }

    @Override
    public int refill(int amount) {
        int price = 50;
        return price * amount;
    }
}
