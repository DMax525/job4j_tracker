package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public boolean drive() {
        return false;
    }

    @Override
    public int passengers(int passengers) {
        return 0;
    }

    @Override
    public int refill(int amount) {
        return 0;
    }
}
