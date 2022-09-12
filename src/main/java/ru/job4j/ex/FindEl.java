package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (!value[i].equals(key)) {
                throw new ElementNotFoundException("Element not found");
            } else {
                rsl = i;
            }
        }
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        return rsl;
    }
}
