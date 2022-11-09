package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка
 */
public class User {
    /**
     * Поле passport используется для хранения данных
     * паспорта пользователя {@link User}
     */
    private String passport;
    /**
     * Поле username используется для хранения
     * имени пользователя {@link User}
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер для поля passport
     * @return номер паспорта пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер для поля passport
     * @param passport номер паспорта пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер для поля username
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер для поля username
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
