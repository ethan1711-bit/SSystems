package ss.hotel.password;

public class Password {
    private Checker checker;
    private String initPass;
    /**
     * Returns the initial password.
     * @return the initial password string
     */
    public Password(Checker checker) {
        this.checker = checker;
        this.initPass = checker.generatePassword();
    }

    public Password(){
        this(new BasicChecker());
    }
    /**
     * Returns the Checker object.
     * @return the Checker object
     */
    public Checker getChecker(){
        return checker;
    }
    /**
     * Checks if the given password is acceptable.
     * @param suggestion the password to check
     * @return true if the password is acceptable, false otherwise
     */
    public Boolean acceptable(String suggestion) {
        return checker.acceptable(suggestion);
    }
    /**
     * Tests if the given password matches the initial password.
     * @param test the password to test
     * @return true if the password matches the initial password, false otherwise
     */
    public boolean testWord(String test) {
        return initPass.equals(test);
    }
    /**
     * Sets a new password if the old password is correct and the new password is acceptable.
     * @param oldPass the old password
     * @param newPass the new password
     * @return true if the password was successfully changed, false otherwise
     */
    public boolean setWord(String oldPass, String newPass) {
        if (testWord(oldPass) && acceptable(newPass)) {
            initPass = newPass;
            return true;
        }
        return false;
    }
}
