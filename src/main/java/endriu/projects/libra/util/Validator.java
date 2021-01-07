package endriu.projects.libra.util;

import endriu.projects.libra.model.exceptions.InvalidInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static String ILLEGAL_CHARS = "!\\@#$%^\"'/&*-()_";

    public static void validateUser(String email, String password) throws InvalidInputException{
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence) email);

        if (!matcher.matches() || checkIllegal(password)){
            throw new InvalidInputException("Input data is illegal");
        }
    }

    public static void validateUserDetails(String name, String surname, String password) throws InvalidInputException{
        if (checkIllegal(name) || checkIllegal(surname) || checkIllegal(password)){
            throw new InvalidInputException("Input data is illegal");
        }
    }

    private static boolean checkIllegal(String string) {
        for (int i = 0; i < ILLEGAL_CHARS.length(); i++){
            if (string.indexOf(ILLEGAL_CHARS.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }

}
