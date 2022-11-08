package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl;
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            rsl = Character.compare(left.charAt(i), right.charAt(i));
            if (rsl > 0) {
                return 1;
            } else if (rsl < 0) {
                return -1;
            }
        }
        rsl = Integer.compare(left.length(), right.length());
        return rsl;
    }
}