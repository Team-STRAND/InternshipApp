package endriu.projects.libra.model.Responses;

public class MatchResponse {
    private final String pairname;
    private final String topicname;
    private final int groupid;

    public MatchResponse(String pair, String topic, int id){
        this.pairname = pair;
        this.topicname = topic;
        this.groupid = id;
    }

    public String getPairname(){
        return this.pairname;
    }

    public String getTopicname() { return this.topicname; }

    public int getGroupid() {
        return this.groupid;
    }
}
