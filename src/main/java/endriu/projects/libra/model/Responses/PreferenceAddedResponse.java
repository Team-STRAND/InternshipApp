package endriu.projects.libra.model.Responses;

public class PreferenceAddedResponse {
    private String message;

    public PreferenceAddedResponse() {}

    public PreferenceAddedResponse(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg){
        this.message = msg;
    }
}
