package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> newAccount = new ArrayList<>();
        users.putIfAbsent(user, newAccount);
    }

    public boolean deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user != null) {
            users.remove(user);
            return true;
        }
        return false;
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> acc = getAccounts(user);
        if (user != null && !acc.contains(account)) {
            acc.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        double srcAccBalance = srcAcc.getBalance();
        if (srcAcc != null && destAcc != null && srcAccBalance >= amount) {
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}