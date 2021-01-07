package endriu.projects.libra.model.Responses;

public class RegistrationResponse {

    private String message;

    public RegistrationResponse(String code) {
        this.message = code;
    }

    public String getCode() {
        return message;
    }

}
