package endriu.projects.libra.util;

import endriu.projects.libra.model.exceptions.InvalidInputException;

public class Validator {

    private static String ILLEGAL_CHARS = "!\\@#$%^\"'/&*-()_";

    public static void validateUser(String username, String password) throws InvalidInputException{
        if (checkLegal(username) || checkLegal(password) || username.length() < 5 || username.length() > 20){
            throw new InvalidInputException("Input data is illegal");
        }
    }

    public static boolean checkLegal(String string) {
        for (int i = 0; i < ILLEGAL_CHARS.length(); i++){
            if (string.indexOf(ILLEGAL_CHARS.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }



}
