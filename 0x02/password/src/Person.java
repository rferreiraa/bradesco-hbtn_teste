package src;

public class Person {

    public boolean checkUser(String username) {
        if (username == null || username.length() < 8) return false;

        if (!username.matches("[A-Za-z0-9]+")) return false;

        return true;
    }

    public boolean checkPassword(String password) {
        if (password == null || password.length() < 8) return false;

        if (!password.matches(".*[A-Z].*")) return false;

        if (!password.matches(".*[0-9].*")) return false;

        if (!password.matches(".*[^A-Za-z0-9].*")) return false;

        return true;
    }
}
