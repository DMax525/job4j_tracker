package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        String[] array = {"Pipa", "Pupa"};
        String key = "Baba";
        try {
            FindEl.indexOf(array, key);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}