package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 */
public class Account {
    /**
     * Поле requisite используется для хранения реквизитов
     * банковского счета пользователя {@link User}
     */
    private String requisite;
    /**
     * Поле balance используется для хранения баланса
     * банковского счета пользователя {@link User}
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер поля requisite
     * @return реквизиты пользователя {@link User}
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер поля requisite
     * @param requisite реквизиты, которые необходимо присвоить
     * счету пользователя {@link User}
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер баланса
     * @return баланс пользователя счета пользователя {@link User}
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер баланса
     * @param balance баланс, который нужно установить
     * на счете пользователя пользователя {@link User}
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
