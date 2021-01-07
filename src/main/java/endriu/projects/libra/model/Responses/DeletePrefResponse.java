package endriu.projects.libra.model.Responses;

public class DeletePrefResponse implements PreferenceResponse {

    private String message;

    public DeletePrefResponse() {
    }

    public DeletePrefResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
