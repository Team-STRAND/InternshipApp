package endriu.projects.libra.model.Requests;

public class AddPrefRequest {
    private String preference;

    public AddPrefRequest() {}

    public AddPrefRequest(String preference) {
        this.preference = preference;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
