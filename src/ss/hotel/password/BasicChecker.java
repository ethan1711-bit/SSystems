package ss.hotel.password;

public class BasicChecker implements Checker {
    @Override
    public boolean acceptable(String suggestion) {
        return suggestion.length() >= 6 && !suggestion.contains(" ");
    }

    @Override
    public String generatePassword() {
        return "Password123";
    }

}
