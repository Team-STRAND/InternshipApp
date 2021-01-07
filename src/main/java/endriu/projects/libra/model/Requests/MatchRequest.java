package endriu.projects.libra.model.Requests;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;

public class MatchRequest {
    private String username;
    private String topic;

    public MatchRequest(){}

    public MatchRequest(String username, String topic) {
        this.username = username;
        this.topic = topic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
