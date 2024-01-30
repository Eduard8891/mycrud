package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Label {
    private Integer id;
    private String name;
    private PostStatus status;

    public Label(String name, Integer id) {
        this.name = name;
        this.id = id;
        status = PostStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return name;
    }
}

