package ru.job4j.poly;

public interface Transport {
    boolean drive();

    int passengers(int passengers);

    int refill(int amount);
}

