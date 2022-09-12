package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User temp = null;
        for (int i = 0; i < users.length; i++) {
            if (!users[i].getUsername().equals(login)) {
                throw new UserNotFoundException("User not found");
            } else {
                temp = users[i];
            }
        }
        return temp;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() && user.getUsername().length() < 3) {
            throw new UserInvalidException("Invalid user");
        }
        return true;
    }

    public static void main(String[] args) {
        try {
        User[] users = {
                new User("Petr Arsentev", true)
        };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException en) {
            en.printStackTrace();
        }
    }
}
