package endriu.projects.libra.model.exceptions;

public class UserDoesNotMatchJwtException extends Exception {

    private String message = "User does not match jwt";

    public UserDoesNotMatchJwtException(){
    }
}
