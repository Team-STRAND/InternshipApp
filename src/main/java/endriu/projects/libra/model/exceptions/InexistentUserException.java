package endriu.projects.libra.model.exceptions;

public class InexistentUserException extends Exception {
    public InexistentUserException(){}

    public InexistentUserException(String message){
        super(message);
    }
}
