package endriu.projects.libra.model.Responses;


public class RandomPreferenceResponse implements PreferenceResponse {

    private String content;

    public RandomPreferenceResponse() {}

    public RandomPreferenceResponse(String string){
        this.content = string;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
