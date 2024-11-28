package ss.hotel.password;

public class StrongChecker extends BasicChecker {
    @Override
    public boolean acceptable(String suggestion){
        if(!super.acceptable(suggestion)){
            return false;
        }
        return Character.isLetter(suggestion.charAt(0)) && Character.isDigit(suggestion.charAt(suggestion.length()-1));
    }

    @Override
    public String generatePassword() {
        return super.generatePassword();
    }
}
