package endriu.projects.libra.model.Responses;

public class NoPreferencesResponse implements PreferenceResponse {
    private String content;

    public NoPreferencesResponse(String msg){
        this.content = msg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = message;
    }
}
