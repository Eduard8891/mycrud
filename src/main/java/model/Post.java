package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer id;
    private String content;
    private Date created;
    private Date updated;
    private List<Label> labels;
    private PostStatus status;
}
