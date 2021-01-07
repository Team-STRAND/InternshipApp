package endriu.projects.libra.model.Requests;

public class DeletePrefRequest {

    private String preference;

    public DeletePrefRequest() {}

    public DeletePrefRequest( String preference) {
        this.preference = preference;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
