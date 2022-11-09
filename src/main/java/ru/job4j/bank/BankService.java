package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс представляет собой банковский сервис, который позволяет
 * взаимодействовать с классами {@link Account} и {@link User}.
 */
public class BankService {
    /**
     * Хранение пользователей {@link User} осуществляется в карте типа HashMap,
     * где ключом является пользователь {@link User}, а значением его банковский счет {@link Account}
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя {@link User} в хранилище users
     * и создает ассоциированный с ним пустой список List для банковского счета {@link Account}
     * @param user пользователь, которго нужно добавить
     */
    public void addUser(User user) {
        List<Account> newAccount = new ArrayList<>();
        users.putIfAbsent(user, newAccount);
    }

    /**
     * Метод осущесвляет удаление пользователя {@link User} из ханилища users
     * @param passport как наиболее уникальный идентификатор пользователя
     * @return true при успешном удалении
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, null)) != null;
    }

    /**
     * Метод находит существующего пользователя {@link User}
     * в базе users по номеру паспорта и добавляет к нему
     * передаваемый в параметрах метода банковский счет,
     * если такого счета у пользователя ещё нет
     * @param passport как наиболее уникальный идентификатор пользователя
     * @param account банковский счет, который нужно добавить пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> acc = getAccounts(user);
        if (user != null && !acc.contains(account)) {
            acc.add(account);
        }
    }

    /**
     * Метод находит пользователя {@link User} по номеру паспорта
     * @param passport как наиболее уникальный идентификатор пользователя
     * @return пользователя {@link User} либо null, если пользователь
     * с заданным номером паспорта не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод находит счет пользователя {@link User} по передаваемому в метод номеру паспорта,
     * затем находит ассоциированный с пользователем счет по передаваемым в метод реквизитам
     * @param passport как наиболее уникальный идентификатор пользователя
     * @param requisite реквизиты счета пользователя
     * @return найденный счет пользователя {@link Account} либо null, если ничего не найдено
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : getAccounts(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод для перевода денег с одного счета на другой
     * @param srcPassport номера паспорта отправителя
     * @param srcRequisite реквзиты счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite реквизиты счета получателя
     * @param amount перечисляемая сумма
     * @return true, если отправитель и получатель {@link User} и их счета {@link Account}
     * найдены в базе users, и если на счете отправителя достаточно средств для перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            destAcc.setBalance(destAcc.getBalance() + amount);
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод для получения списка всех ассоциируемых
     * с пользователем счетов из базы users
     * @param user пользователь, чьи счета необходимо найти
     * @return список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}