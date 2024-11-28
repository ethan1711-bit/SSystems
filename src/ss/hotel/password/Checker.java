package ss.hotel.password;

public interface Checker {
    /**
     * Checks if the given password is acceptable.
     *
     * @param suggestion the password to check
     * @return true if the password is acceptable, false otherwise
     */
    boolean acceptable(String suggestion);

    /**
     * Generates an example of an acceptable password.
     *
     * @return an acceptable password string
     */
    String generatePassword();


}
