package ru.job4j.ex;

public class FindElInArray {

    public static void main(String[] args) {
        String[] array = {"Pipa", "Pupa"};
        String key = "Pupa";
        try {
            FindEl.indexOf(array, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
