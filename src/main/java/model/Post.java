package model;

import javax.xml.crypto.Data;
import java.util.List;

public class Post {
    private Integer id;
    private String content;
    private Data created;
    private Data updated;
    private List<Label> labels;
    private PostStatus status;

    public Post() {
    }

    public Post(Integer id, String content, Data created, Data updated, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.labels = labels;
    }
}
