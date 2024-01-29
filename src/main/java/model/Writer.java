package model;

import java.util.List;

public class Writer {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private PostStatus status;

    public Writer() {
    }

    public Writer(Integer id, String firstName, String lastName, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }
}
