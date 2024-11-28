package ss.hotel;

public class BasicPassword {
    public static final String INITIAL = "initial";

    private String password;

    public BasicPassword() {
        this.password = INITIAL;
    }

    public boolean acceptable(String suggestion) {
        return suggestion.length() >= 6 && !suggestion.contains(" ");
    }

    public boolean testWord(String test) {
        return this.password.equals(test);
    }

    public boolean setWord(String oldPass, String newPass) {
        if (testWord(oldPass) && acceptable(newPass)) {
            this.password = newPass;
            return true;
        }
        return false;
    }
}