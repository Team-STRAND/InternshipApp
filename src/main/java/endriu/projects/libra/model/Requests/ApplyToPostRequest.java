package endriu.projects.libra.model.Requests;

public class ApplyToPostRequest {
    private int userid;

    public ApplyToPostRequest() {}

    public ApplyToPostRequest(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
