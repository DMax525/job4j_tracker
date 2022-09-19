package ru.job4j.early;

import static java.lang.Character.*;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Enter the password");
        }

        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Your password must be 8-32 characters long");
        }

        char[] array = password.toCharArray();
        int rsl = 0;

        if (password.equals(password.toLowerCase())) {
            throw new IllegalArgumentException("Your password must must contain at least one upper case character");
        }

        if (password.equals(password.toUpperCase())) {
            throw new IllegalArgumentException("Your password must contain at least one lower case character");
        }

        for (int i : array) {
            if (isDigit(i)) {
                rsl++;
            }
        }
        if (rsl == 0) {
            throw new IllegalArgumentException("Your password must contain at least one digit");
        }

        rsl = 0;

        for (int i : array) {
            if (!isLetterOrDigit(i)) {
                rsl++;
            }
        }
        if (rsl == 0) {
            throw new IllegalArgumentException("Your password must contain at least one special symbol");
        }
        return password;
    }
}
